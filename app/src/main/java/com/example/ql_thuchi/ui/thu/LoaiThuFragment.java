package com.example.ql_thuchi.ui.thu;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ql_thuchi.R;
import com.example.ql_thuchi.adapter.LoaiThuRecyclerviewAdapter;
import com.example.ql_thuchi.entity.LoaiThu;

import java.util.List;

public class LoaiThuFragment extends Fragment {

    private LoaiThuViewModel mViewModel;
    private RecyclerView recyclerView;
    private LoaiThuRecyclerviewAdapter loaiThuRecyclerviewAdapter;

    public LoaiThuViewModel getLoaiThuViewModel() {
        return mViewModel;
    }

    public static LoaiThuFragment newInstance() {
        return new LoaiThuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loai_thu_fragment, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_LoaiThu);
        loaiThuRecyclerviewAdapter = new LoaiThuRecyclerviewAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(loaiThuRecyclerviewAdapter);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position  = viewHolder.getAdapterPosition();
                LoaiThu loaiThu = loaiThuRecyclerviewAdapter.getItem(position);
                mViewModel.delete(loaiThu);
            }
        });
        helper.attachToRecyclerView(recyclerView);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoaiThuViewModel.class);
        mViewModel.getAllLoaiThu().observe(getActivity(), new Observer<List<LoaiThu>>() {
            @Override
            public void onChanged(List<LoaiThu> loaiThus) {
                loaiThuRecyclerviewAdapter.setLoaiThuList(loaiThus);
            }
        });
    }
}