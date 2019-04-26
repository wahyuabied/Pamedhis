package com.mrabid.pamedhisjav.fragment.History;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Resep;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    Context context;
    ArrayList<Resep> reseps = new ArrayList<>();

    public HistoryAdapter(Context context, ArrayList<Resep> reseps){
        this.context = context;
        this.reseps = reseps;
    }
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_history,null));
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.MyViewHolder holder, int position) {
        Resep p = reseps.get(position);
        HistoryObatAdapter mAdapter = new HistoryObatAdapter(context,p.getObats());
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

    }

    public int getItemCount() {
        return reseps.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        LinearLayout linearLayout;
        CardView cardView;
        ImageView detail;
        public MyViewHolder(View inflate) {
            super(inflate);
            recyclerView = inflate.findViewById(R.id.itemHistory_rvObat);
            linearLayout = inflate.findViewById(R.id.itemHistory_llDetailObat);
            cardView = inflate.findViewById(R.id.itemHistory_cvHeader);
            detail = inflate.findViewById(R.id.itemHistory_ivMoreDetail);

        }
    }
}
