package spring.mvc;

import spring.core.MyApplicationContext;
import spring.utlis.SpringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**建立映射管理
 * @Author: Gorilla
 * @Date: Created in 16:30 2019/2/21
 * @QQ: 904878659
 */
public class MyHandlerMapping {

    private HashMap<String, MyHandlerMethod> registry = new HashMap<>();

    public void createMapping(MyApplicationContext myApplicationContext) {
        LinkedHashSet<Class> classes = myApplicationContext.getScanner().getClasses();

        for (Class clazz : classes) {

            if (clazz.isAnnotationPresent(MyController.class)) {

                // 获取有MyController注解的类下的所有的方法
                Method[] methods = clazz.getMethods();

                for (Method method : methods) {

                    // 判断是否有MyRequestMapping注解
                    if (method.isAnnotationPresent(MyRequestMapping.class)) {

                        // 获取这个注解
                        MyRequestMapping annotation = method.getAnnotation(MyRequestMapping.class);
                        // 获取注解上的值
                        String uri = annotation.value();

                        String controllerId = SpringUtils.lowerFirstChar(clazz.getSimpleName());

                        // 到容器中查找controller实例
                        Object controller = myApplicationContext.getBean(controllerId);

                        // 封装controller和method
                        MyHandlerMethod myHandlerMethod = new MyHandlerMethod(controller, method);

                        // 建立映射
                        registry.put(uri, myHandlerMethod);
                    }
                }
            }
        }
    }

    public HashMap<String, MyHandlerMethod> getRegistry() {
        return registry;
    }
}
