package com.example.financeku.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financeku.R;
import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.MyViewHolder> {

  private ArrayList<Transaksi> listData;

  public TransaksiAdapter(ArrayList<Transaksi> listData) {
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
  }

  @Override
  public int getItemCount() {
    return (listData != null) ? listData.size() : 0;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView myText1, myText2;
    private ImageView myImage;

    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      myText1 = itemView.findViewById(R.id.nama_transaksi);
      myText2 = itemView.findViewById(R.id.nominal_transaksi);
      myImage = itemView.findViewById(R.id.myImageView);
    }
  }
}
