package com.mrabid.pamedhisjav.fragment.Home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.mrabid.pamedhisjav.helper.retrofit.CallbackSelf;
import com.mrabid.pamedhisjav.helper.retrofit.ServicesPamedhis;
import com.mrabid.pamedhisjav.model.Artikel;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.RumahSakit;
import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseArtikel;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

public class HomeFragment extends Fragment implements LocationListener {

    ImageView profile,logout;
    CardView findNearest,about;
    LinearLayout loadArtikel;
    RecyclerView listArtikel;
    ArrayList<Artikel>artikels = new ArrayList<>();
    HomeArtikelAdapter  mAdapter;
    TextView nama,nik,alamat,noTelp,golDarah,jenisKelamin,email;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefs;
    ArrayList<RumahSakit> rumahSakits = new ArrayList<>();
    LocationManager locationManager;
    Location tempLocation;
    int datake = 0;
    String longitude,latitude;
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
        findNearest = getActivity().findViewById(R.id.home_cvFindNearest);
        about = getActivity().findViewById(R.id.home_cvAbout);

        loadArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Toast.makeText(getActivity(), "Maintenance", Toast.LENGTH_SHORT).show(); }
        });

        getArtikel(new CallbackSelf() {
            @Override
            public void onSuccess(boolean result) {
                if (result){
                    mAdapter = new HomeArtikelAdapter(artikels,getActivity());
                    listArtikel.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
                    listArtikel.setAdapter(mAdapter);
                }
            }
        });



        //set Data to body
        setBody();

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

        //Location
        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
            Toast.makeText(getActivity(), "Maaf kami perlu akses location", Toast.LENGTH_SHORT).show();
        }
        try {
            getLocation();
        }catch (Exception e){
        }

        findNearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    nearestHospital();
                }catch (Exception e){
                    Log.e("Error",e.toString());
                    Toast.makeText(getActivity(), "Tidak bisa mengakses lokasi anda(tolong nyalakan data anda)", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void getArtikel(final CallbackSelf callbackSelf){
        ServicesPamedhis.buildServiceClient3030().getArtikel(user.getToken()).enqueue(new Callback<ResponseArtikel>() {
            @Override
            public void onResponse(Call<ResponseArtikel> call, Response<ResponseArtikel> response) {
                if(response.body().isStatus()){
                    artikels = response.body().getData();
                    callbackSelf.onSuccess(true);
                }else{
                    callbackSelf.onSuccess(false);
                    Toast.makeText(getActivity(), "Maaf ada sesuatu yang salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArtikel> call, Throwable t) {
                callbackSelf.onSuccess(false);
                Log.e("Error",t.toString());
                Toast.makeText(getActivity(), "Tidak ada koneksi  internet", Toast.LENGTH_SHORT).show();
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
    public void nearestHospital(){
        rumahSakits.add(new RumahSakit("Bali","-8.714967", "115.185362"));
        rumahSakits.add(new RumahSakit("Lippo Village", "-6.225437", "106.597845"));
        rumahSakits.add(new RumahSakit("Kebun Jeruk", "-6.190833", "106.763534"));
        rumahSakits.add(new RumahSakit("Semanggi", "-6.219056", "106.817158"));
        rumahSakits.add(new RumahSakit("Simatupang","-6.2924", "106.784308"));
        rumahSakits.add(new RumahSakit("Surabaya Siloam", "-7.2740468", "112.7463719"));
        rumahSakits.add(new RumahSakit("Yogyakarta", "-7.7834413", "110.3908755"));

        Location currentLoca = new Location("");
        currentLoca.setLatitude(Double.parseDouble(sharedPreferences.getString("latitude","")));
        currentLoca.setLongitude(Double.parseDouble(sharedPreferences.getString("longitude","")));
        Location rumahSakitLoc = new Location("");
        rumahSakitLoc.setLongitude(Double.parseDouble(rumahSakits.get(0).getLongitude()));
        rumahSakitLoc.setLatitude(Double.parseDouble(rumahSakits.get(0).getLatitude()));

        double distance =currentLoca.distanceTo(rumahSakitLoc);
        for(int i=0;i<rumahSakits.size();i++){
            rumahSakitLoc.setLongitude(Double.parseDouble(rumahSakits.get(i).getLongitude()));
            rumahSakitLoc.setLatitude(Double.parseDouble(rumahSakits.get(i).getLatitude()));
            double distanceInMeters = currentLoca.distanceTo(rumahSakitLoc);
            int retval = Double.compare(distance, distanceInMeters);
            if(retval>0){
                datake = i;
            }
        }
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", Double.parseDouble(rumahSakits.get(datake).getLatitude()), Double.parseDouble(rumahSakits.get(datake).getLongitude()), "Where the party is at");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
    public void getLocation(){
        try {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) this);
            if(longitude.equalsIgnoreCase("")){
                tempLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                latitude = tempLocation.getLatitude()+"";
                longitude = tempLocation.getLongitude()+"";
                prefs.putString("latitude",latitude);
                prefs.putString("longitude",longitude);
                prefs.apply();
            }
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onLocationChanged(Location location) {
        longitude = location.getLongitude()+"";
        latitude = location.getLatitude()+"";
        prefs.putString("longitude",longitude);
        prefs.putString("latitude",latitude);
        prefs.apply();
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
    @Override
    public void onProviderEnabled(String provider) {

    }
    @Override
    public void onProviderDisabled(String provider) {

    }
}
