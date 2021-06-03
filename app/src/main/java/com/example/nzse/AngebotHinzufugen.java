package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AngebotHinzufugen extends AppCompatActivity {
    EditText etNummer,etEtage,etGroße,etPreis,etKontakName,etKontakNummer;
    Button bhinzufugen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_hinzufugen);
        etNummer= findViewById(R.id.editTextNumber);
        etEtage= findViewById(R.id.editTextFloor);
        etGroße= findViewById(R.id.editTextSize);
        etPreis= findViewById(R.id.editTextPreis);
        etKontakName= findViewById(R.id.editTextTextKontakName);
        etKontakNummer= findViewById(R.id.editTextKontaktPhone);
        bhinzufugen= findViewById(R.id.buttonHinzufugen);
    }
}