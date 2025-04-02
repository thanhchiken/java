package com.k21cnt.ntt.lesson09.controller;

import com.k21cnt.ntt.lesson09.entity.Student;
import com.k21cnt.ntt.lesson09.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student-list")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String student(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list"; // Đảm bảo trả về đúng tên template
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student-add";
    }
    @PostMapping("/add")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:/student-list";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable(value = "id") Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-edit";
    }
    @PostMapping("/update/{id}")
        public String updateStudent(@PathVariable(value = "id") Long id, @ModelAttribute("student") Student student){
        studentService.update(id, student);
        return "redirect:/student-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id, Model model) {
        studentService.delete(id);
        return "redirect:/student-list";
    }

}


