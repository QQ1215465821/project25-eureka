package com.example.eurekaclient01.user.controller;

import org.example.user.User;
import org.example.user.UserApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController implements UserApi{


    @Override
    public User getUser(String id) {
        System.out.println("A服务 getUser("+id+")");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User(id, 20);
        return user;
    }

    public List<User> getUserList(List<String> ids) {
        System.out.println("A服务 getUserList("+ids+")");
        List<User> userList = new ArrayList<User>();
        for (String id : ids) {
            User user = new User(id, 20);
            userList.add(user);
        }
        return userList;
    }
}
