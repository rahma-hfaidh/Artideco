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

public class FlowersActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProduit;
    private RecyclerView.LayoutManager layoutManager;
    private ProduitAdapter produitAdapter;
    TextView tv_Acheter ;
    // AJOUT
    private RecyclerView recyclerViewPot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);
        tv_Acheter =(TextView)findViewById(R.id.a2);


        tv_Acheter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // custom dialog
                final Dialog dialog = new Dialog(FlowersActivity.this);
                dialog.setContentView(R.layout.alert_flowers);
                Button dialogButton = (Button) dialog.findViewById(R.id.cancel1);
                Button dialogButtonA = (Button) dialog.findViewById(R.id.confirm1);

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
                        startActivity(new Intent(FlowersActivity.this, PayementActivity.class));
                    }
                });
                dialog.show();
            }
        });


        List<Produit> listProduit = new ArrayList<>();
        listProduit.add(new Produit(R.drawable.fw1,"Flower "));
        listProduit.add(new Produit(R.drawable.fw3,"Flower"));
        listProduit.add(new Produit(R.drawable.fw2,"Flower"));
        listProduit.add(new Produit(R.drawable.fw5,"Flower "));



        // on récupére notre Recyclerview via son id
        recyclerViewProduit=findViewById(R.id.produit_recyclerview2);
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
// AJOUT
        List<Produit> listPots = new ArrayList<>();
        listPots.add(new Produit(R.drawable.emb1,"Pot 1  "));
        listPots.add(new Produit(R.drawable.emb2,"Pot 2"));
        listPots.add(new Produit(R.drawable.emb3,"Pot 3"));
        listPots.add(new Produit(R.drawable.emb4,"Pot 4"));
        listPots.add(new Produit(R.drawable.emb5,"Pot 5"));
        listPots.add(new Produit(R.drawable.emb6,"Pot 5"));
        listPots.add(new Produit(R.drawable.emb7,"Pot 5"));
        // on récupére notre Recyclerview via son id
        recyclerViewProduit=findViewById(R.id.produit_recyclerview_support);
        //on veut un recyclerview qui utilise un linearlayoutManager
        layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recyclerViewProduit.setLayoutManager(layoutManager);
        //on donne notre adapter à notre recyclerview
        produitAdapter = new ProduitAdapter(listPots, getApplicationContext());
        recyclerViewProduit.setAdapter(produitAdapter);
        //on sépare chaque ligne de notre liste par un trait
        dividerItemDecoration = new DividerItemDecoration(recyclerViewProduit.getContext(),DividerItemDecoration.VERTICAL);
        recyclerViewProduit.addItemDecoration(dividerItemDecoration);





    }
}