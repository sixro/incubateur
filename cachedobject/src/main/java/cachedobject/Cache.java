package cachedobject;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    /**
     * Number of seconds to cache a value obtained by an invocation.
     * @return number of seconds to cache a value obtained by an invocation
     */
    public int maxAge() default 0;

}
