package com.example.tinh.sqliteproject.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tinh.sqliteproject.entities.DanhMuc;

import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    private SanPhamDBOpenHelper openHelper;
    private SQLiteDatabase db;

    public DanhMucDAO(Context context) {
        openHelper = new SanPhamDBOpenHelper(context);
    }

    public List<DanhMuc> getAllDanhMuc() {
        List<DanhMuc> list = new ArrayList<>();
        db = openHelper.getReadableDatabase();
        Cursor cusor = db.query(SanPhamDBOpenHelper.TABLE_DANHMUC, null, null, null, null, null, null);
        if (cusor.moveToFirst()) {
            while (!cusor.isAfterLast()) {
                int madm = cusor.getInt(cusor.getColumnIndex("MADM"));
                String tendm = cusor.getString(cusor.getColumnIndex("TENDM"));
                DanhMuc danhMuc = new DanhMuc(madm, tendm);
                list.add(danhMuc);
                cusor.moveToNext();
            }
        }

        cusor.close();
        db.close();
        return list;
    }

    public DanhMuc getDanhMuc(int madb) {
        db = openHelper.getReadableDatabase();
        Cursor cursor = db.query(
                SanPhamDBOpenHelper.TABLE_DANHMUC, // TEN TABLE
                null, // SELECT
                "MADM = ?", // WHERE ..
                new String[] {String.valueOf(madb)}, // THAM SO TRUYEN VAO [?] CUA WHERE
                null,
                null,
                null);

        DanhMuc danhMuc = null;
        if (cursor.moveToFirst()) { // neu co kq tra ve
            while (!cursor.isAfterLast()) {
                int madm = cursor.getInt( // get kieu du lieu cua Colum
                        cursor.getColumnIndex("MADM") // get vi tri cua colum theo ten
                );
                String tendm = cursor.getString(cursor.getColumnIndex("TENDM"));
                danhMuc = new DanhMuc(madm, tendm);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return danhMuc;
    }

    public boolean insertDanhMuc(DanhMuc danhMuc) {
        db = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("TENDM", danhMuc.getTendm());
        long rows = db.insert(
                SanPhamDBOpenHelper.TABLE_DANHMUC, // ten table
                null,
                contentValues);
        db.close();

        if (rows > 0) {
            // insert succes
            return true;
        }
        return false;
    }

    public boolean updateDanhMuc(int madm, String tendm) {
        db = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("TENDM", tendm);

        long rows = db.update(
                SanPhamDBOpenHelper.TABLE_DANHMUC, // ten table
                contentValues, // gia tri update
                "MADM = ?", // where ...
                new String[] {String.valueOf(madm)}
                );

        db.close();

        if (rows > 0) {
            // insert succes
            return true;
        }
        return false;
    }
}
