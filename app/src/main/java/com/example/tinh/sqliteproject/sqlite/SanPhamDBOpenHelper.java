package com.example.tinh.sqliteproject.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SanPhamDBOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "sanpham.db";

    public static final String TABLE_DANHMUC = "DANHMUC";
    public static final String TABLE_SANPHAM = "SANPHAM";
    public static final String TABLE_NHASANXUAT = "NHASANXUAT";

    private String CREATE_TABLE_DANHMUC = "create table "+TABLE_DANHMUC +" (MADM INTEGER primary key autoincrement, TENDM varchar(60))";
    private String CREATE_TABLE_SANPHAM = "create table "+TABLE_SANPHAM+" (MASP INTEGER primary key autoincrement," +
            " TENSP varchar(60), MADM INTEGER not null, MANSX INTEGER not null, SOLUONG INTEGER, DONGIA double, " +
            "foreign key (MADM) references "+TABLE_DANHMUC+"(MADM) on delete cascade," +
            " foreign key (MANSX) references "+TABLE_NHASANXUAT+" (MANSX) on delete cascade )";
    private String CREATE_TABLE_NHASANXUAT = "create table "+TABLE_NHASANXUAT+" (MANSX INTEGER primary key autoincrement, TENNSX varchar(60), DIACHI varchar(250), SODIENTHOAI VARCHAR(20))";

    public SanPhamDBOpenHelper(Context context) {
        super(context, DB_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DANHMUC);
        db.execSQL(CREATE_TABLE_NHASANXUAT);
        db.execSQL(CREATE_TABLE_SANPHAM);

        //insert most data
        ContentValues danhmuc = new ContentValues();
        danhmuc.put("TENDM", "dienthoai");
        db.insert(TABLE_DANHMUC,null, danhmuc);

        ContentValues danhmuc1 = new ContentValues();
        danhmuc1.put("TENDM", "dienthoai 1");
        db.insert(TABLE_DANHMUC,null, danhmuc1);

        ContentValues nhasx = new ContentValues();
        nhasx.put("TENNSX","Microsoft");
        nhasx.put("DIACHI", "nuoc My");
        nhasx.put("SODIENTHOAI","0123445678");
        db.insert(TABLE_NHASANXUAT,null,nhasx);

        ContentValues sanpham = new ContentValues();
        sanpham.put("TENSP","Lumia 520");
        sanpham.put("MADM", 1);
        sanpham.put("MANSX",1);
        sanpham.put("SOLUONG",33);
        sanpham.put("DONGIA",12000);
        db.insert(TABLE_SANPHAM,null,sanpham);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+TABLE_SANPHAM);
        db.execSQL("drop table "+TABLE_NHASANXUAT);
        db.execSQL("drop table "+TABLE_DANHMUC);
        onCreate(db);
    }
}
