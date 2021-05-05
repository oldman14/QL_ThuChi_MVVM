package com.example.ql_thuchi.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.ql_thuchi.dao.LoaiThuDao;
import com.example.ql_thuchi.dao.LoaiThuDatabase;
import com.example.ql_thuchi.entity.LoaiThu;

import java.util.List;

public class LoaiThuRepository {

    private LoaiThuDao mLoaiThuDao;
    private LiveData<List<LoaiThu>> mAllLoaiThu=new LiveData<List<LoaiThu>>() {
    };

    public LoaiThuRepository(Application application) {
        this.mLoaiThuDao = LoaiThuDatabase.getLoaiThuDatabase(application).loaiThuDao();
        mAllLoaiThu = mLoaiThuDao.getAll();
    }

    public LiveData<List<LoaiThu>> getAllLoaiThu() {
        return mAllLoaiThu;
    }
    public void insert(LoaiThu loaiThu){
        new InsertAsynTask(mLoaiThuDao).execute(loaiThu);
    }
    class InsertAsynTask extends AsyncTask<LoaiThu, Void, Void>{
        private LoaiThuDao mLoaiThuDao;

        public InsertAsynTask(LoaiThuDao mLoaiThuDao) {
            this.mLoaiThuDao = mLoaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
    public void delete(LoaiThu loaiThu){
        new DeleteAsynTask(mLoaiThuDao).execute(loaiThu);
    }
    class DeleteAsynTask extends AsyncTask<LoaiThu, Void, Void>{
        private LoaiThuDao mLoaiThuDao;

        public DeleteAsynTask(LoaiThuDao mLoaiThuDao) {
            this.mLoaiThuDao = mLoaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            mLoaiThuDao.delete(loaiThus[0]);
            return null;
        }
    }
}
