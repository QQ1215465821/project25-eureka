package com.example.eurekaclient01.user.controller;

import org.example.student.Student;
import org.example.student.StudentApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-12 10:25
 */
@RestController
public class StudentController implements StudentApi {

    @Value("${eureka.instance.hostname}")
    private String hostName;
    @Value("${server.port}")
    private Integer port;

    @Override
    public String getStudent(String id){
        System.out.println(hostName + "," + port + ", "+Thread.currentThread().getName() + "," + Thread.currentThread().getId()  + "," + Thread.currentThread().getThreadGroup());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return id;
    }
    /*
    host01,8081, http-nio-8081-exec-5,57,java.lang.ThreadGroup[name=main,maxpri=10]
     */
    @Override
    public Student addStudent( Student student){
        System.out.println(hostName + "," + port);
        return new Student(hostName, port);
    }
    @Override
    public Student updateStudent(Student student){
        System.out.println(hostName + "," + port);
        return student;
    }
    @Override
    public String deleteStudent(String id){
        System.out.println(hostName + "," + port);
        return id;
    }
}