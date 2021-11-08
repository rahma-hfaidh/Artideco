package com.example.artideco;


import android.widget.ImageView;

public class Produit {
    int image;
    String titre;

    public Produit(int image, String titre) {
        this.image = image;
        this.titre = titre;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String gettitre() {
        return titre;
    }

    public void settitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "image='" + image + '\'' +
                ", titre='" + titre + '\'' +
                '}';
    }
}
