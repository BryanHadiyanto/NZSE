package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class AngebotLoschen extends AppCompatActivity {
    ImageView imageView1;
    EditText etAdress1,etOrt1,etPlatz1,etPreis1,etKontakName1,etKontakNummer1;
    Button bloschen,bAndern,bzuruck;
    AngebotItem angebotItem = new AngebotItem();
    MaklerMenu maklerMenu = new MaklerMenu();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_loschen);
        imageView1= findViewById(R.id.imageView5);
        etAdress1= findViewById(R.id.editTextAdresse1);
        etOrt1= findViewById(R.id.editTextOrt1);
        etPlatz1= findViewById(R.id.editTextPlatz1);
        etPreis1= findViewById(R.id.editTextPreis1);
        etKontakName1= findViewById(R.id.editTextTextKontakName1);
        etKontakNummer1= findViewById(R.id.editTextKontaktPhone1);
        bloschen= findViewById(R.id.buttonLoschen);
        bAndern= findViewById(R.id.buttonAndern);
        bzuruck = findViewById(R.id.buttonzuruck);
        bzuruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imageView1.setImageResource(angebotItem.angebotlist.get(maklerMenu.count).getImage());
        etAdress1.setText(angebotItem.angebotlist.get(maklerMenu.count).getAdress());
        etOrt1.setText(angebotItem.angebotlist.get(maklerMenu.count).getOrt());
        etPlatz1.setText(angebotItem.angebotlist.get(maklerMenu.count).getPlatz());
        etPreis1.setText(angebotItem.angebotlist.get(maklerMenu.count).getPreis());
        etKontakName1.setText(angebotItem.angebotlist.get(maklerMenu.count).getKontaktname());
        etKontakNummer1.setText(angebotItem.angebotlist.get(maklerMenu.count).getKontaktnummer());

    }
}