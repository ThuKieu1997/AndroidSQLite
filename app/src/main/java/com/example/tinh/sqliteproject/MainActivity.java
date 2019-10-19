package com.example.tinh.sqliteproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.tinh.sqliteproject.entities.DanhMuc;
import com.example.tinh.sqliteproject.sqlite.DanhMucDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvDanhMuc;

    private DanhMucDAO danhMucDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danhMucDAO = new DanhMucDAO(MainActivity.this); // Khoi tao DAO, truyen vao Context cua ACTIVITY
        List<DanhMuc> danhMucList = danhMucDAO.getAllDanhMuc(); // goi ham getAll

        // Khoi tao ListView
        lvDanhMuc = findViewById(R.id.list_view_sp);
        DanhMucAdapter adapter = new DanhMucAdapter(this, R.layout.listview_item, danhMucList);
        lvDanhMuc.setAdapter(adapter);
    }
}
