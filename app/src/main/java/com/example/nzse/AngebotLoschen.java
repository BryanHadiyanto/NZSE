package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AngebotLoschen extends AppCompatActivity {
    EditText etNummer1,etEtage1,etGroße1,etPreis1,etKontakName1,etKontakNummer1;
    Button bloschen,bAndern;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_loschen);
        etNummer1= findViewById(R.id.editTextNumber1);
        etEtage1= findViewById(R.id.editTextFloor1);
        etGroße1= findViewById(R.id.editTextSize1);
        etPreis1= findViewById(R.id.editTextPreis1);
        etKontakName1= findViewById(R.id.editTextTextKontakName1);
        etKontakNummer1= findViewById(R.id.editTextKontaktPhone1);
        bloschen= findViewById(R.id.buttonLoschen);
        bAndern= findViewById(R.id.buttonAndern);
    }
}