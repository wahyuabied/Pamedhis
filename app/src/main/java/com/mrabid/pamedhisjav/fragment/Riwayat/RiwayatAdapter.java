package com.mrabid.pamedhisjav.fragment.Riwayat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.activity.DetailRiwayatActivity;
import com.mrabid.pamedhisjav.model.BlockRiwayat;
import com.mrabid.pamedhisjav.model.Riwayat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.MyViewHolder> {
    ArrayList<BlockRiwayat> list;
    private Context context;


    public RiwayatAdapter(ArrayList<BlockRiwayat> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public RiwayatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RiwayatAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_riwayat,null));
    }

    @Override
    public void onBindViewHolder(final RiwayatAdapter.MyViewHolder holder, int position) {
        final BlockRiwayat p = list.get(position);
        holder.namaDokter.setText(p.getDokter_docs().get(0).getNama());
        holder.tanggal.setText(p.getData().getTanggal());
        holder.lokasi.setText(p.getDokter_docs().get(0).getAlamat());
        holder.teleponDokter.setText(p.getDokter_docs().get(0).getNoTelp());
        holder.imageView.setImageResource(R.drawable.img_dokter);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(context, DetailRiwayatActivity.class);
                i.putExtra("block_riwayat",p);
                context.startActivity(i);
            }
        });
//        Picasso.with(context).load(p.getImage()).into(holder.imageView);

    }

    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RelativeLayout relativeLayout;
        TextView namaDokter,tanggal,lokasi,teleponDokter;

        public MyViewHolder(View inflate) {
            super(inflate);
            imageView = inflate.findViewById(R.id.itemRiwayat_ivProfileDokter);
            namaDokter = inflate.findViewById(R.id.itemRiwayat_tvNamaDokter);
            tanggal = inflate.findViewById(R.id.itemRiwayat_tvTanggal);
            lokasi =  inflate.findViewById(R.id.itemRiwayat_tvLokasi);
            teleponDokter =  inflate.findViewById(R.id.itemRiwayat_tvTeleponDokter);
            relativeLayout = inflate.findViewById(R.id.riwayat_rlt);

        }
    }
}
