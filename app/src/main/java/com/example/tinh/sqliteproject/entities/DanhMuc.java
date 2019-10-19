package com.example.tinh.sqliteproject.entities;

import java.util.Objects;

public class DanhMuc {
    private int madm;
    private String tendm;

    public DanhMuc(int madm) {
        this.madm = madm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DanhMuc danhMuc = (DanhMuc) o;
        return madm == danhMuc.madm;
    }

    @Override
    public int hashCode() {

        return Objects.hash(madm);
    }

    public int getMadm() {

        return madm;
    }

    public void setMadm(int madm) {
        this.madm = madm;
    }

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }

    public DanhMuc(int madm, String tendm) {

        this.madm = madm;
        this.tendm = tendm;
    }

    @Override
    public String toString() {
        return tendm;
    }
}
