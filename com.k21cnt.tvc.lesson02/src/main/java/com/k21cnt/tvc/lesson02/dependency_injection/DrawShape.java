package com.k21cnt.tvc.lesson02.dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class DrawShape {
    private Shape shape;

    // Bỏ @Autowired trên constructor
    public DrawShape() {
        // Constructor rỗng
    }

    public void draw() {
        if (shape != null) {
            shape.draw();
        } else {
            System.out.println("No shape set to draw!");
        }
    }

    // Setter để gán Shape động
    public void setShape(Shape shape) {
        this.shape = shape;
    }
}