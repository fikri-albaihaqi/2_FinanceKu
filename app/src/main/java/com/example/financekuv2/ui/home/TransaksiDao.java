package com.example.financekuv2.ui.home;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.financekuv2.Transaksi;

import java.util.List;

@Dao
public interface TransaksiDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(Transaksi transaksi);

  @Query("DELETE FROM tabel_transaksi")
  void deleteAll();

  @Query("SELECT * FROM tabel_transaksi")
  LiveData<List<Transaksi>> getTransaksiList();
}
