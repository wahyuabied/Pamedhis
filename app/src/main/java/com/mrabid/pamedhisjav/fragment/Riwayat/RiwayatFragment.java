package com.mrabid.pamedhisjav.fragment.Riwayat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.Riwayat;

import java.util.ArrayList;

public class RiwayatFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayout list,graphic;
    ArrayList<Riwayat> listDataRiwayat = new ArrayList<>();
    RiwayatAdapter mAdapter;
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.riwayat_rvListRiwayat);
        list = getActivity().findViewById(R.id.riwayat_llList);
        graphic = getActivity().findViewById(R.id.riwayat_llGraphic);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graphic.setVisibility(View.VISIBLE);
                list.setVisibility(View.GONE);
            }
        });

        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graphic.setVisibility(View.GONE);
                list.setVisibility(View.VISIBLE);
            }
        });

        listDataRiwayat = getListDataRiwayat();
        mAdapter = new RiwayatAdapter(listDataRiwayat,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat, container, false);
    }

    public ArrayList<Riwayat> getListDataRiwayat() {
        ArrayList<Riwayat> listDummyRiwayat = new ArrayList<>();
        Dokter dokter = new Dokter(1,"Wahyu Abid","asasd","Kejiwaan","081217302696");
        for(int i=0;i<5;i++)
            listDummyRiwayat.add(new Riwayat(1,dokter,"21 April 2019","Sambungrejo Rt 18 Rw 07","Depresi Ringan"));

        return listDummyRiwayat;
    }
}
