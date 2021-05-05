package com.example.ql_thuchi.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoaiThu {
    @PrimaryKey(autoGenerate = true)
    public int id_lt;

    @ColumnInfo(name = "ten_lt")
    public String ten_lt;


}
