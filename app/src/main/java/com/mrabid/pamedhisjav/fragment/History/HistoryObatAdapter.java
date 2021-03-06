package com.mrabid.pamedhisjav.fragment.History;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Obat;

import java.util.ArrayList;

public class HistoryObatAdapter extends RecyclerView.Adapter<HistoryObatAdapter.MyViewHolder> {

    Context context;
    ArrayList<Obat> obats = new ArrayList<>();

    public HistoryObatAdapter(Context context, ArrayList<Obat> obats){
        this.context = context;
        this.obats = obats;
    }
    @Override
    public HistoryObatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryObatAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history_obat,null));
    }

    @Override
    public void onBindViewHolder(final HistoryObatAdapter.MyViewHolder holder, int position) {
        Obat p = obats.get(position);
        holder.symbol.setText(p.getSymbol());
        holder.nama.setText(p.getNamaObat());
        holder.dosis.setText(p.getDosis());

    }

    public int getItemCount() {
        return obats.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView symbol,nama,dosis;
        public MyViewHolder(View inflate) {
            super(inflate);
            symbol = inflate.findViewById(R.id.itemObat_tvSymbol);
            nama = inflate.findViewById(R.id.itemObat_tvNameObat);
            dosis = inflate.findViewById(R.id.itemObat_tvUkuran);

        }
    }
}
