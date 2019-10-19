package com.example.tinh.sqliteproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tinh.sqliteproject.entities.DanhMuc;

import java.util.List;

public class DanhMucAdapter extends ArrayAdapter<DanhMuc> {

    private Context context;
    private int resource;
    private List<DanhMuc> danhMucList;

    public DanhMucAdapter(Context context, int resource, List<DanhMuc> danhMucList) {
        super(context, resource, danhMucList);
        this.danhMucList = danhMucList;
        this.context = context;
        this.resource = resource;
    }

    /**
     * Function se duoc goi khi ListView khoi tao den 1 Item.
     *
     * @param position vi tri cua Item khi ListView khoi tao
     * @param convertView
     * @param parent
     * @return View sau khi da custom
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewItem = LayoutInflater.from(context).inflate(resource, parent, false);

        TextView tvMaDM = viewItem.findViewById(R.id.tv_MaDM);
        TextView tvTenDM = viewItem.findViewById(R.id.tv_TenDM);

        DanhMuc danhMuc = danhMucList.get(position); //

        tvMaDM.setText(String.valueOf(danhMuc.getMadm()));
        tvTenDM.setText(danhMuc.getTendm());

        return viewItem;
    }
}
