package com.example.eurekaclient02.user.controller;

import com.example.eurekaclient02.user.service.UserServiceFeign;
import org.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-12 10:25
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("/get/{id}")
    public Object get(@PathVariable String id){
        System.out.println("B服务 get("+id+")");
        User user = userServiceFeign.getUser(id);
        return user;
    }

}
