package com.example.artideco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlantsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProduit;
    private RecyclerView.LayoutManager layoutManager;
    private ProduitAdapter produitAdapter;
    TextView tv_Acheter ;
    // AJOUT
    private RecyclerView recyclerViewPot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);
        tv_Acheter = (TextView) findViewById(R.id.a1);

        tv_Acheter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(PlantsActivity.this);
                dialog.setContentView(R.layout.alert_plants);
                Button dialogButton = (Button) dialog.findViewById(R.id.cancel2);
                Button dialogButtonA = (Button) dialog.findViewById(R.id.confirm2);

                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Cancel..!!",Toast.LENGTH_LONG).show();
                    }
                });
                // if button is clicked, close the custom dialog

                // if button is clicked, close the custom dialog
                dialogButtonA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Confirm..",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(PlantsActivity.this, PayementActivity.class));
                    }
                });
                dialog.show();
            }
        });


        List<Produit> listProduit = new ArrayList<>();
        listProduit.add(new Produit(R.drawable.f2, "Monster  "));
        listProduit.add(new Produit(R.drawable.f1, "Palm"));
        listProduit.add(new Produit(R.drawable.f3, "Philodendron"));
        listProduit.add(new Produit(R.drawable.f4, "Feuille decore"));


        // on r??cup??re notre Recyclerview via son id
        recyclerViewProduit = findViewById(R.id.produit_recyclerview);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerViewProduit.setLayoutManager(layoutManager);
        //on donne notre adapter ?? notre recyclerview
        produitAdapter = new ProduitAdapter(listProduit, getApplicationContext());
        recyclerViewProduit.setAdapter(produitAdapter);
        //on s??pare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduit.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewProduit.addItemDecoration(dividerItemDecoration);
// AJOUT
        List<Produit> listPots = new ArrayList<>();
        listPots.add(new Produit(R.drawable.p4, "Pot 1  "));
        listPots.add(new Produit(R.drawable.p3, "Pot 2"));
        listPots.add(new Produit(R.drawable.p5, "Pot 3"));
        listPots.add(new Produit(R.drawable.p2, "Pot 4"));
        listPots.add(new Produit(R.drawable.p1, "Pot 5"));
        // on r??cup??re notre Recyclerview via son id
        recyclerViewProduit = findViewById(R.id.produit_recyclerview_pot);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerViewProduit.setLayoutManager(layoutManager);
        //on donne notre adapter ?? notre recyclerview
        produitAdapter = new ProduitAdapter(listPots, getApplicationContext());
        recyclerViewProduit.setAdapter(produitAdapter);
        //on s??pare chaque ligne de notre liste par un trait
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduit.getContext(), DividerItemDecoration.VERTICAL);
        recyclerViewProduit.addItemDecoration(dividerItemDecoration);
    }
    }