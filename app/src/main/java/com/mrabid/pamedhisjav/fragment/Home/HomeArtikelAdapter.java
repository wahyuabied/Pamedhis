package com.mrabid.pamedhisjav.fragment.Home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.activity.DetailArtikelActivity;
import com.mrabid.pamedhisjav.model.Artikel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeArtikelAdapter extends RecyclerView.Adapter<HomeArtikelAdapter.MyViewHolder> {
    ArrayList<Artikel> list;
    private Context context;
    ArrayList<String> listGambar = new ArrayList<>();


    public HomeArtikelAdapter(ArrayList<Artikel> list, Context context){
        this.list = list;
        this.context = context;
        listGambar = putGambar();
    }

    @Override
    public HomeArtikelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_artikel,null));
    }

    @Override
    public void onBindViewHolder(final HomeArtikelAdapter.MyViewHolder holder, final int position) {
        final Artikel p = list.get(position);
        if(p.getJudul().length()<15)
            holder.title.setText(p.getJudul());
        else
            holder.title.setText(p.getJudul().substring(0,12)+"..");
        try{
            Picasso.with(context).load(listGambar.get(position)).into(holder.imageView);
        }catch (Exception e){
            holder.imageView.setImageResource(R.drawable.ic_warning_black_24dp);
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(context, DetailArtikelActivity.class);
                i.putExtra("artikel",p);
                i.putExtra("gambarArtikel",listGambar.get(position));
                context.startActivity(i);
            }
        });

    }

    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        LinearLayout linearLayout;
        ImageView imageView;
        public MyViewHolder(View inflate) {
            super(inflate);
            title = inflate.findViewById(R.id.itemHomeArtikel_tvTitle);
            imageView = inflate.findViewById(R.id.itemHomeArtikel_ivImage);
            linearLayout = inflate.findViewById(R.id.itemHome_llArtikel);

        }
    }

    public ArrayList<String> putGambar(){
        ArrayList<String> temp = new ArrayList<>();
        temp.add("https://hellosehat.com/wp-content/uploads/2016/08/jenis-sakit-kepala-700x467.jpg");
        temp.add("http://3.bp.blogspot.com/-wPx-h2M5Evc/T_qzQCtcj_I/AAAAAAAAAVA/Iz5LJaiow1o/s1600/cara+menghilangkan+panu.jpg");
        temp.add("https://statik.tempo.co/data/2012/09/10/id_139074/139074_620.jpg");
        temp.add("https://hellosehat.com/wp-content/uploads/2017/02/Makanan-dan-minuman-yang-baik-untuk-demam-berdarah-dengue-756x467.jpg");
        temp.add("https://cdn.sindonews.net/dyn/620/content/2018/08/27/155/1333308/batuk-dan-pilek-bisa-diatasi-tanpa-harus-minum-antibiotik-nhT.jpg");
        return temp;
    }
}
