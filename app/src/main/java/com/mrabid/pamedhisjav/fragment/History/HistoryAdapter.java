package com.mrabid.pamedhisjav.fragment.History;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Resep;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    ArrayList<Resep> list;
    private Context context;


    public HistoryAdapter(ArrayList<Resep> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history_resep,null));
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.MyViewHolder holder, int position) {
       Resep p = list.get(position);

    }

    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tanggal,namaDokter,jumlah,status;
        public MyViewHolder(View inflate) {
            super(inflate);
            tanggal = inflate.findViewById(R.id.itemHistoryResep_tvTanggal);
            namaDokter = inflate.findViewById(R.id.itemHistoryResep_tvNamaDokter);
            jumlah = inflate.findViewById(R.id.itemHistoryResep_tvJumlah);
            status = inflate.findViewById(R.id.itemHistoryResep_tvStatus);

        }
    }
}


