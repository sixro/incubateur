package saver;

import java.lang.reflect.*;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.*;

public class Saver<I, D extends I> implements InvocationHandler {

	private static final Log LOG = LogFactory.getLog(Saver.class);
	
	private final Class<I> interfaceType;
	private final D delegate;
	
	private final Map<Method, Cache> caches;
	
	public Saver(Class<I> interfaceType, D delegate) {
		super();
		this.interfaceType = interfaceType;
		this.delegate = delegate;
		
		this.caches = new HashMap<>();
	}

	public static <I, D extends I> Saver<I, D> aSaver(Class<I> interfaceType, D delegate) {
		return new Saver<I, D>(interfaceType, delegate);
	}
	
	@SuppressWarnings("unchecked")
	public I toProxy() {
		return (I) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(), 
				new Class<?>[]{ interfaceType }, 
				this
		);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String callPrefix = "[" + interfaceType.getName() + "#" + method.getName() + "(" + StringUtils.join(args) + ")] ";
		if (LOG.isDebugEnabled()) LOG.debug(callPrefix + "intercepted call...");
		long start = System.currentTimeMillis();
		
		Class<? extends Object> delegateType = delegate.getClass();
		Method delegateMethod = delegateType.getMethod(method.getName(), method.getParameterTypes());
		saver.CacheControl cacheAnnotation = delegateMethod.getAnnotation(saver.CacheControl.class);
		if (cacheAnnotation == null) {
			Object value = method.invoke(delegate, args);
			
			if (LOG.isInfoEnabled()) LOG.info(callPrefix + "(" + elapsed(start) + " ms) no cache annotation found, returning value provided by delegate");
			return value;
		}
		
		Cache cache = getCache(delegateType, delegateMethod, cacheAnnotation);
		CallKey key = newCallKey(delegateType, delegateMethod, args);
		if (LOG.isDebugEnabled()) LOG.debug(callPrefix + "looking for a value cached with key " + key + "...");
		
		Object value = cache.get(key);
		if (value != null) {
			if (LOG.isInfoEnabled()) LOG.info(callPrefix + "(" + elapsed(start) + " ms) returning cached value: " + value);
			return value;
		}
		
		if (LOG.isDebugEnabled()) LOG.debug(callPrefix + "no value cached, calling delegate...");
		value = method.invoke(delegate, args);
		cache.put(key, value);
		
		if (LOG.isInfoEnabled()) LOG.info(callPrefix + "(" + elapsed(start) + " ms) called delegate and cached returned value");
		return value;
	}

	protected Cache getCache(Class<? extends Object> delegateType, Method delegateMethod, saver.CacheControl cacheAnnotation) {
		String expireAt = cacheAnnotation.expireAt();

		Map<String, Object> cacheConfig = new HashMap<String, Object>();
		cacheConfig.put("expireAt", expireAt);
		
		return getCache(delegateType, delegateMethod, cacheConfig);
	}

	protected Cache getCache(Class<? extends Object> delegateType, Method delegateMethod, Map<String, Object> cacheConfig) {
		return null;
	}

	protected CallKey newCallKey(Class<? extends Object> delegateType, Method delegateMethod, Object[] args) {
		return new CallKey(delegateMethod, args);
	}

	private long elapsed(long start) {
		return System.currentTimeMillis() - start;
	}
	
}
