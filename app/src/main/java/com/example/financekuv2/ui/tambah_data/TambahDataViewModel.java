package com.example.financekuv2.ui.tambah_data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TambahDataViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public TambahDataViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is dashboard fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}