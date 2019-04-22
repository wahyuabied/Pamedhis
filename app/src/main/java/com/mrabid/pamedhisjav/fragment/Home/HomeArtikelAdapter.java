package com.mrabid.pamedhisjav.fragment.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Artikel;

import java.util.ArrayList;

public class HomeArtikelAdapter extends RecyclerView.Adapter<HomeArtikelAdapter.MyViewHolder> {
    ArrayList<Artikel> list;
    private Context context;


    public HomeArtikelAdapter(ArrayList<Artikel> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public HomeArtikelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_artikel,null));
    }

    @Override
    public void onBindViewHolder(final HomeArtikelAdapter.MyViewHolder holder, int position) {
        Artikel p = list.get(position);
        if(p.getTitle().length()<30)
            holder.title.setText(p.getTitle());
        else
            holder.title.setText(p.getTitle().substring(0,25)+".....");

//        Picasso.with(context).load(p.getImage()).into(holder.imageView);

    }

    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageView;
        public MyViewHolder(View inflate) {
            super(inflate);
            title = inflate.findViewById(R.id.itemHomeArtikel_tvTitle);
            imageView = inflate.findViewById(R.id.itemHomeArtikel_ivImage);

        }
    }
}
