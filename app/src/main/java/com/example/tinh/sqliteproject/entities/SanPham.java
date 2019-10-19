package com.example.tinh.sqliteproject.entities;

import java.util.Objects;

public class SanPham {
    private int masp;
    private String tensp;
    private DanhMuc danhMuc;
    private NhaSanXuat nhaSanXuat;
    private int soluong;
    private double dongia;

    @Override
    public String toString() {
        return tensp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPham sanPham = (SanPham) o;
        return masp == sanPham.masp;
    }

    @Override
    public int hashCode() {

        return Objects.hash(masp);
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public NhaSanXuat getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public SanPham(int masp, String tensp, DanhMuc danhMuc, NhaSanXuat nhaSanXuat, int soluong, double dongia) {
        this.masp = masp;
        this.tensp = tensp;
        this.danhMuc = danhMuc;
        this.nhaSanXuat = nhaSanXuat;
        this.soluong = soluong;
        this.dongia = dongia;
    }
}
