package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AngebotLoschen extends AppCompatActivity {
    EditText etAdress1,etOrt1,etPlatz1,etPreis1,etKontakName1,etKontakNummer1;
    Button bloschen,bAndern;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_loschen);
        etAdress1= findViewById(R.id.editTextAdresse1);
        etOrt1= findViewById(R.id.editTextOrt1);
        etPlatz1= findViewById(R.id.editTextPlatz1);
        etPreis1= findViewById(R.id.editTextPreis1);
        etKontakName1= findViewById(R.id.editTextTextKontakName1);
        etKontakNummer1= findViewById(R.id.editTextKontaktPhone1);
        bloschen= findViewById(R.id.buttonLoschen);
        bAndern= findViewById(R.id.buttonAndern);
    }
}