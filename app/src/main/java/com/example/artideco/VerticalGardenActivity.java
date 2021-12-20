package com.example.artideco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class VerticalGardenActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProduit;
    private RecyclerView.LayoutManager layoutManager;
    private ProduitAdapter produitAdapter;
    TextView tv_Acheter ;
    // AJOUT
    private RecyclerView recyclerViewPot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_garden);
        tv_Acheter =(TextView)findViewById(R.id.a3);
        tv_Acheter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(VerticalGardenActivity.this);
                dialog.setContentView(R.layout.alerty_garden);
                Button dialogButton = (Button) dialog.findViewById(R.id.cancel3);
                Button dialogButtonA = (Button) dialog.findViewById(R.id.confirm3);

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
                        startActivity(new Intent(VerticalGardenActivity.this, PayementActivity.class));
                    }
                });
                dialog.show();
            }
        });


        //Vertical Garden

        List<Produit> listProduitGardens = new ArrayList<>();
        listProduitGardens.add(new Produit(R.drawable.v4,"Monster  "));
        listProduitGardens.add(new Produit(R.drawable.v5,"Palm"));
        listProduitGardens.add(new Produit(R.drawable.v3,"Philodendron"));
        listProduitGardens.add(new Produit(R.drawable.v2,"Feuille decore"));
        listProduitGardens.add(new Produit(R.drawable.v1,"Feuille decore"));



        // on récupére notre Recyclerview via son id
        recyclerViewProduit=findViewById(R.id.produit_recyclerview3);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewProduit.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listProduitGardens, getApplicationContext());
        recyclerViewProduit.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        DividerItemDecoration dividerItemDecoration;
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduit.getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewProduit.addItemDecoration(dividerItemDecoration);

    }
}