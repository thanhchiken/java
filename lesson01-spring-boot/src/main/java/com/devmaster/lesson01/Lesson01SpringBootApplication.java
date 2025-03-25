package com.devmaster.lesson01;


import com.devmaster.lesson01.method_ref.DemoMethodRef;
import com.devmaster.lesson01.pkg_default_method.Circle;
import com.devmaster.lesson01.pkg_default_method.Shape;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Lesson01SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson01SpringBootApplication.class, args);
		System.out.println("Devmaster hello World");

		Shape circle = new Circle();
		circle.draw();
		circle.setColor("Red");

		System.out.println("\n=== Chạy demo method reference ===");
		DemoMethodRef.main(new String[]{});
	}


}
