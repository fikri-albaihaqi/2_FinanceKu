package com.example.financeku.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financeku.DetailTransaksiActivity;
import com.example.financeku.R;
import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.MyViewHolder> {

  private ArrayList<Transaksi> listData;
  private Context context;

  public TransaksiAdapter(Context context, ArrayList<Transaksi> listData) {
    this.context = context;
    this.listData = listData;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.my_row, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.myText1.setText(listData.get(position).getNamaTransaksi());
    holder.myText2.setText(listData.get(position).getNominalTransaksi());
    holder.myImage.setImageResource(listData.get(position).getMyImage());
//    holder.myText3.setText(listData.get(position).getKeterangan());
//    holder.myText4.setText(listData.get(position).getTanggal());

    holder.mainLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(context, DetailTransaksiActivity.class);
        intent.putExtra("namaTransaksi", listData.get(position).getNamaTransaksi());
        intent.putExtra("nominalTransaksi", listData.get(position).getNominalTransaksi());
        intent.putExtra("myImage", listData.get(position).getMyImage());
//        intent.putExtra("keterangan", listData.get(position).getKeterangan());
//        intent.putExtra("tanggal", listData.get(position).getTanggal());
        context.startActivity(intent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return (listData != null) ? listData.size() : 0;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView myText1, myText2, myText3, myText4;
    private ImageView myImage;
    ConstraintLayout mainLayout;

    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      myText1 = itemView.findViewById(R.id.nama_transaksi);
      myText2 = itemView.findViewById(R.id.nominal_transaksi);
      myImage = itemView.findViewById(R.id.myImageView);
      mainLayout = itemView.findViewById(R.id.mainLayout);
//      myText3 = itemView.findViewById(R.id.keteranganTransaksi);
//      myText4 = itemView.findViewById(R.id.tanggalTransaksi);
    }
  }
}
