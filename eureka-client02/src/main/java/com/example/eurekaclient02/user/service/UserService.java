package com.example.eurekaclient02.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class UserService {

    @Autowired
    private UserServiceFeign userServiceFeign;

    public User getUser1( String id){
        System.out.println("B服务 getUser(" + id + ")");
        User user = userServiceFeign.getUser(id);
        return user;
    }

    @HystrixCollapser(batchMethod = "getUserList",
            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
            collapserProperties = {
                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "6000"),
                    @HystrixProperty(name = "maxRequestsInBatch", value = "20"),
            })
    public Future<User> getUser2( String id){
        System.out.println("B服务 getUser(" + id + ")");
        return null;
    }

    @HystrixCommand
    public List<User> getUserList(List<String> ids) {
        System.out.println("B服务 getUserList(" + ids + ")");
        List<User> userList = userServiceFeign.getUserList(ids);
        return userList;
    }
}
