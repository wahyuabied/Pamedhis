package com.mrabid.pamedhisjav.activity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.BlockRiwayat;
import com.mrabid.pamedhisjav.model.Riwayat;
import com.mrabid.pamedhisjav.model.User;

public class DetailRiwayatActivity extends AppCompatActivity {

    TextView title,namaPasien,nikPasien,beratpasien,tinggiPasien,umurPasien,kesehatanKeluarga,keluhanUtama,diagnosa,larangan
            ,pemeriksaPenunjang,perawatan,advis,head,neck,thorax,abdomen,ekstremitas,catatan;
    TextView namaDokter,alamatDokter,teleponDokter,emailDokter,sipDokter;
    RelativeLayout dropDown;
    LinearLayout linearLayout;
    ImageView imageView,back;
    Toolbar toolbar;
    BlockRiwayat blockRiwayat;
    SharedPreferences sharedPreferences;
    User user;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_riwayat);

        sharedPreferences = getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        toolbar = findViewById(R.id.toolbar);
        back = toolbar.findViewById(R.id.detailRiwayat_ivBack);
        dropDown = findViewById(R.id.detailRiwayat_rlIdentitasDokter);
        imageView = findViewById(R.id.detailRiwayat_ivDropDown);
        title = findViewById(R.id.detailRiwayat_tvTitle);
        namaPasien = findViewById(R.id.detailRiwayat_tvNamaPasien);
        nikPasien = findViewById(R.id.detailRiwayat_tvNikPasien);
        beratpasien = findViewById(R.id.detailRiwayat_tvBeratPasien);
        tinggiPasien = findViewById(R.id.detailRiwayat_tvTinggiPasien);
        umurPasien = findViewById(R.id.detailRiwayat_tvUmurPasien);
        kesehatanKeluarga = findViewById(R.id.detailRiwayat_tvKesehatanKeluarga);
        keluhanUtama = findViewById(R.id.detailRiwayat_tvKeluhanUtama);
        diagnosa = findViewById(R.id.detailRiwayat_tvDiagnosa);
        larangan = findViewById(R.id.detailRiwayat_tvLarangan);
        pemeriksaPenunjang = findViewById(R.id.detailRiwayat_tvPemeriksaPenunjang);
        perawatan = findViewById(R.id.detailRiwayat_tvPerawatan);
        advis = findViewById(R.id.detailRiwayat_tvAdvis);
        head = findViewById(R.id.detailRiwayat_tvHead);
        neck = findViewById(R.id.detailRiwayat_tvNeck);
        thorax = findViewById(R.id.detailRiwayat_tvThorax);
        abdomen = findViewById(R.id.detailRiwayat_tvAbdomen);
        ekstremitas = findViewById(R.id.detailRiwayat_tvEkstremitas);
        catatan = findViewById(R.id.detailRiwayat_tvCatatan);
        linearLayout = findViewById(R.id.detailRiwayat_llIdentitas);
        namaDokter = findViewById(R.id.detailRiwayat_tvNamaDokter);
        alamatDokter = findViewById(R.id.detailRiwayat_tvAlamatDokter);
        sipDokter = findViewById(R.id.detailRiwayat_tvSIPDokter);
        emailDokter = findViewById(R.id.detailRiwayat_tvEmailDokter);
        teleponDokter = findViewById(R.id.detailRiwayat_tvTeleponDokter);

        blockRiwayat =(BlockRiwayat) getIntent().getSerializableExtra("block_riwayat");
        user = new Gson().fromJson(sharedPreferences.getString("user",""),User.class);

        title.setText("Laporan Riwayat\n"+blockRiwayat.getDokter_docs().get(0).getNama());
        namaPasien.setText("Nama : "+user.getNama());
        nikPasien.setText("NIK : "+user.getNik());
        beratpasien.setText("Berat : "+blockRiwayat.getData().getBeratBadan()+" Kg");
        tinggiPasien.setText("Tinggi : "+blockRiwayat.getData().getTinggiBadan()+" Cm");
        umurPasien.setText("Umur : "+blockRiwayat.getData().getUmur());
        kesehatanKeluarga.setText("Kes. Keluarga : "+blockRiwayat.getData().getRiwayatKesehatanKeluarga());
        keluhanUtama.setText("Keluhan Utama : "+ blockRiwayat.getData().getKeluhanUtama());
        diagnosa.setText("Diagnosa : " + blockRiwayat.getData().getDiagnosa());
        larangan.setText("Larangan : "+ blockRiwayat.getData().getLarangan());
        pemeriksaPenunjang.setText("Pemeriksa Penunjang : "+ blockRiwayat.getData().getPemeriksaPenunjang());
        perawatan.setText("Perawatan : "+ blockRiwayat.getData().getPerawatan());
        advis.setText("Advis : "+ blockRiwayat.getData().getAdvis());
        head.setText("Head : "+ blockRiwayat.getData().getHead());
        neck.setText("Neck : "+blockRiwayat.getData().getNeck());
        thorax.setText("Thorak : "+ blockRiwayat.getData().getThorax());
        abdomen.setText("Abdomen : "+blockRiwayat.getData().getAbdomen());
        ekstremitas.setText("Ekstremitas : "+blockRiwayat.getData().getEkstremitas());
        catatan.setText("Catatan : "+blockRiwayat.getData().getCatatan());
        namaDokter.setText("Nama : "+blockRiwayat.getDokter_docs().get(0).getNama());
        alamatDokter.setText("Alamat : "+ blockRiwayat.getDokter_docs().get(0).getAlamat());
        emailDokter.setText("Email : "+blockRiwayat.getDokter_docs().get(0).getEmail());
        teleponDokter.setText("Telepon : "+blockRiwayat.getDokter_docs().get(0).getNoTelp());
        sipDokter.setText("SIP : "+blockRiwayat.getDokter_docs().get(0).getNoIzin());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        dropDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(linearLayout.getVisibility() == View.GONE){
                    linearLayout.startAnimation(AnimationUtils.loadAnimation(DetailRiwayatActivity.this,R.anim.slide_down));
                    imageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    linearLayout.setVisibility(View.VISIBLE);
                }else{
                    imageView.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
                    linearLayout.startAnimation(AnimationUtils.loadAnimation(DetailRiwayatActivity.this,R.anim.slide_up));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            linearLayout.setVisibility(View.GONE);
                        }
                    },500);

                }
            }
        });

    }
}
