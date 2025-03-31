package com.k21cnt.ntt.labguide04.dto;

import jakarta.validation.constraints.*;

public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 3, max = 25, message = "Tên phải có độ dài từ 3 đến 25 ký tự")
    private String fullName;

    private String gender;

    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    @Max(value = 60, message = "Tuổi phải nhỏ hơn hoặc bằng 60")
    private int age;

    @Min(value = 1, message = "Lương phải lớn hơn 0")
    private double salary;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(String fullName, String gender, int age, double salary) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}