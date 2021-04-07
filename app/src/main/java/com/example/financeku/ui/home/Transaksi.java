package com.example.financeku.ui.home;

public class Transaksi {
  private String namaTransaksi;
  private String nominalTransaksi;
  private String keterangan;
  private String tanggal;
  private int myImage;

  public Transaksi(String namaTransaksi, String nominalTransaksi, int myImage, String keterangan, String tanggal) {
    this.namaTransaksi = namaTransaksi;
    this.nominalTransaksi = nominalTransaksi;
    this.myImage = myImage;
    this.keterangan = keterangan;
    this.tanggal = tanggal;
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

  public String getKeterangan() {
    return keterangan;
  }

  public void setKeterangan(String keterangan) {
    this.keterangan = keterangan;
  }

  public String getTanggal() {
    return tanggal;
  }

  public void setTanggal(String tanggal) {
    this.tanggal = tanggal;
  }
}
