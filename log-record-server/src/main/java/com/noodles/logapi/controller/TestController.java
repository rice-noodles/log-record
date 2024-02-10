package com.noodles.logapi.controller;

import com.noodles.logapi.annotation.LogRecord;
import com.noodles.logapi.beans.User;
import com.noodles.logapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: noodles
 * @Date: 2022/01/10 22:20
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @LogRecord(content = "controller 的注解")
    @RequestMapping(value = "/test")
    public String test() {
        User user = new User();
        user.setUsername("zhang san");
        user.setPassword("123456");
        return userService.login(user, 7);
    }
}
