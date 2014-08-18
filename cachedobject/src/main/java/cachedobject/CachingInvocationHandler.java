package cachedobject;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

class CachingInvocationHandler implements InvocationHandler {

    private static final Log LOG = LogFactory.getLog(CachingInvocationHandler.class);

    private Map<String, CacheInfo> cache;

    private Object interfaceClass;
    private Object delegate;

    public CachingInvocationHandler(Object interfaceClass, Object delegate) {
        this.interfaceClass = interfaceClass;
        this.delegate = delegate;

        this.cache = new LinkedHashMap<String, CacheInfo>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (LOG.isInfoEnabled()) LOG.info("invoking method '" + methodName + "' with args " + Arrays.toString(args) + "...");

        GregorianCalendar now = new GregorianCalendar();
        if (LOG.isDebugEnabled()) LOG.debug("... now is " + DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss,SSS") + "...");

        Class[] parameterTypes = toParameterTypes(args);
        String key = newKey(methodName, args);
        if (LOG.isDebugEnabled()) LOG.debug("... key is '" + key + "', checking if values has already been cached...");

        CacheInfo cacheInfo = cache.get(key);
        if (cacheInfo != null) {
            if (LOG.isDebugEnabled()) LOG.debug("... a value for key '" + key + "' has been cached with validity " + DateFormatUtils.format(cacheInfo.getValidityEnd(), "yyyy-MM-dd HH:mm:ss,SSS") + "...");
            if (cacheInfo.getValidityEnd().after(now.getTime())) {
                Object result = cacheInfo.getObject();
                if (LOG.isInfoEnabled()) LOG.info("... returning cached " + result);
                return result;
            } else {
                if (LOG.isDebugEnabled()) LOG.debug("... value is not valid anymore!");
            }
        }

        Method delegateMethod = findMethod(delegate.getClass(), methodName, parameterTypes);
        if (LOG.isDebugEnabled()) LOG.debug("... invoking delegate...");
        Object result = delegateMethod.invoke(delegate, args);
        if (LOG.isDebugEnabled()) LOG.debug("... obtained " + result + ", caching it with key '" + key + "'...");

        Annotation[] annotations = delegateMethod.getAnnotations();
        Cache annotation = delegateMethod.getAnnotation(Cache.class);
        if (annotation != null) {
            now.add(Calendar.SECOND, annotation.maxAge());
            if (LOG.isDebugEnabled()) LOG.debug("... validity of cached object is " + DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss,SSS") + "...");
            cacheInfo = new CacheInfo(now.getTime(), result);
            cache.put(key, cacheInfo);
        } else {
            if (LOG.isInfoEnabled()) LOG.info("... none " + Cache.class.getName() + " annotation found. Value will not be cached!");
        }

        if (LOG.isInfoEnabled()) LOG.info("... returning " + result);
        return result;
    }

    private String newKey(String methodName, Object[] args) {
        String[] texts = new String[]{ };
        if (args != null) {
            texts = new String[args.length];
            for (int i = 0; i < args.length; i++)
                texts[i] = (args[i] != null) ? args[i].toString() : "<null>";
        }

        return new StringBuilder(methodName)
            .append("(")
            .append(StringUtils.join(texts, ", "))
            .append(")")
            .toString();
    }

    protected static Class[] toParameterTypes(Object[] args) {
        if (args == null || args.length == 0)
            return new Class<?>[]{ };

        Class<?>[] types = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++)
            types[i] = args[i] != null ? args[i].getClass() : null;
        return types;
    }

    protected static Method findMethod(Class<?> objectClass, String methodName, Class<?>[] parameterTypes) {
        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
            if (! method.getName().equals(methodName)) continue;

            if (matchParameterTypes(method.getParameterTypes(), parameterTypes))
                return method;
        }

        throw new IllegalArgumentException("Unable to find a method '" + methodName + "' in object " + objectClass.getName() + " accepting parameter types " + Arrays.toString(parameterTypes));
    }

    protected static boolean matchParameterTypes(Class<?>[] parameterTypes1, Class<?>[] parameterTypes2) {
        if (parameterTypes1 == null || parameterTypes1.length == 0)
            return parameterTypes2 == null || parameterTypes2.length == 0;

        if (parameterTypes1.length != parameterTypes2.length)
            return false;

        boolean equals = true;
        for (int i = 0; i < parameterTypes1.length; i++) {
            Class<?> class1 = ClassUtils.primitiveToWrapper(parameterTypes1[i]);
            Class<?> class2 = ClassUtils.primitiveToWrapper(parameterTypes2[i]);

            // NOTE: if a parameter of parameterTypes2 is null we skip the check 'cause we need
            //       to find methods in this case too... well the use of null is a smell of the developer, but we
            //       need to provide it
            if (class2 == null) continue;

            if (! class1.equals(class2)) {
                equals = false;
                break;
            }
        }
        return equals;
    }

}
