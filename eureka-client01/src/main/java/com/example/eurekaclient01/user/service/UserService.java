package com.example.eurekaclient01.user.service;

import org.example.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public User getUser( String id){
        System.out.println("A服务 getUser(" + id + ")");
        return new User(id, 20);
    }

    public List<User> getUserList(List<String> ids) {
        System.out.println("A服务 getUserList(" + ids + ")");
        List<User> userList = new ArrayList<User>();
        for (String id : ids) {
            User user = new User(id, 20);
            userList.add(user);
        }
        return userList;
    }
}
