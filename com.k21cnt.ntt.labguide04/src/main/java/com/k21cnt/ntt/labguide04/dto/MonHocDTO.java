package com.k21cnt.ntt.labguide04.dto;

import jakarta.validation.constraints.*;

public class MonHocDTO {
    @NotBlank(message = "Mã môn học không được để trống")
    @Size(min = 2, max = 2, message = "Mã môn học phải có đúng 2 ký tự")
    private String maMh;

    @NotBlank(message = "Tên môn học không được để trống")
    @Size(min = 5, max = 50, message = "Tên môn học phải có độ dài từ 5 đến 50 ký tự")
    private String tenMh;

    @Min(value = 45, message = "Số tiết phải từ 45 trở lên")
    @Max(value = 75, message = "Số tiết phải nhỏ hơn hoặc bằng 75")
    private int soTiet;

    // Constructors
    public MonHocDTO() {}

    public MonHocDTO(String maMh, String tenMh, int soTiet) {
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.soTiet = soTiet;
    }

    // Getters and Setters
    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }
}