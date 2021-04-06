package com.example.financeku.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financeku.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
  RecyclerView recyclerView;
  private ArrayList<Transaksi> dataTransaksiArrayList;

  private HomeViewModel homeViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    homeViewModel =
            new ViewModelProvider(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);

    getData();

    recyclerView = root.findViewById(R.id.recyclerView);
    TransaksiAdapter transaksiAdapter = new TransaksiAdapter(dataTransaksiArrayList);

    recyclerView.setAdapter(transaksiAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    return root;
  }

  private void getData() {
    dataTransaksiArrayList = new ArrayList<>();

    dataTransaksiArrayList.add(new Transaksi("Belanja Bulanan", "Rp. 200.000", R.drawable.ic_pengeluaran));
    dataTransaksiArrayList.add(new Transaksi("Ngopi", "Rp. 40.000", R.drawable.ic_pengeluaran));
    dataTransaksiArrayList.add(new Transaksi("Gaji Pokok", "Rp. 5.000.000", R.drawable.ic_pemasukan));
    dataTransaksiArrayList.add(new Transaksi("Uang Makan", "Rp. 300.000", R.drawable.ic_pemasukan));
  }
}