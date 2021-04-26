package com.example.financekuv2.ui.tambah_data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.financekuv2.R;

import java.util.Locale;

public class TambahDataFragment extends Fragment {

  private Button dateButton, tambahData;
  private EditText inputNamaTransaksi, inputNominal, inputKeterangan;
  private TambahDataViewModel tambahDataViewModel;
  private Locale locale;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    tambahDataViewModel =
            new ViewModelProvider(this).get(TambahDataViewModel.class);
    View root = inflater.inflate(R.layout.fragment_tambah_data, container, false);

    locale = getResources().getConfiguration().locale;

    dateButton = root.findViewById(R.id.buttonDatePicker);

    dateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getFragmentManager(), "date picker");
      }
    });

    Spinner spinner = (Spinner) root.findViewById(R.id.button_jenis_transaksi);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.array_jenis_transaksi, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);

    tambahData = root.findViewById(R.id.tambahData);
    inputNamaTransaksi = root.findViewById(R.id.inputNamaTransaksi);
    inputNominal = root.findViewById(R.id.inputNominal);
    inputKeterangan = root.findViewById(R.id.inputKeterangan);

    inputNominal.setText("0");

    tambahData.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("tanggalTransaksi", dateButton.getText().toString());
        bundle.putString("jenisTransaksi", spinner.getSelectedItem().toString());
        bundle.putString("namaTransaksi", inputNamaTransaksi.getText().toString());
        bundle.putInt("nominalTransaksi", Integer.parseInt(inputNominal.getText().toString()));
        bundle.putString("keteranganTransaksi", inputKeterangan.getText().toString());

        Toast.makeText(getContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
        getParentFragmentManager().setFragmentResult("dataTransaksi", bundle);
      }
    });

    return root;
  }
}
