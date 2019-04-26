package com.mrabid.pamedhisjav.fragment.Home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.activity.LoginActivity;
import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.helper.notification.Notifications;
import com.mrabid.pamedhisjav.model.Artikel;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.User;

import java.util.ArrayList;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

public class HomeFragment extends Fragment {

    ImageView profile,logout;
    LinearLayout loadArtikel;
    RecyclerView listArtikel;
    ArrayList<Artikel> listDataArtikel = new ArrayList<>();
    HomeArtikelAdapter  mAdapter;
    TextView nama,nik,alamat,noTelp,golDarah,jenisKelamin,email;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefs;
    User user;
    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        prefs = sharedPreferences.edit();
        user = new Gson().fromJson(sharedPreferences.getString("user",""),User.class);

        profile = getActivity().findViewById(R.id.home_ivProfile);
        loadArtikel = getActivity().findViewById(R.id.home_llArtikel);
        listArtikel = getActivity().findViewById(R.id.home_rvArtikel);
        nama = getActivity().findViewById(R.id.home_tvNamaPasien);
        nik = getActivity().findViewById(R.id.home_tvNikPasien);
        alamat = getActivity().findViewById(R.id.home_tvAlamatPasien);
        noTelp = getActivity().findViewById(R.id.home_tvTeleponPasien);
        golDarah = getActivity().findViewById(R.id.home_tvGolonganDarahPasien);
        jenisKelamin = getActivity().findViewById(R.id.home_tvJenisKelaminPasien);
        email = getActivity().findViewById(R.id.home_tvEmailPasien);
        logout = getActivity().findViewById(R.id.home_ivLogout);

        loadArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getActivity(), "Maintenance", Toast.LENGTH_SHORT).show(); }
        });

        listDataArtikel = loadData();
        mAdapter = new HomeArtikelAdapter(listDataArtikel,getActivity());
        listArtikel.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        listArtikel.setAdapter(mAdapter);

        //set Data to body
        setBody();

        profile.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Dokter dokter = new Dokter("123","wahyuabied","hash",1,"asdawidjaawa","u12/23872","Wahyu Abid","Sambungrejo","081217302696","wahyu.abied@gmail.com","Default.jpg");
                Notifications.displayNotification(getActivity(),dokter,new Gson().fromJson(sharedPreferences.getString("user",""),User.class));
            }
        });

        //logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setCancelable(false);
                dialog.setTitle("Logout").setMessage("Apakah anda ingin meneruskan keluar").setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        prefs.putString("user",new Gson().toJson(new User()));
                        prefs.apply();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        getActivity().finish();
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setIcon(R.drawable.ic_cancel_black_24dp);
                dialog.show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void setBody(){
        nama.setText(user.getNama());
        nik.setText("Nik : "+user.getNik());
        alamat.setText("Alamat : "+user.getAlamat());
        email.setText("Email : "+user.getEmail());
        golDarah.setText("Gol. Darah : "+user.getGolDarah());
        jenisKelamin.setText("Jenis Kelamin : "+user.getJenisKelamin());
        noTelp.setText("Telp : "+user.getNoTelp());
    }

    public ArrayList<Artikel> loadData(){
        ArrayList<Artikel> listDataDummy = new ArrayList<>();
        for(int i=0;i<5;i++)
            listDataDummy.add(new Artikel(1,"Ganteng Sekali","wowowow","wowowowo"));

        return listDataDummy;
    }

}
