package com.example.financeku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.financeku.ui.home.Transaksi;

public class DetailTransaksiActivity extends AppCompatActivity {
  ImageView mainImageView;
  TextView namaTransaksi, nominalTransaksi, tanggalTransaksi, keterangan, jenisTransaksi;

  String data1, data2, data3, data4, data5;
  int myImage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_transaksi);

    mainImageView = findViewById(R.id.mainImageView);
    namaTransaksi = findViewById(R.id.tittleTransaksi);
    nominalTransaksi = findViewById(R.id.nominalTransaksi);
    tanggalTransaksi = findViewById(R.id.tanggalTransaksi);
    keterangan = findViewById(R.id.keteranganTransaksi);
    jenisTransaksi = findViewById(R.id.jenisTransaksi);

    Intent intent = getIntent();

    Transaksi transaksi = intent.getParcelableExtra("Transaksi");

    myImage = transaksi.getMyImage();
    data1 = transaksi.getNamaTransaksi();
    data2 = transaksi.getNominalTransaksi();
    data3 = transaksi.getTanggal();
    data4 = transaksi.getJenisTransaksi();
    data5 = transaksi.getKeterangan();

    mainImageView.setImageResource(myImage);
    namaTransaksi.setText(data1);
    nominalTransaksi.setText(data2);
    tanggalTransaksi.setText(data3);
    keterangan.setText(data4);
    jenisTransaksi.setText(data5);
  }

}