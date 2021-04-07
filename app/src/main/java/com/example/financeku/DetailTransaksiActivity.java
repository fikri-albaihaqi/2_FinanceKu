package com.example.financeku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailTransaksiActivity extends AppCompatActivity {
  ImageView mainImageView;
  TextView namaTransaksi, nominalTransaksi, tanggalTransaksi, keterangan;

  String data1, data2, data3, data4;
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

    getData();
    setData();
  }

  private void getData() {
    if (getIntent().hasExtra("namaTransaksi") && getIntent().hasExtra("nominalTransaksi") &&  getIntent().hasExtra("myImage") && getIntent().hasExtra("keterangan") &&
            getIntent().hasExtra("tanggal")) {
      data1 = getIntent().getStringExtra("namaTransaki");
      data2 = getIntent().getStringExtra("nominalTransaki");
      myImage = getIntent().getIntExtra("myImage", 1);
      data3 = getIntent().getStringExtra("keterangan");
      data4 = getIntent().getStringExtra("tanggal");
    } else {
      Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
    }

  }

  private void setData() {
    namaTransaksi.setText(data1);
    nominalTransaksi.setText(data2);
    mainImageView.setImageResource(myImage);
//    tanggalTransaksi.setText(data4);
//    keterangan.setText(data3);
  }
}