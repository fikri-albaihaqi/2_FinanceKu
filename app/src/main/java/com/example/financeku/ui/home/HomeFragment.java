package com.example.financeku.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financeku.R;

public class HomeFragment extends Fragment {
  RecyclerView recyclerView;

  String s1[], s2[];
  int images[] = {R.drawable.pengeluaran_1, R.drawable.pengeluaran_2, R.drawable.pemasukan_1, R.drawable.pemasukan_2};
  private HomeViewModel homeViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    homeViewModel =
            new ViewModelProvider(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);

    recyclerView = root.findViewById(R.id.recyclerView);

    s1 = getResources().getStringArray(R.array.transaksi);
    s2 = getResources().getStringArray(R.array.nominal);

    MyAdapter myAdapter = new MyAdapter(getContext(), s1, s2, images);
    recyclerView.setAdapter(myAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    return root;
  }
}