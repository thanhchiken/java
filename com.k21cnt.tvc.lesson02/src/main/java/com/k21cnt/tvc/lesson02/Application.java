package com.k21cnt.tvc.lesson02;

import com.k21cnt.tvc.lesson02.dependency_injection.CircleShape;
import com.k21cnt.tvc.lesson02.dependency_injection.DrawShape;
import com.k21cnt.tvc.lesson02.dependency_injection.RectangleShape;
import com.k21cnt.tvc.lesson02.tight_loosely_coupling.TightCouplingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TightCouplingService tightCouplingService, DrawShape drawShape, CircleShape circleShape, RectangleShape rectangleShape) {
		return args -> {
			// Logic của TightCouplingService
			System.out.println("Running TightCouplingService...");
			int[] arr = {11, 21, 23, 42, 15};
			tightCouplingService.complexBusinessSort(arr);

			// Logic của DrawShape (tương tự Main.java)
			System.out.println("\nRunning logic from Main.java in Spring Boot...");
			drawShape.setShape(circleShape);
			drawShape.draw();
			drawShape.setShape(rectangleShape);
			drawShape.draw();
		};
	}
}