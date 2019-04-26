package com.mrabid.pamedhisjav.fragment.Riwayat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.helper.retrofit.CallbackSelf;
import com.mrabid.pamedhisjav.helper.retrofit.ServicesPamedhis;
import com.mrabid.pamedhisjav.model.BlockRiwayat;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.Riwayat;
import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseRiwayat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;
import static android.view.View.GONE;

public class RiwayatFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayout list,graphic;
    SharedPreferences sharedPreferences;
    ProgressBar loading;
    User user;
    RiwayatAdapter mAdapter;
    ArrayList<BlockRiwayat> listDataRiwayat;
    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        loading = getActivity().findViewById(R.id.riwayat_pb);
        recyclerView = getActivity().findViewById(R.id.riwayat_rvListRiwayat);
        list = getActivity().findViewById(R.id.riwayat_llList);
        graphic = getActivity().findViewById(R.id.riwayat_llGraphic);

        user = new Gson().fromJson(sharedPreferences.getString("user",""), User.class);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graphic.setVisibility(View.VISIBLE);
                list.setVisibility(GONE);
            }
        });

        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graphic.setVisibility(GONE);
                list.setVisibility(View.VISIBLE);
            }
        });

        getData(new CallbackSelf() {
            @Override
            public void onSuccess(boolean result) {
                if(result){
                    loading.setVisibility(GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    mAdapter = new RiwayatAdapter(listDataRiwayat,getActivity());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(mAdapter);
                }
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat, container, false);
    }

    public void getData( final CallbackSelf callbackSelf){
        ServicesPamedhis.buildServiceClientHeader().getRiwayat(user.getIdPasien(),user.getToken()).enqueue(new Callback<ResponseRiwayat>() {
            @Override
            public void onResponse(Call<ResponseRiwayat> call, Response<ResponseRiwayat> response) {
                if(response.body().getStatus()){
                    listDataRiwayat = response.body().getData();
                    callbackSelf.onSuccess(true);
                }else {
                    Toast.makeText(getActivity(), "Ups data tidak ditemukan", Toast.LENGTH_SHORT).show();
                    loading.setVisibility(GONE);
                    callbackSelf.onSuccess(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseRiwayat> call, Throwable t) {
                callbackSelf.onSuccess(false);
                loading.setVisibility(GONE);
                Toast.makeText(getActivity(), "Check internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
