package com.k21cnt.ntt.labguide04.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class KhoaDTO {
    @NotBlank(message = "Mã khoa không được để trống")
    @Size(min = 2, max = 2, message = "Mã khoa phải có đúng 2 ký tự")
    private String maKh;

    @NotBlank(message = "Tên khoa không được để trống")
    @Size(min = 5, max = 25, message = "Tên khoa phải có độ dài từ 5 đến 25 ký tự")
    private String tenKh;

    // Constructors
    public KhoaDTO() {}

    public KhoaDTO(String maKh, String tenKh) {
        this.maKh = maKh;
        this.tenKh = tenKh;
    }

    // Getters and Setters
    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }
}