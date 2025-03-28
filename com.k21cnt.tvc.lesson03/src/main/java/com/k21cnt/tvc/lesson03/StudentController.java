package com.k21cnt.tvc.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/K21Thanh")
    public Student getStudent() {
        Student student = new Student();
        student.setName("Nguyễn Tiến Thành");
        student.setId(10);
        student.setAge(22);
        return student;
    }

    @GetMapping("/K21Thanh-list")
    public List<Student> getStudents() {
        return studentService.findAll();
    }
}