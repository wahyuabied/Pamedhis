package com.mrabid.pamedhisjav.fragment.History;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Dokter;
import com.mrabid.pamedhisjav.model.Resep;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Resep> listDataResep;
    HistoryAdapter mAdapter;
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.history_rvListHistoryResep);
        listDataResep = loadData();
        mAdapter = new HistoryAdapter(listDataResep,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    public ArrayList<Resep> loadData(){
        ArrayList<Resep> listDummyResep = new ArrayList<>();
        Dokter dokter = new Dokter(1,"Wahyu Abid","asasd","Kejiwaan","081217302696");
            for(int i =0;i<5;i++)
                listDummyResep.add(new Resep(1,"Wahyu Abid A","21-05-1997","124",dokter,"Dibayar"));
        return listDummyResep;
    }

}
