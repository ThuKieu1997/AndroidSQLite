package com.example.tinh.sqliteproject.entities;

import java.util.Objects;

public class NhaSanXuat {
    private int mansx;
    private String tennsx;
    private String diachi;
    private String sodienthoai;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhaSanXuat that = (NhaSanXuat) o;
        return mansx == that.mansx;
    }

    public NhaSanXuat(int mansx) {
        this.mansx = mansx;
    }

    @Override
    public int hashCode() {

        return Objects.hash(mansx);
    }

    public int getMansx() {

        return mansx;
    }

    public void setMansx(int mansx) {
        this.mansx = mansx;
    }

    public String getTennsx() {
        return tennsx;
    }

    public void setTennsx(String tennsx) {
        this.tennsx = tennsx;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public NhaSanXuat(int mansx, String tennsx, String diachi, String sodienthoai) {

        this.mansx = mansx;
        this.tennsx = tennsx;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
    }

    @Override
    public String toString() {
        return tennsx;
    }
}
