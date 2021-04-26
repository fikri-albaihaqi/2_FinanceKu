package com.example.financekuv2.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.financekuv2.Transaksi;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

  private TransaksiRepository mRepository;

  private final LiveData<List<Transaksi>> mAllTransaksi;

  public HomeViewModel(Application application) {
    super(application);
    mRepository = new TransaksiRepository(application);
    mAllTransaksi = mRepository.getAllTransaksi();
  }

  public LiveData<List<Transaksi>> getAllTransaksi() {
    return mAllTransaksi;
  }

  public void insert(Transaksi transaksi) {
    mRepository.insert(transaksi);
  }
}