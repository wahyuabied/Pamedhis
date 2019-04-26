package com.mrabid.pamedhisjav.activity;

import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.helper.retrofit.CallbackSelf;
import com.mrabid.pamedhisjav.helper.retrofit.ServicesPamedhis;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseDokter;
import com.mrabid.pamedhisjav.model.response.ResponseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView back,profileDokter;
    TextView namaDokter,contentDokter,detailDokter;
    Button accept,ignore;
    String idUser;
    Dokter dokter;
    User user;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar = findViewById(R.id.toolbar);
        back = toolbar.findViewById(R.id.notification_ivBack);
        namaDokter = findViewById(R.id.notification_tvNameDokter);
        profileDokter = findViewById(R.id.notification_ivProfileDokter);
        detailDokter = findViewById(R.id.notification_tvDetailDokter);
        accept = findViewById(R.id.notification_btnAccept);
        ignore = findViewById(R.id.notification_btnIgnore);
        contentDokter = findViewById(R.id.notification_tvContentDokter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { onBackPressed();finish();
            }
        });

        idUser = getIntent().getStringExtra("idUser");
        Log.e("idUser",idUser);

        user = (User)getIntent().getSerializableExtra("user");

        getDataDokter(idUser, new CallbackSelf() {
            @Override
            public void onSuccess(boolean result) {
                profileDokter.setImageResource(R.drawable.img_dokter);
                detailDokter.setText("SIP : "+dokter.getNoIzin()+"\nTelepon : "+dokter.getNoTelp()+"\nAlamat : "+dokter.getAlamat());
                namaDokter.setText("Dokter "+dokter.getNama());
                contentDokter.setText("Hai "+user.getNama()+", kami meninjau bahwa dokter "+dokter.getNama()+" ingin melihat data riwayat penyakit anda. Bagaimana tanggapan anda ?");
            }
        });

        final NotificationManager notificationManager = getSystemService(NotificationManager.class);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givePermission(new CallbackSelf() {
                    @Override
                    public void onSuccess(boolean result) {
                        if(result){
                            notificationManager.cancel(Integer.parseInt(getIntent().getStringExtra("id_notif")));
                            onBackPressed();
                            finish();
                        }
                    }
                });
            }
        });

        ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                notificationManager.cancel(Integer.parseInt(getIntent().getStringExtra("id_notif")));
                finish();
            }
        });
    }

    public void getDataDokter(String idUser, final CallbackSelf callbackSelf){
        ServicesPamedhis.buildServiceClient().getDokter(idUser).enqueue(new Callback<ResponseDokter>() {
            @Override
            public void onResponse(Call<ResponseDokter> call, Response<ResponseDokter> response) {
                if(response.body().isStatus()){
                    dokter = response.body().getData();
                    callbackSelf.onSuccess(true);
                }else {
                    Toast.makeText(NotificationActivity.this, "Maaf server kami sedang mengalami masalah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDokter> call, Throwable t) {
                callbackSelf.onSuccess(false);
                Log.e("NotificationActivity",t.toString());
                Toast.makeText(NotificationActivity.this, "Tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void givePermission(final CallbackSelf callbackSelf){
        ServicesPamedhis.buildServiceClientHeader().getPermission(user.getIdPasien(),idUser,user.getToken()).enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if(response.body().getStatus()){
                    Toast.makeText(NotificationActivity.this, "Access telah diberikan kepada "+ dokter.getNama(), Toast.LENGTH_SHORT).show();
                    callbackSelf.onSuccess(true);
                }else {
                    Toast.makeText(NotificationActivity.this, "Maaf ada kesalahan terjadi", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Toast.makeText(NotificationActivity.this, "Tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
