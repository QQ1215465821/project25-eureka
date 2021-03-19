package com.example.eurekaclient02;

import com.example.eurekaclient02.student.service.RemoteStudentService;
import org.example.student.Student;
import org.example.student.StudentApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaClient02ApplicationTests {

    @Autowired
    private RemoteStudentService remoteStudentService;

    @Test
    void test01() {
        Student student = new Student("aaa", 20);
        Student student1 = remoteStudentService.addStudent(student);
        System.out.println("student1 = " + student1);
    }

    @Test
    void test02() {
        Student student = new Student("aaa", 20);
        Student student1 = remoteStudentService.updateStudent(student);
        System.out.println("student1 = " + student1);
    }

    @Test
    void test03() {
        String id = remoteStudentService.getStudent("aaa");
        System.out.println("id = " + id);
    }

    @Test
    void test04() {
        String id = remoteStudentService.deleteStudent("aaa");
        System.out.println("id = " + id);
    }
}
