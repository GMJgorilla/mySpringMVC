package cn.edu.just.controller;

import spring.mvc.MyController;
import spring.mvc.MyRequestMapping;

/**
 * @Author: Gorilla
 * @Date: Created in 2019/2/21
 * @QQ: 904878659
 */
@MyController
public class OrderController {

    @MyRequestMapping("/submit")
    public String submit() {
        return "Is submit";
    }
}
