package spring.mvc;

import spring.core.MyApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Gorilla
 * @Date: Created in 15:27 2019/2/21
 * @QQ: 904878659
 * 自定义Spring的核心控制器,负责请求转发
 */
public class MyDispatcherServlet extends HttpServlet {

    private MyHandlerMapping myHandlerMapping;
    @Override
    public void init() throws ServletException {
        // 创建spring容器
        String basePackage = "cn.edu.just";
        MyApplicationContext myApplicationContext = new MyApplicationContext(basePackage);

        // 建立映射管理
        myHandlerMapping = new MyHandlerMapping();

        // 建立映射
        myHandlerMapping.createMapping(myApplicationContext);
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据url找到映射的controller
        String uri = req.getRequestURI();

        MyHandlerMethod myHandlerMethod = myHandlerMapping.getRegistry().get(uri);

        if (myHandlerMethod != null) {
            Object controller = myHandlerMethod.getController();

            Method method = myHandlerMethod.getMethod();

            try {
                Object o = method.invoke(controller);

                resp.getWriter().write(o.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            resp.setStatus(404);
        }

    }


}
