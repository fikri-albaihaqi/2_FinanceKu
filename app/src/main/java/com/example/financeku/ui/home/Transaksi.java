package com.example.financeku.ui.home;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaksi implements Parcelable {
  private String namaTransaksi;
  private String nominalTransaksi;
  private String keterangan;
  private String tanggal;
  private String jenisTransaksi;
  private int myImage;

  public Transaksi(String namaTransaksi, String nominalTransaksi, int myImage, String keterangan, String tanggal, String jenisTransaksi) {
    this.namaTransaksi = namaTransaksi;
    this.nominalTransaksi = nominalTransaksi;
    this.myImage = myImage;
    this.keterangan = keterangan;
    this.tanggal = tanggal;
    this.jenisTransaksi = jenisTransaksi;
  }

  protected Transaksi(Parcel in) {
    namaTransaksi = in.readString();
    nominalTransaksi = in.readString();
    keterangan = in.readString();
    tanggal = in.readString();
    jenisTransaksi = in.readString();
    myImage = in.readInt();
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

  public String getJenisTransaksi() {
    return jenisTransaksi;
  }

  public void setJenisTransaksi(String jenisTransaksi) {
    this.jenisTransaksi = jenisTransaksi;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(namaTransaksi);
    dest.writeString(nominalTransaksi);
    dest.writeString(keterangan);
    dest.writeString(tanggal);
    dest.writeString(jenisTransaksi);
    dest.writeInt(myImage);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Transaksi> CREATOR = new Creator<Transaksi>() {
    @Override
    public Transaksi createFromParcel(Parcel in) {
      return new Transaksi(in);
    }

    @Override
    public Transaksi[] newArray(int size) {
      return new Transaksi[size];
    }
  };
}
