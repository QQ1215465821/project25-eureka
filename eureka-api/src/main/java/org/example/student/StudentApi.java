package org.example.student;

import org.springframework.web.bind.annotation.*;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-15 14:38
 */
public interface StudentApi {

    @GetMapping("/student/{id}")
    String getStudent(@PathVariable("id") String id);

    @PostMapping("/addStudent")
    Student addStudent(@RequestBody Student student);

    @PutMapping("/updateStudent")
    Student updateStudent(@RequestBody Student student);

    @DeleteMapping("/student/{id}")
    String deleteStudent(@PathVariable("id") String id);
}
