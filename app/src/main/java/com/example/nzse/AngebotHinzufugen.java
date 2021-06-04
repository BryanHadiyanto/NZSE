package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AngebotHinzufugen extends AppCompatActivity {
    EditText etAdress,etOrt,etPlatz,etPreis,etKontakName,etKontakNummer;
    Button bhinzufugen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_hinzufugen);
        etAdress= findViewById(R.id.editTextAdresse);
        etOrt= findViewById(R.id.editTextOrt);
        etPlatz= findViewById(R.id.editTextPlatz);
        etPreis= findViewById(R.id.editTextPreis);
        etKontakName= findViewById(R.id.editTextTextKontakName);
        etKontakNummer= findViewById(R.id.editTextKontaktPhone);
        bhinzufugen= findViewById(R.id.buttonHinzufugen);

        bhinzufugen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert into array
                finish();
            }
        });
    }
}