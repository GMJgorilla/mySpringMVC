package cn.edu.just.service.impl;

import cn.edu.just.pojo.User;
import cn.edu.just.service.IUserService;
import spring.core.MyComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gorilla
 * @Date: Created in 20:22 2019/2/21
 * @QQ: 904878659
 */
@MyComponent
public class UserServiceImpl implements IUserService {
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User(1L,"hanhan1"));
        list.add(new User(2L,"ruizhi"));
        list.add(new User(3L,"guer"));
        list.add(new User(4L,"nmsls"));
        return list;
    }
}
