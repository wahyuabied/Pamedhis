package com.mrabid.pamedhisjav.activity;

import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.User;

public class NotificationActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView back,profileDokter;
    TextView namaDokter,contentDokter,detailDokter;
    Button accept,ignore;
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
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        dokter = (Dokter)getIntent().getSerializableExtra("dokter");
        user = (User)getIntent().getSerializableExtra("user");


        detailDokter.setText("SIP : "+dokter.getNoIzin()+"\nTelepon : "+dokter.getNoTelp()+"\nAlamat : "+dokter.getAlamat());
        namaDokter.setText("Dokter "+dokter.getNama());
        contentDokter.setText("Hai "+user.getNama()+", kami meninjau bahwa dokter "+dokter.getNama()+" ingin melihat data riwayat penyakit anda. Bagaimana tanggapan anda ?");

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.cancel(Integer.parseInt(getIntent().getStringExtra("id_notif")));
    }
}
