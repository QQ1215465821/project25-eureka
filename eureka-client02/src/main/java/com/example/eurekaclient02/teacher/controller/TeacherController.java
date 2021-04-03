package com.example.eurekaclient02.teacher.controller;

import com.example.eurekaclient02.teacher.entity.Teacher;
import com.example.eurekaclient02.teacher.service.TeacherServiceFeign;
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
public class TeacherController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private TeacherServiceFeign teacherServiceFeign;

    @GetMapping("/teacherList")
    public List<Teacher> teacherList(){
        List<Teacher> teacherList = restTemplate.getForObject("http://EUREKA-CLIENT01/teacherList", List.class);
        return teacherList;
    }

    @GetMapping("/teacherList2")
    public List<Teacher> teacherList2(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-CLIENT01");
        List<Teacher> teacherList = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/teacherList", List.class);
        return teacherList;
    }

    @GetMapping("/teacherList3")
    public List<Teacher> teacherList3(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("EUREKA-CLIENT01");
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        List<Teacher> teacherList = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/teacherList", List.class);
        return teacherList;
    }

    @GetMapping("/teacherList4")
    public List<Teacher> teacherList4(){
        List<Teacher> teacherList = teacherServiceFeign.teacherList();
        return teacherList;
    }
}
