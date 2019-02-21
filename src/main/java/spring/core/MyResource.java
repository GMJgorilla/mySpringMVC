package spring.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Gorilla
 * @Date: Created in 17:59 2019/2/20
 * @QQ: 904878659
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyResource {

    public String value() default "";
}
