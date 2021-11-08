package com.example.artideco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PlantsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProduit;
    private RecyclerView.LayoutManager layoutManager;
    private ProduitAdapter produitAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);
        List<Produit> listProduit = new ArrayList<>();
        listProduit.add(new Produit(R.drawable.f2,"Monster  "));
        listProduit.add(new Produit(R.drawable.f1,"Palm"));
        listProduit.add(new Produit(R.drawable.f3,"Philodendron"));
        listProduit.add(new Produit(R.drawable.f4,"Feuille decore"));



        // on récupére notre Recyclerview via son id
        recyclerViewProduit=findViewById(R.id.produit_recyclerview);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewProduit.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listProduit, getApplicationContext());
        recyclerViewProduit.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduit.getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewProduit.addItemDecoration(dividerItemDecoration);
    }
}