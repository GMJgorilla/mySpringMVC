package spring.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Gorilla
 * @Date: Created in 11:23 2019/2/20
 * @QQ: 904878659
 */

@Target(ElementType.TYPE) // 作用在类上
@Retention(RetentionPolicy.RUNTIME) // 运行时获取
public @interface MyComponent {
}
