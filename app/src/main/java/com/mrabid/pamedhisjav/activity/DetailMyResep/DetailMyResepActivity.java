package com.mrabid.pamedhisjav.activity.DetailMyResep;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.fragment.History.HistoryObatAdapter;
import com.mrabid.pamedhisjav.helper.retrofit.CallbackSelf;
import com.mrabid.pamedhisjav.helper.retrofit.ServicesPamedhis;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.Obat;
import com.mrabid.pamedhisjav.model.Resep;
import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailMyResepActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView back;
    RecyclerView recyclerView;
    TextView namaDokter,noIjinDokter,alamatDokter,namaPasien,alamatPasien,tanggal;
    Resep resep;
    Button beli;
    User user;
    SharedPreferences sharedPreferences;
    ProgressDialog progressDialog;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_my_resep);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Memproses...");
        toolbar = findViewById(R.id.toolbar);
        back = toolbar.findViewById(R.id.detailMyResep_ivBack);
        recyclerView = findViewById(R.id.detailMyResep_rvObat);
        namaDokter = findViewById(R.id.detailMyResep_tvNamaDokter);
        namaPasien = findViewById(R.id.detailMyResep_tvNamaPasien);
        noIjinDokter = findViewById(R.id.detailMyResep_tvSIP);
        alamatDokter = findViewById(R.id.detailMyResep_tvAlamatPraktek);
        alamatPasien = findViewById(R.id.detailMyResep_tvAlamatPasien);
        beli = findViewById(R.id.detailMyResep_btnBeli);
        tanggal = findViewById(R.id.detailMyResep_tvtanggal);

        sharedPreferences = getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        user = new Gson().fromJson(sharedPreferences.getString("user",""),User.class);

        resep = (Resep) getIntent().getSerializableExtra("resep");

        namaDokter.setText(resep.getDokter_docs().get(0).getNama());
        alamatDokter.setText(resep.getDokter_docs().get(0).getAlamat());
        noIjinDokter.setText(resep.getDokter_docs().get(0).getNoIzin());

        namaPasien.setText("Nama : "+user.getNama());
        alamatPasien.setText("Alamat : "+user.getAlamat());
        tanggal.setText(resep.getRiwayat().get(0).getData().getTanggal());

        DetailMyResepAdapter mAdapter = new DetailMyResepAdapter(this,resep.getResep());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                beliObat(new CallbackSelf() {
                    @Override
                    public void onSuccess(boolean result) {
                        if(result){
                            progressDialog.dismiss();
                        }
                    }
                });
            }
        });

    }

    public void beliObat(final CallbackSelf callbackSelf){
        ServicesPamedhis.buildServiceClient3030().beliObat(resep.get_id()).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if(response.body().getStatus()){
                    callbackSelf.onSuccess(true);
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                callbackSelf.onSuccess(false);
                Toast.makeText(DetailMyResepActivity.this, "Tidak da koneksi internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
