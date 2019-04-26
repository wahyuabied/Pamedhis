package com.mrabid.pamedhisjav.fragment.MyResep;

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
import com.mrabid.pamedhisjav.model.Obat;
import com.mrabid.pamedhisjav.model.Resep;

import java.util.ArrayList;

public class MyResepFragment extends Fragment {

    RecyclerView recyclerView;
    MyResepAdapter mAdapter;
    ArrayList<Resep> listDataResep = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.myresep_rvListResep);

        DummyData();

        mAdapter = new MyResepAdapter(getActivity(),listDataResep);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_resep, container, false);
    }

    public void DummyData(){
        ArrayList<Obat> obats = new ArrayList<>();
        for(int i =0;i<5;i++)
            obats.add(new Obat(1,"Paracetamol"));
        Dokter dokter = new Dokter("123","wahyuabied","hash",1,"asdawidjaawa","u12/23872","Wahyu Abid","Sambungrejo","081217302696","wahyu.abied@gmail.com","Default.jpg");
        for(int i =0;i<2;i++)
        listDataResep.add(new Resep(1,"Pasien Wahyu Abid","21-05-1997","50.000",dokter,"Belum Dibeli",obats));
    }


}
