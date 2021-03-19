package com.example.eurekaclient02.user.controller;

import com.example.eurekaclient02.user.entity.User;
import com.example.eurekaclient02.user.service.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-12 10:25
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RemoteUserService remoteUserService;

    @GetMapping("/userList")
    public List<User> userList(){
        List<User> userList = restTemplate.getForObject("http://EUREKA-CLIENT01/userList", List.class);
        return userList;
    }

    @GetMapping("/userList2")
    public List<User> userList2(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-CLIENT01");
        List<User> userList = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/userList", List.class);
        return userList;
    }

    @GetMapping("/userList3")
    public List<User> userList3(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("EUREKA-CLIENT01");
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        List<User> userList = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/userList", List.class);
        return userList;
    }

    @GetMapping("/userList4")
    public List<User> userList4(){
        List<User> userList = remoteUserService.userList();
        return userList;
    }
}
