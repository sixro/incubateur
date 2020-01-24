package saver;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheControl {

	/**
	 * time... TODO
	 * @return
	 */
	// TODO add this later...
	//String expireAfter() default "";

	/**
	 * cron... TODO
	 * @return
	 */
	String expireAt() default "";

}
