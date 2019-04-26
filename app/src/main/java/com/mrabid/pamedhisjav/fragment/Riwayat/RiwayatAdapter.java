package com.mrabid.pamedhisjav.fragment.Riwayat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Riwayat;

import java.util.ArrayList;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.MyViewHolder> {
    ArrayList<Riwayat> list;
    private Context context;


    public RiwayatAdapter(ArrayList<Riwayat> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public RiwayatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RiwayatAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_riwayat,null));
    }

    @Override
    public void onBindViewHolder(final RiwayatAdapter.MyViewHolder holder, int position) {
        Riwayat p = list.get(position);
        holder.namaDokter.setText(p.getDokter().getNama());
        holder.tanggal.setText(p.getTanggal());
        holder.lokasi.setText(p.getLokasi());
        holder.teleponDokter.setText(p.getDokter().getNoTelp());

//        Picasso.with(context).load(p.getImage()).into(holder.imageView);

    }

    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView namaDokter,tanggal,lokasi,teleponDokter;

        public MyViewHolder(View inflate) {
            super(inflate);
            imageView = inflate.findViewById(R.id.itemRiwayat_ivProfileDokter);
            namaDokter = inflate.findViewById(R.id.itemRiwayat_tvNamaDokter);
            tanggal = inflate.findViewById(R.id.itemRiwayat_tvTanggal);
            lokasi =  inflate.findViewById(R.id.itemRiwayat_tvLokasi);
            teleponDokter =  inflate.findViewById(R.id.itemRiwayat_tvTeleponDokter);

        }
    }
}
