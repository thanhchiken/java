package com.k21cnt.ntt.labguide04.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mon_hoc")
public class MonHoc {
    @Id
    @Column(name = "ma_mh", length = 2)
    private String maMh;

    @Column(name = "ten_mh", length = 50)
    private String tenMh;

    @Column(name = "so_tiet")
    private int soTiet;

    // Constructors
    public MonHoc() {}

    public MonHoc(String maMh, String tenMh, int soTiet) {
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