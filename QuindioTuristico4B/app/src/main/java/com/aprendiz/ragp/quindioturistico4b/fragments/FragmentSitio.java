package com.aprendiz.ragp.quindioturistico4b.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.aprendiz.ragp.quindioturistico4b.R;
import com.aprendiz.ragp.quindioturistico4b.controllers.ActivityMenu;
import com.aprendiz.ragp.quindioturistico4b.controllers.Detalle;
import com.aprendiz.ragp.quindioturistico4b.models.AdapterT;
import com.aprendiz.ragp.quindioturistico4b.models.GestorDB;
import com.aprendiz.ragp.quindioturistico4b.models.Sitios;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSitio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSitio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    Button btnCambiar;
    int item;
    int detector=1;
    int rotation;
    AdapterT adapterT;
    GestorDB gestorDB;
    List<Sitios> sitiosList= new ArrayList<>();
    Sitios detallesitio = new Sitios();

    public FragmentSitio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSitio.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSitio newInstance(String param1, String param2) {
        FragmentSitio fragment = new FragmentSitio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_sitio, container, false);
        recyclerView= view.findViewById(R.id.recyclerViewS);
        btnCambiar = view.findViewById(R.id.btnCambiarS);

        rotation = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (rotation== Surface.ROTATION_0 || rotation==Surface.ROTATION_180){
            if (detector==1){
                item=R.layout.item_lista;
                gestorDB = new GestorDB(getContext());
                sitiosList = gestorDB.listarSitios();
                adapterT= new AdapterT(sitiosList,item,getContext());
                recyclerView.setAdapter(adapterT);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setHasFixedSize(true);
                adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                    @Override
                    public void itemClick(int position) {
                        ActivityMenu.sitios=sitiosList.get(position);
                        Intent intent = new Intent(getContext(),Detalle.class);
                        startActivity(intent);
                    }
                });
            }

            if (detector==2){
                item=R.layout.item_grid;
                gestorDB = new GestorDB(getContext());
                sitiosList = gestorDB.listarSitios();
                adapterT= new AdapterT(sitiosList,item,getContext());
                recyclerView.setAdapter(adapterT);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
                recyclerView.setHasFixedSize(true);
                adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                    @Override
                    public void itemClick(int position) {
                        ActivityMenu.sitios=sitiosList.get(position);
                        Intent intent = new Intent(getContext(),Detalle.class);
                        startActivity(intent);
                    }
                });
            }
        }else {
            item=R.layout.item_land;
            gestorDB = new GestorDB(getContext());
            sitiosList = gestorDB.listarSitios();
            adapterT= new AdapterT(sitiosList,item,getContext());
            recyclerView.setAdapter(adapterT);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);
            adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                @Override
                public void itemClick(int position) {
                    detallesitio= sitiosList.get(position);
                }
            });
        }



        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detector==1) {
                    item = R.layout.item_lista;
                    gestorDB = new GestorDB(getContext());
                    sitiosList = gestorDB.listarSitios();
                    adapterT = new AdapterT(sitiosList, item, getContext());
                    recyclerView.setAdapter(adapterT);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                    recyclerView.setHasFixedSize(true);
                    adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                        @Override
                        public void itemClick(int position) {
                            ActivityMenu.sitios=sitiosList.get(position);
                            Intent intent = new Intent(getContext(),Detalle.class);
                            startActivity(intent);
                        }
                    });



                }
                if (detector==2){
                    item=R.layout.item_grid;
                    gestorDB = new GestorDB(getContext());
                    sitiosList = gestorDB.listarSitios();
                    adapterT= new AdapterT(sitiosList,item,getContext());
                    recyclerView.setAdapter(adapterT);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));
                    recyclerView.setHasFixedSize(true);
                    adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                        @Override
                        public void itemClick(int position) {
                            ActivityMenu.sitios=sitiosList.get(position);
                            Intent intent = new Intent(getContext(),Detalle.class);
                            startActivity(intent);
                        }
                    });
                }

                if (detector==1){
                    detector=2;
                }else {
                    if (detector == 2) {
                        detector = 1;
                    }
                }

            }
        });
        return view;
    }

}
