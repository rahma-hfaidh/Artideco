package com.example.artideco;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends Fragment {

    private RecyclerView recyclerViewProduitPlants;
    private RecyclerView recyclerViewProduitFlowers;
    private RecyclerView recyclerViewProduitGardens;
    private RecyclerView.LayoutManager layoutManager;
    private ProduitAdapter produitAdapter;

    TextView textPlants;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.homepage,
                container,false);

        textPlants =(TextView)rootView.findViewById(R.id.text_plants);
        textPlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(),PlantsActivity.class);
                startActivity(i);
            }
        });

        //Plants

        List<Produit> listProduitPlants = new ArrayList<>();
        listProduitPlants.add(new Produit(R.drawable.picc1,"Monster  "));
        listProduitPlants.add(new Produit(R.drawable.pic55,"Palm"));
        listProduitPlants.add(new Produit(R.drawable.pic22,"Philodendron"));
        listProduitPlants.add(new Produit(R.drawable.pic1,"Feuille decore"));



        // on récupére notre Recyclerview via son id
        recyclerViewProduitPlants=rootView.findViewById(R.id.produit_plants_recyclerview);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerViewProduitPlants.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listProduitPlants, getContext());
        recyclerViewProduitPlants.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduitPlants.getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewProduitPlants.addItemDecoration(dividerItemDecoration);

        // Flowers

        List<Produit> listProduitFlowers = new ArrayList<>();
        listProduitFlowers.add(new Produit(R.drawable.fl2,"Monster  "));
        listProduitFlowers.add(new Produit(R.drawable.fl5,"Palm"));
        listProduitFlowers.add(new Produit(R.drawable.fl6,"Philodendron"));
        listProduitFlowers.add(new Produit(R.drawable.fl1,"Feuille decore"));
        listProduitFlowers.add(new Produit(R.drawable.fl3,"Feuille decore"));

        // on récupére notre Recyclerview via son id
        recyclerViewProduitFlowers=rootView.findViewById(R.id.produit_flowers_recyclerview);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerViewProduitFlowers.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listProduitFlowers, getContext());
        recyclerViewProduitFlowers.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduitFlowers.getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewProduitFlowers.addItemDecoration(dividerItemDecoration);


        //Vertical Garden

        List<Produit> listProduitGardens = new ArrayList<>();
        listProduitGardens.add(new Produit(R.drawable.v4,"Monster  "));
        listProduitGardens.add(new Produit(R.drawable.v5,"Palm"));
        listProduitGardens.add(new Produit(R.drawable.v3,"Philodendron"));
        listProduitGardens.add(new Produit(R.drawable.v2,"Feuille decore"));
        listProduitGardens.add(new Produit(R.drawable.v1,"Feuille decore"));

        // on récupére notre Recyclerview via son id
        recyclerViewProduitGardens=rootView.findViewById(R.id.produit_gardens_recyclerview);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        recyclerViewProduitGardens.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listProduitGardens, getContext());
        recyclerViewProduitGardens.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduitGardens.getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewProduitGardens.addItemDecoration(dividerItemDecoration);




        return rootView;

    }
}

