package com.example.financeku.ui.tambah_data;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.financeku.R;

import java.util.Calendar;

public class TambahDataFragment extends Fragment {
  private DatePickerDialog datePickerDialog;
  private Button dateButton;
  private TambahDataViewModel tambahDataViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    tambahDataViewModel =
            new ViewModelProvider(this).get(TambahDataViewModel.class);
    View root = inflater.inflate(R.layout.fragment_tambah_data, container, false);

    initDatePicker();
    dateButton = root.findViewById(R.id.date_picker_button);
    dateButton.setText(getTodayDate());

    dateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        datePickerDialog.show();
      }
    });

    Spinner spinner = (Spinner) root.findViewById(R.id.button_jenis_transaksi);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.array_jenis_transaksi, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);

    return root;
  }

  private String getTodayDate() {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    month = month + 1;
    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
    return makeDateString(dayOfMonth, month, year);
  }

  private void initDatePicker() {
    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
      @Override
      public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month = month + 1;
        String date = makeDateString(dayOfMonth, month, year);
      }
    };

    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

    int style = AlertDialog.THEME_HOLO_LIGHT;

    datePickerDialog = new DatePickerDialog(getActivity(), style, dateSetListener, year, month, dayOfMonth);
  }

  private String makeDateString(int dayOfMonth, int month, int year) {
    return dayOfMonth + " " + getMonthFormat(month) + " " + year;
  }

  private String getMonthFormat(int month) {
    if (month == 1)
      return "Januari";
    if (month == 2)
      return "Februari";
    if (month == 3)
      return "Maret";
    if (month == 4)
      return "April";
    if (month == 5)
      return "Mei";
    if (month == 6)
      return "Juni";
    if (month == 7)
      return "Juli";
    if (month == 8)
      return "Agustus";
    if (month == 9)
      return "September";
    if (month == 10)
      return "Oktober";
    if (month == 11)
      return "November";
    if (month == 12)
      return "Desember";

    return "Januari";
  }

//  public void openDatePicker(View view) {
//    datePickerDialog.show();
//  }
}