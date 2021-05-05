package com.example.ql_thuchi.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.ql_thuchi.R;
import com.example.ql_thuchi.entity.LoaiThu;
import com.example.ql_thuchi.ui.thu.LoaiThuFragment;
import com.example.ql_thuchi.ui.thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDialog {
    private LoaiThuViewModel loaiThuViewModel;
    private LayoutInflater layoutInflater;
    private AlertDialog alertDialog;

    private TextInputEditText edTenLoaiThu;
    private boolean edMode;

    public LoaiThuDialog(Context context, LoaiThuFragment fragment) {
        loaiThuViewModel = fragment.getLoaiThuViewModel();
        layoutInflater = LayoutInflater.from(context);
        View view  = layoutInflater.inflate(R.layout.dialog_loaithu, null);
        edTenLoaiThu = view.findViewById(R.id.ed_ten_loaithu);
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(view).setNegativeButton("Dong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        }).setPositiveButton("Luu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                LoaiThu lt = new LoaiThu();
                lt.ten_lt = edTenLoaiThu.getText().toString();
                Toast.makeText(context, lt.ten_lt+""+lt.id_lt, Toast.LENGTH_SHORT).show();
                loaiThuViewModel.insert(lt);
            }
        });
        alertDialog = builder.create();
    }
    public void show(){
        alertDialog.show();
    }





}
