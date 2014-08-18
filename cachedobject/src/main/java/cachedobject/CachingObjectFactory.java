package cachedobject;

import java.lang.reflect.Proxy;

public class CachingObjectFactory {

    public static <I, C extends I> I newCachingObject(Class<I> interfaceClass, C delegate) {
        return (I) Proxy.newProxyInstance(
                CachingObjectFactory.class.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new CachingInvocationHandler(interfaceClass, delegate)
        );
    }

}
