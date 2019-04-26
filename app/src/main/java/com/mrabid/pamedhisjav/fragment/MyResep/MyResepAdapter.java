package com.mrabid.pamedhisjav.fragment.MyResep;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Resep;

import java.util.ArrayList;

public class MyResepAdapter extends RecyclerView.Adapter<MyResepAdapter.MyViewHolder> {
    Context context;
    ArrayList<Resep> reseps = new ArrayList<>();

    public MyResepAdapter(Context context, ArrayList<Resep> reseps){
        this.context = context;
        this.reseps = reseps;
    }
    @Override
    public MyResepAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyResepAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_resep,null));
    }

    @Override
    public void onBindViewHolder(final MyResepAdapter.MyViewHolder holder, int position) {
        Resep p = reseps.get(position);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Maintenance", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getItemCount() {
        return reseps.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public MyViewHolder(View inflate) {
            super(inflate);
            cardView = inflate.findViewById(R.id.itemMyResep_cvHeader);

        }
    }
}
