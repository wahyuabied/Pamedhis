package com.mrabid.pamedhisjav.fragment.History;

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
import android.widget.Toast;

import com.google.gson.Gson;
import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.fragment.MyResep.MyResepAdapter;
import com.mrabid.pamedhisjav.helper.retrofit.CallbackSelf;
import com.mrabid.pamedhisjav.helper.retrofit.ServicesPamedhis;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.Obat;
import com.mrabid.pamedhisjav.model.Resep;
import com.mrabid.pamedhisjav.model.User;
import com.mrabid.pamedhisjav.model.response.ResponseResep;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    HistoryAdapter mAdapter;
    ArrayList<Resep> listDataResep = new ArrayList<>();
    SharedPreferences sharedPreferences;
    User user;
    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("data",MODE_NO_LOCALIZED_COLLATORS);
        user = new Gson().fromJson(sharedPreferences.getString("user",""),User.class);

        recyclerView = getActivity().findViewById(R.id.history_rvListHistoryResep);

        getDatas(new CallbackSelf() {
            @Override
            public void onSuccess(boolean result) {
                mAdapter = new HistoryAdapter(getActivity(),listDataResep);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(mAdapter);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    public void getDatas(final CallbackSelf callbackSelf){
        ServicesPamedhis.buildServiceClient3030().getMedicineAfter(user.getToken(),user.getIdPasien()).enqueue(new Callback<ResponseResep>() {
            @Override
            public void onResponse(Call<ResponseResep> call, Response<ResponseResep> response) {
                if(response.body().isStatus()){
                    listDataResep = response.body().getData();
                    callbackSelf.onSuccess(true);
                }
            }

            @Override
            public void onFailure(Call<ResponseResep> call, Throwable t) {
                Log.e("Error",t.toString());
                Toast.makeText(getActivity(), "Tidak ada koneksi internet", Toast.LENGTH_SHORT).show();
                callbackSelf.onSuccess(false);
            }
        });
    }


}
