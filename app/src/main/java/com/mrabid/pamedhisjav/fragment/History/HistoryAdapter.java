package com.mrabid.pamedhisjav.fragment.History;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Resep;
import com.mrabid.pamedhisjav.model.User;

import java.util.ArrayList;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    Context context;
    ArrayList<Resep> reseps = new ArrayList<>();
    User user;
    SharedPreferences sharedPreferences;

    @SuppressLint("WrongConstant")
    public HistoryAdapter(Context context, ArrayList<Resep> reseps){
        this.context = context;
        this.reseps = reseps;
        sharedPreferences = context.getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        user = new Gson().fromJson(sharedPreferences.getString("user",""),User.class);
    }
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history,null));
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.MyViewHolder holder, int position) {
        Resep p = reseps.get(position);
        HistoryObatAdapter mAdapter = new HistoryObatAdapter(context,p.getResep());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(mAdapter);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.linearLayout.getVisibility()==View.GONE){
                    holder.linearLayout.startAnimation(AnimationUtils.loadAnimation(context,R.anim.slide_down));
                    holder.detail.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    holder.linearLayout.setVisibility(View.VISIBLE);
                }
                else{
                    holder.linearLayout.startAnimation(AnimationUtils.loadAnimation(context,R.anim.slide_up));
                    holder.detail.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
                    holder.linearLayout.setVisibility(View.GONE);
                }
            }
        });
        holder.alamatPasien.setText("Alamat : "+user.getAlamat());
        holder.namaPasien.setText("Nama : "+user.getNama());
        try{
            holder.alamatPraktek.setText(p.getDokter_docs().get(0).getAlamat());
            holder.sip.setText(p.getDokter_docs().get(0).getNoIzin());
            holder.namaDokter.setText(p.getDokter_docs().get(0).getNama());
            holder.tanggal.setText(p.getRiwayat().get(0).getData().getTanggal());
//        Log.e("Tanggal",p.getRiwayat().get(0).getData().getTanggal());
            holder.tanggal2.setText(p.getRiwayat().get(0).getData().getTanggal());
        }catch (Exception e){
            Log.e("HistoryAdapter", e.toString());
        }


    }

    public int getItemCount() {
        return reseps.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        LinearLayout linearLayout;
        CardView cardView;
        ImageView detail;
        TextView tanggal,namaDokter,sip,alamatPraktek,tanggal2,namaPasien,alamatPasien;
        public MyViewHolder(View inflate) {
            super(inflate);
            recyclerView = inflate.findViewById(R.id.itemHistory_rvObat);
            linearLayout = inflate.findViewById(R.id.itemHistory_llDetailObat);
            cardView = inflate.findViewById(R.id.itemHistory_cvHeader);
            detail = inflate.findViewById(R.id.itemHistory_ivMoreDetail);
            tanggal = inflate.findViewById(R.id.itemHistory_tanggalBeli);
            tanggal2 = inflate.findViewById(R.id.itemHistory_tvtanggal);
            namaDokter = inflate.findViewById(R.id.itemHistory_tvNamaDokter);
            sip = inflate.findViewById(R.id.itemHistory_tvSIP);
            alamatPraktek = inflate.findViewById(R.id.itemHistory_tvAlamatPraktek);
            namaPasien = inflate.findViewById(R.id.itemHistory_tvNamaPasien);
            alamatPasien = inflate.findViewById(R.id.itemHistory_tvAlamatPasien);

        }
    }
}
