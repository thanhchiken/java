package com.k21cnt.tvc.lesson02.pkg_annotation_controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Endpoint /hello was called!");
        return "Hello, Spring Boot!";
    }
}