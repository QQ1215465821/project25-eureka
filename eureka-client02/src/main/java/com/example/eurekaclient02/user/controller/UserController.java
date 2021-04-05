package com.example.eurekaclient02.user.controller;

import com.example.eurekaclient02.user.service.UserService;
import org.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-12 10:25
 */
@RestController
public class UserController  {

    @Autowired
    private UserService userService;

    @GetMapping("/get1/{id}")
    public User get1(@PathVariable String id) {
        User user = userService.getUser1(id);
        System.out.println("user = " + user);
        return user;
    }

    @GetMapping("/get2/{id}")
    public User get2(@PathVariable String id) throws ExecutionException, InterruptedException {
        User user = userService.getUser2(id).get();
        System.out.println("user = " + user);
        return user;
    }

}
