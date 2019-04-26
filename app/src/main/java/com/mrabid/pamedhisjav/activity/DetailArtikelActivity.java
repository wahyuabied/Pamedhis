package com.mrabid.pamedhisjav.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Artikel;
import com.squareup.picasso.Picasso;

public class DetailArtikelActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView back,imageArtikel;
    TextView  judul,isi;
    Artikel artikel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);

        toolbar = findViewById(R.id.toolbar);
        back = toolbar.findViewById(R.id.detailArtikel_ivBack);
        imageArtikel = findViewById(R.id.detailArtikel_ivArtikel);
        judul = findViewById(R.id.detailArtikel_tvJudul);
        isi = findViewById(R.id.detailArtikel_tvIsi);

        artikel =(Artikel) getIntent().getSerializableExtra("artikel");
        Picasso.with(this).load(getIntent().getStringExtra("gambarArtikel")).into(imageArtikel);
        judul.setText(artikel.getJudul());
        isi.setText(artikel.getIsi());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
}
