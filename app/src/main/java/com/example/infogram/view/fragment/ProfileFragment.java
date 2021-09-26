package com.example.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infogram.R;
import com.example.infogram.adapter.CardViewAdapter;
import com.example.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //toolbar
        showToolBar("", false,view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_profile);

        //Layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //el adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }
    public void showToolBar(String titulo, boolean botonSubir, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar_profile);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //creamos la lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://cronicoviajero.com/wp-content/uploads/DSCN1516-scaled.jpg", "Carlos Valdivia", "2 dias","1 me gusta"));
        images.add(new Image("https://laicismo.org/wp-content/uploads/2017/02/Monumento-Virgen-de-Socavon-en-Oruro-Bolivia.jpg", "Luis Perez", "3 dias","5 me gusta"));
        images.add(new Image("https://serturista.com/wp-content/uploads/2014/01/Castillo-de-la-Glorieta-2.jpg", "Fernando Torrico", "6 dias","4 me gusta"));
        images.add(new Image("https://www.laregion.bo/wp-content/uploads/2019/07/coroico-parapente.jpeg", "Maria Flores", "5 dias","6 me gusta"));
        images.add(new Image("https://www.wamanadventures.com/blog/wp-content/uploads/2019/06/La-Laguna-Colorada-Waman-Adventures.jpg", "Rolando Ramos", "3 dias","2 me gusta"));
        images.add(new Image("https://assets.cdnelnuevodiario.com/photos/0a8825a02c9611e893420eb04a1bba78.jpg", "William Jaimes", "4 dias","5 me gusta"));
        images.add(new Image("https://i2.wp.com/andorreandoporelmundo.com/wp-content/uploads/2019/02/IMG_5577.jpg?fit=1000%2C667&ssl=1", "Roberto Paniagua", "2 dias","3 me gusta"));
        images.add(new Image("https://www.lostiempos.com/sites/default/files/styles/noticia_detalle/public/media_imagen/2018/1/13/1-_roma_2-_hector_arnez.jpg?itok=UCQEK8Mi", "Lorena Herrera", "2 dias","8 me gusta"));
        images.add(new Image("https://media-cdn.tripadvisor.com/media/photo-s/0e/1b/f4/2a/fuerte-de-samaipata.jpg", "Laura Caceres", "6 dias","3 me gusta"));
        images.add(new Image("https://i1.wp.com/elcalderoviajero.com/wp-content/uploads/2018/04/bolivia-cochabamba-incachaca-15.jpg?resize=750%2C563&ssl=1", "Francisco Eduardo Tadeo", "1 dias","34 me gusta"));


        return images;
    }
}