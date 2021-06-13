package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AngebotBuchen extends AppCompatActivity {
    ImageView imageView;
    TextView tvAdress,tvOrt,tvPlatz,tvPreis,tvKontakname,tvKontaknummer;
    String sNum,sEt,sGr,sPr,sKontnam,sKontnum;
    KundenMenu kundenMenu = new KundenMenu();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_buchen);
        imageView = findViewById(R.id.imageView3);
        tvAdress = findViewById(R.id.TextViewAdress);
        tvOrt = findViewById(R.id.TextViewOrt);
        tvPlatz = findViewById(R.id.TextViewtPlatz);
        tvPreis = findViewById(R.id.TextViewPreis);
        tvKontakname = findViewById(R.id.TextViewKontakName);
        tvKontaknummer = findViewById(R.id.TextViewKontaktPhone);

        imageView.setImageResource(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getImage());
        tvAdress.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getAdress());
        tvOrt.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getOrt());
        tvPlatz.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getPlatz());
        tvPreis.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getPreis());
        tvKontakname.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getKontaktname());
        tvKontaknummer.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getKontaktnummer());

        tvAdress.setEnabled(false);
        tvOrt.setEnabled(false);
        tvPlatz.setEnabled(false);
        tvPreis.setEnabled(false);
        tvKontakname.setEnabled(false);
        tvKontaknummer.setEnabled(false);
    }
}