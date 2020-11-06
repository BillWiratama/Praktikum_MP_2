package com.example.praktikummp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    private Button btnfragment1;
    private Button btnsharedp,btnRDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsharedp = findViewById(R.id.btn_sharedpreferences);
        btnRDB = findViewById(R.id.btn_roomdatabase);
        btnfragment1 = findViewById(R.id.btn_frag1);

        btnfragment1.setOnClickListener(v -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.maincontener, new Fragment1()).commit();
        });

        btnsharedp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intents = new Intent(MainActivity.this,Shared_Preferences.class);
                startActivity(intents);
            }
        });
        btnRDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenr = new Intent(MainActivity.this,Room_Database.class);
                startActivity(intenr);
            }
        });
    }


}





