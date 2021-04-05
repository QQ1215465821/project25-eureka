package com.example.eurekaclient01.user.controller;

import com.example.eurekaclient01.user.service.UserService;
import org.example.user.User;
import org.example.user.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public User getUser(String id) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getUser(id);
    }

    @Override
    public List<User> getUserList(List<String> ids) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getUserList(ids);
    }

}
