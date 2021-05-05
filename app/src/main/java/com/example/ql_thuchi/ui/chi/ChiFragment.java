package com.example.ql_thuchi.ui.chi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ql_thuchi.R;
import com.example.ql_thuchi.adapter.ChiViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class ChiFragment extends Fragment {
    private ViewPager2 mVp;
    private TabLayout mTab;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTab = view.findViewById(R.id.tabLayout_Chi);
        mVp = view.findViewById(R.id.viewPager_Chi);

        ChiViewPagerAdapter chiViewPagerAdapter = new ChiViewPagerAdapter(getActivity());
        mVp.setAdapter(chiViewPagerAdapter);

        new TabLayoutMediator(mTab, mVp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0){
                    tab.setText("Khoản Chi");
                }   else {
                    tab.setText("Loại Chi");
                }
            }
        }).attach();

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi, container, false);
    }
}