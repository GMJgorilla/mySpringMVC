package spring.mvc;

import java.lang.reflect.Method;

/**
 * @Author: Gorilla
 * @Date: Created in 16:38 2019/2/21
 * @QQ: 904878659
 */
public class MyHandlerMethod {
    private Object controller;
    private Method method;

    public Object getController() {
        return controller;
    }

    public Method getMethod() {
        return method;
    }

    public MyHandlerMethod(Object controller, Method method) {
        this.controller = controller;
        this.method = method;
    }

    public MyHandlerMethod() {
    }
}
