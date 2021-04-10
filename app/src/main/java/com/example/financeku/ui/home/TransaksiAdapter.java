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

  private ArrayList<Transaksi> dataTransaksi;
  private Context context;

  public interface onItemClickListener {
    void onItemClick(int position);
  }

  private onItemClickListener listener;

  public void setOnItemClickListener(onItemClickListener listener) {
    this.listener = listener;
  }

  public TransaksiAdapter(ArrayList<Transaksi> dataTransaksi) {
    this.dataTransaksi = dataTransaksi;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
    MyViewHolder mvh = new MyViewHolder(view, listener);
    return mvh;
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Transaksi dataTransaksi = this.dataTransaksi.get(position);
    holder.myText1.setText(dataTransaksi.getNamaTransaksi());
    holder.myText2.setText(dataTransaksi.getNominalTransaksi());
    holder.myImage.setImageResource(dataTransaksi.getMyImage());

  }

  @Override
  public int getItemCount() {
    return dataTransaksi.size();
  }

  public static class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView myText1, myText2;
    public ImageView myImage;
    ConstraintLayout mainLayout;

    public MyViewHolder(@NonNull View itemView, final onItemClickListener listener) {
      super(itemView);
      myText1 = itemView.findViewById(R.id.nama_transaksi);
      myText2 = itemView.findViewById(R.id.nominal_transaksi);
      myImage = itemView.findViewById(R.id.myImageView);
      mainLayout = itemView.findViewById(R.id.mainLayout);
//      myText3 = itemView.findViewById(R.id.keteranganTransaksi);
//      myText4 = itemView.findViewById(R.id.tanggalTransaksi);
//      myText2 = itemView.findViewById(R.id.jenisTransaksi);

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          int position = getAdapterPosition();
          listener.onItemClick(position);
        }
      });
    }
  }
}
