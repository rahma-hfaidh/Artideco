package com.example.artideco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView tv_signup;
    TextView tv_valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setContentView(R.layout.activity_login);

        tv_signup=(TextView) findViewById(R.id.tv_signup);
        tv_valider=(TextView) findViewById(R.id.tv_valider);






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
                        startActivity(new Intent(LoginActivity.this, PlantsActivity.class));

                    }
                    else if(intent.hasExtra("flowers"))
                    {
                        flowersText= intent.getStringExtra("flowers");
                        startActivity(new Intent(LoginActivity.this, FlowersActivity.class));

                    }
                    else if(intent.hasExtra("gardens"))
                    {
                        gardensText= intent.getStringExtra("gardens");
                        startActivity(new Intent(LoginActivity.this, VerticalGardenActivity.class));

                    }
                }
            }
        });





        tv_signup.setOnClickListener(new View.OnClickListener() {
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
                        Intent i= new Intent(LoginActivity.this, SignupActivity.class);
                        i.putExtra("plants",plantsText);
                        startActivity(i);

                    }
                    else if(intent.hasExtra("flowers"))
                    {
                        flowersText= intent.getStringExtra("flowers");
                        Intent i= new Intent(LoginActivity.this, SignupActivity.class);
                        i.putExtra("flowers",flowersText);
                        startActivity(i);

                    }
                    else if(intent.hasExtra("gardens"))
                    {
                        gardensText= intent.getStringExtra("gardens");
                        Intent i= new Intent(LoginActivity.this, SignupActivity.class);
                        i.putExtra("gardens",gardensText);
                        startActivity(i);

                    }
                }

            }
        });
    }
}