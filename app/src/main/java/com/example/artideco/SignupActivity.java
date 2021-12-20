package com.example.artideco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    ImageView imgBack;
    TextView tv_valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setContentView(R.layout.activity_signup);
        imgBack=(ImageView)findViewById(R.id.img_back);
        tv_valider=(TextView) findViewById(R.id.tv_valider);
        Intent intent=getIntent();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tv_valider.setOnClickListener(new View.OnClickListener() {
            String plantsText="";
            String flowersText="";
            String gardensText="";
            @Override
            public void onClick(View v) {
                if(getIntent() != null)
                {
                    if(intent.hasExtra("plants"))
                    {
                        plantsText= intent.getStringExtra("plants");
                        startActivity(new Intent(SignupActivity.this, PlantsActivity.class));

                    }
                    else if(intent.hasExtra("flowers"))
                    {
                        flowersText= intent.getStringExtra("flowers");
                        startActivity(new Intent(SignupActivity.this, FlowersActivity.class));

                    }
                    else if(intent.hasExtra("gardens"))
                    {
                        gardensText= intent.getStringExtra("gardens");
                        startActivity(new Intent(SignupActivity.this, VerticalGardenActivity.class));

                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Toast.makeText(this, "Good Bye !", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

}