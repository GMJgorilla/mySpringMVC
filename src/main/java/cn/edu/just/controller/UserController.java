package cn.edu.just.controller;

import cn.edu.just.pojo.User;
import cn.edu.just.service.IUserService;
import spring.core.MyResource;
import spring.mvc.MyController;
import spring.mvc.MyRequestMapping;

import java.util.List;

/**
 * @Author: Gorilla
 * @Date: Created in 2019/2/21
 * @QQ: 904878659
 */
@MyController
public class UserController {

    @MyResource("userServiceImpl")
    private IUserService userService;

    @MyRequestMapping("/find")
    public List<User> findAll() {
        return userService.findAll();

    }
}
