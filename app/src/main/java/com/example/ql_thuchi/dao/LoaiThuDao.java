package com.example.ql_thuchi.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ql_thuchi.entity.LoaiThu;

import java.util.List;

@Dao
public interface LoaiThuDao {

    @Query("SELECT * FROM loaithu")
    LiveData<List<LoaiThu>> getAll();

    @Insert
    void insert(LoaiThu loaiThu);

    @Update
    void update(LoaiThu loaiThu);

    @Delete
    void delete(LoaiThu loaiThu);

}
