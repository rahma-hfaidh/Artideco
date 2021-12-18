package com.example.artideco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProduitAdapterGardens extends RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder> {

    List<Produit> listeProduit;
    Context context;

    public ProduitAdapterGardens(List<Produit> listeProduit, Context context) {
        this.listeProduit = listeProduit;
        this.context = context;
    }

    @NonNull
    @Override
    public ProduitAdapter.ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleviewitemchoix, parent,false);
        ProduitAdapter.ProduitViewHolder produitViewHolder= new ProduitAdapter.ProduitViewHolder(view);
        return produitViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ProduitAdapter.ProduitViewHolder holder, int position) {
        Produit produit = listeProduit.get(position);
        holder.image.setImageResource(produit.getImage());
        holder.titre.setText(produit.gettitre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,listeProduit.get(position).gettitre(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listeProduit.size();
    }

    public static class ProduitViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView titre;
        public ProduitViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagePlant);
            titre = itemView.findViewById(R.id.titrePlant);
        }
    }

}
