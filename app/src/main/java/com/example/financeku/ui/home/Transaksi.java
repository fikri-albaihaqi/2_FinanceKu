package com.example.financeku.ui.home;

public class Transaksi {
  private String namaTransaksi;
  private String nominalTransaksi;
  private int myImage;

  public Transaksi(String namaTransaksi, String nominalTransaksi, int myImage) {
    this.namaTransaksi = namaTransaksi;
    this.nominalTransaksi = nominalTransaksi;
    this.myImage = myImage;
  }

  public String getNamaTransaksi() {
    return namaTransaksi;
  }

  public void setNamaTransaksi(String namaTransaksi) {
    this.namaTransaksi = namaTransaksi;
  }

  public String getNominalTransaksi() {
    return nominalTransaksi;
  }

  public void setNominalTransaksi(String nominalTransaksi) {
    this.nominalTransaksi = nominalTransaksi;
  }

  public int getMyImage() {
    return myImage;
  }

  public void setMyImage(int myImage) {
    this.myImage = myImage;
  }
}
