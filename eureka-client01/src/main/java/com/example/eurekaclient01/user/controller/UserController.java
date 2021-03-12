package com.example.eurekaclient01.user.controller;

import com.example.eurekaclient01.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-12 10:25
 */
@RestController
public class UserController {

    @Value("${eureka.instance.hostname}")
    private String hostName;
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/userList")
    public List<User> userList(){
        return Arrays.asList(
                new User("张三", 20),
                new User("李四", 30),
                new User(hostName,  port)
        );
    }
}
