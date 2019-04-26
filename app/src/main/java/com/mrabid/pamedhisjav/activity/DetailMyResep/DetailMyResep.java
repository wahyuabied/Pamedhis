package com.mrabid.pamedhisjav.activity.DetailMyResep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.fragment.History.HistoryObatAdapter;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.Obat;
import com.mrabid.pamedhisjav.model.Resep;

import java.util.ArrayList;

public class DetailMyResep extends AppCompatActivity {

    Toolbar toolbar;
    ImageView back;
    RecyclerView recyclerView;
    TextView namaDokter,noIjinDokter,alamatDokter,namaPasien,alamatPasien,tanggal;
    Resep resep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_my_resep);

        toolbar = findViewById(R.id.toolbar);
        back = toolbar.findViewById(R.id.detailMyResep_ivBack);
        recyclerView = findViewById(R.id.detailMyResep_rvObat);
        namaDokter = findViewById(R.id.detailMyResep_tvNamaDokter);
        namaPasien = findViewById(R.id.detailMyResep_tvNamaPasien);
        noIjinDokter = findViewById(R.id.detailMyResep_tvSIP);
        alamatDokter = findViewById(R.id.detailMyResep_tvAlamatPraktek);
        alamatPasien = findViewById(R.id.detailMyResep_tvAlamatPasien);
        tanggal = findViewById(R.id.detailMyResep_tvtanggal);

//        resep = (Resep) getIntent().getSerializableExtra("resep");

        //masih
        ArrayList<Obat> obats = new ArrayList<>();
        for(int i =0;i<5;i++)
           obats.add(new Obat(1,"Paracetamol"));
        Dokter dokter = new Dokter("123","wahyuabied","hash",1,"asdawidjaawa","u12/23872","Wahyu Abid","Sambungrejo","081217302696","wahyu.abied@gmail.com","Default.jpg");
        resep = new Resep(1,"Pasien Wahyu Abid","21-05-1997","50.000",dokter,"Belum Dibeli",obats);


        DetailMyResepAdapter mAdapter = new DetailMyResepAdapter(this,resep.getObats());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
}
