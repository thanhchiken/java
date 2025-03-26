package com.k21cnt.tvc.lesson02.dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class CircleShape implements Shape {
    @Override
    public void draw() {
        System.out.println("CircleShape draw");
    }
}