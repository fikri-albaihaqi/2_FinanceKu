package com.example.financeku.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financeku.DetailTransaksiActivity;
import com.example.financeku.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
  RecyclerView recyclerView;
  TransaksiAdapter transaksiAdapter;

  private HomeViewModel homeViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    homeViewModel =
            new ViewModelProvider(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);

    final ArrayList<Transaksi> dataTransaksi = new ArrayList<>();

    dataTransaksi.add(new Transaksi("Belanja Bulanan", "-Rp. 200.000", R.drawable.ic_pengeluaran, "Lorem Ipsum", "11 September 2021", "Pengeluaran"));
    dataTransaksi.add(new Transaksi("Ngopi", "-Rp. 40.000", R.drawable.ic_pengeluaran, "Ngopi di warkop", "11 September 2021", "Pengeluaran"));
    dataTransaksi.add(new Transaksi("Gaji Pokok", "Rp. 5.000.000", R.drawable.ic_pemasukan, "Gaji bulanan", "11 September 2021", "Pemasukan"));
    dataTransaksi.add(new Transaksi("Uang Makan", "Rp. 300.000", R.drawable.ic_pemasukan, "Lorem Ipsum", "11 September 2021", "Pemasukan"));

    recyclerView = root.findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setHasFixedSize(true);
    transaksiAdapter = new TransaksiAdapter(dataTransaksi);
    recyclerView.setAdapter(transaksiAdapter);

    transaksiAdapter.setOnItemClickListener(new TransaksiAdapter.onItemClickListener() {
      @Override
      public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), DetailTransaksiActivity.class);
        intent.putExtra("Transaksi", dataTransaksi.get(position));
        startActivity(intent);
      }
    });

    return root;
  }
}