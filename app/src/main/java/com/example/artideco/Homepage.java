package com.example.artideco;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Homepage extends Fragment {

    TextView plants;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.homepage,
                container,false);

        plants =(TextView)rootView.findViewById(R.id.plants);
        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getApplication(),PlantsActivity.class);
                startActivity(i);
            }
        });



        return rootView;

    }
}

