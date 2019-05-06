package com.mrabid.pamedhisjav.activity.DetailMyResep;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.fragment.History.HistoryObatAdapter;
import com.mrabid.pamedhisjav.fragment.MyResep.MyResepAdapter;
import com.mrabid.pamedhisjav.model.Obat;
import com.mrabid.pamedhisjav.model.Resep;

import java.util.ArrayList;

public class DetailMyResepAdapter extends RecyclerView.Adapter<DetailMyResepAdapter.MyViewHolder> {

    Context context;
    ArrayList<Obat> obats = new ArrayList<>();

    public DetailMyResepAdapter(Context context, ArrayList<Obat> obats) {
        this.context = context;
        this.obats = obats;
    }

    @Override
    public DetailMyResepAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailMyResepAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history_obat,null));
    }

    @Override
    public void onBindViewHolder(final DetailMyResepAdapter.MyViewHolder holder, int position) {
        Obat p = obats.get(position);
        holder.symbol.setText(p.getSymbol());
        holder.name.setText(p.getNamaObat());
        holder.dosis.setText(p.getDosis());

    }

    public int getItemCount() {
        return obats.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView symbol,name,dosis;
        public MyViewHolder(View inflate) {
            super(inflate);
            symbol = inflate.findViewById(R.id.itemObat_tvSymbol);
            name = inflate.findViewById(R.id.itemObat_tvNameObat);
            dosis = inflate.findViewById(R.id.itemObat_tvUkuran);
        }
    }

}
