package com.mrabid.pamedhisjav.fragment.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mrabid.pamedhisjav.R;
import com.mrabid.pamedhisjav.model.Artikel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ImageView profile;
    LinearLayout loadArtikel;
    RecyclerView listArtikel;
    ArrayList<Artikel> listDataArtikel = new ArrayList<>();
    HomeArtikelAdapter  mAdapter;
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        profile = getActivity().findViewById(R.id.home_ivProfile);
        loadArtikel = getActivity().findViewById(R.id.home_llArtikel);
        listArtikel = getActivity().findViewById(R.id.home_rvArtikel);

        loadArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Maintenance", Toast.LENGTH_SHORT).show();
            }
        });


        listDataArtikel = loadData();
        mAdapter = new HomeArtikelAdapter(listDataArtikel,getActivity());
        listArtikel.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        listArtikel.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public ArrayList<Artikel> loadData(){
        ArrayList<Artikel> listDataDummy = new ArrayList<>();
        for(int i=0;i<5;i++)
            listDataDummy.add(new Artikel(1,"Ganteng Sekali","wowowow","wowowowo"));

        return listDataDummy;
    }

}
