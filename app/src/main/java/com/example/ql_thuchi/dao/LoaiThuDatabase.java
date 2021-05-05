package com.example.ql_thuchi.dao;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ql_thuchi.entity.LoaiThu;

import javax.xml.namespace.QName;

@Database(entities = {LoaiThu.class}, version = 1)
public abstract class LoaiThuDatabase extends RoomDatabase {
    public abstract LoaiThuDao loaiThuDao();

    public static LoaiThuDatabase INSTANCE;

    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            new PopulateData(INSTANCE).execute();
        }
    };
    public static LoaiThuDatabase getLoaiThuDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (LoaiThuDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), LoaiThuDatabase.class, "loai_thu")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return INSTANCE;
    }

    public static class PopulateData extends AsyncTask<Void, Void, Void> {
        private  LoaiThuDao loaiThuDao;

        public PopulateData(LoaiThuDatabase db) {
            loaiThuDao = db.loaiThuDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String[] loaithu = new String[]{"Luong","Thuong","Me cho"};
            for(String it : loaithu) {
                LoaiThu lt  = new LoaiThu();
                lt.ten_lt = it;
                loaiThuDao.insert(lt);
            }
            return null;
        }
    }

}
