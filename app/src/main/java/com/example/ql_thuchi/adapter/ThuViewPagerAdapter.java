package com.example.ql_thuchi.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ql_thuchi.ui.chi.KhoanChiFragment;
import com.example.ql_thuchi.ui.chi.LoaiChiFragment;
import com.example.ql_thuchi.ui.thu.KhoanThuFragment;
import com.example.ql_thuchi.ui.thu.LoaiThuFragment;

public class ThuViewPagerAdapter extends FragmentStateAdapter {
    public ThuViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position == 0) {
            fragment = KhoanThuFragment.newInstance();
        } else {
            fragment = LoaiThuFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
