package com.example.ql_thuchi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ql_thuchi.R;
import com.example.ql_thuchi.entity.LoaiThu;

import java.util.List;

public class LoaiThuRecyclerviewAdapter extends RecyclerView.Adapter<LoaiThuRecyclerviewAdapter.LoaiThuViewHolder>{
   private LayoutInflater layoutInflater;
   private List<LoaiThu> loaiThuList;

    public LoaiThuRecyclerviewAdapter(Context context) {
        layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public LoaiThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LoaiThuViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_loaithu_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuViewHolder holder, int position) {
        if (loaiThuList != null) {
            holder.tv_TenLoaiThu.setText(loaiThuList.get(position).ten_lt);
        }
    }

    public void setLoaiThuList(List<LoaiThu> loaiThuList) {
        this.loaiThuList = loaiThuList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(loaiThuList == null){
            return 0;
        }
        return loaiThuList.size();
    }
    public LoaiThu getItem(int position) {
        if (loaiThuList == null || position>=loaiThuList.size()){
            return null;
        }
        return loaiThuList.get(position);
    }
    public static class LoaiThuViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_TenLoaiThu;
        public LoaiThuViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_TenLoaiThu = (TextView) itemView.findViewById(R.id.tv_item_loaithu);
        }
    }
}
