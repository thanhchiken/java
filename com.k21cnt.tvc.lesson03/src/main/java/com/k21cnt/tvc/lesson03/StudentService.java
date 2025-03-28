package com.k21cnt.tvc.lesson03;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Thành", 12));
        students.add(new Student(2, "Duy", 13));
        students.add(new Student(3, "Hunh", 14));
        return students;
    }
}