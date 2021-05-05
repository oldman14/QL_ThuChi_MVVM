package com.example.ql_thuchi.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.ql_thuchi.dao.LoaiThuDao;
import com.example.ql_thuchi.entity.LoaiThu;
import com.example.ql_thuchi.repository.LoaiThuRepository;

import java.util.List;

public class LoaiThuViewModel extends AndroidViewModel {
    private LoaiThuRepository mLoaiThuRepository;
    private LiveData<List<LoaiThu>> mAllLoaiThu;

    public LoaiThuViewModel(@NonNull Application application) {
        super(application);
        mLoaiThuRepository = new LoaiThuRepository(application);
        mAllLoaiThu = mLoaiThuRepository.getAllLoaiThu();
    }

    public void setmAllLoaiThu(LiveData<List<LoaiThu>> mAllLoaiThu) {
        this.mAllLoaiThu = mAllLoaiThu;
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }

    public void  insert(LoaiThu loaiThu){
        mLoaiThuRepository.insert(loaiThu);

    }
    public void delete(LoaiThu loaiThu){
        mLoaiThuRepository.delete(loaiThu);
    }
}