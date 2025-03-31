package com.k21cnt.ntt.labguide04.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
    @Column(name = "ma_kh", length = 2)
    private String maKh;

    @Column(name = "ten_kh", length = 25)
    private String tenKh;

    // Constructors
    public Khoa() {}

    public Khoa(String maKh, String tenKh) {
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