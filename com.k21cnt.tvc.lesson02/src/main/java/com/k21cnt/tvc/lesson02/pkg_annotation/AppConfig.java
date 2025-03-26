package com.k21cnt.tvc.lesson02.pkg_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public String appName() {
        return "<h1> VIEN CONG NGHE DEVMASTER </h1><h2>Spring Boot Application</h2>";
    }
}