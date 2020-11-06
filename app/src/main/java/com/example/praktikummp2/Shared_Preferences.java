package com.example.praktikummp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Shared_Preferences extends AppCompatActivity {
    EditText editText_name,editText_email;
    Button button_save;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared__preferences);

        editText_name = findViewById(R.id.eName);
        editText_email = findViewById(R.id.eEmail);
        button_save =findViewById(R.id.button_save);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);

        if (name != null) {
            Intent intent = new Intent(Shared_Preferences.this, Home_SharedP.class);
            startActivity(intent);
        }

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,editText_name.getText().toString());
                editor.putString(KEY_EMAIL,editText_email.getText().toString());
                editor.apply();

                Intent intent = new Intent(Shared_Preferences.this,Home_SharedP.class);
                startActivity(intent);

                Toast.makeText(Shared_Preferences.this,"Data Telah Tersimpan",Toast.LENGTH_SHORT).show();

            }
        });
    }
}