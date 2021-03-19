package com.example.eurekaclient02.user.service;

import com.example.eurekaclient02.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-15 14:22
 */
@FeignClient(value = "eureka-client01", contextId = "RemoteUserService")
public interface RemoteUserService {

    @GetMapping("/userList")
    List<User> userList();

}
