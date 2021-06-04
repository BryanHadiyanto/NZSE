package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AngebotBuchen extends AppCompatActivity {
    TextView tvAdress,tvOrt,tvPlatz,tvPreis,tvKontakname,tvKontaknummer;
    String sNum,sEt,sGr,sPr,sKontnam,sKontnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_buchen);
        tvAdress = findViewById(R.id.TextViewAdress);
        tvOrt = findViewById(R.id.TextViewOrt);
        tvPlatz = findViewById(R.id.TextViewtPlatz);
        tvPreis = findViewById(R.id.TextViewPreis);
        tvKontakname = findViewById(R.id.TextViewKontakName);
        tvKontaknummer = findViewById(R.id.TextViewKontaktPhone);
        sNum = "null";
        sEt = "null";
        sGr = "null";
        sPr= "null";
        sKontnam= "null";
        sKontnum = "null";

        Bundle extra = getIntent().getExtras();
        if(extra !=null){
            sNum = extra.getString("get");
//            sEt = extra.getString("get1");
//            sGr = extra.getString("get2");
//            sPr= extra.getString("get3");
//            sKontnam= extra.getString("get4");
//            sKontnum = extra.getString("get5");
        }
        tvAdress.setText(sNum);
//        tvEtage.setText(sEt);
//        tvGroße.setText(sGr);
//        tvPreis.setText(sPr);
//        tvKontakname.setText(sKontnam);
//        tvKontaknummer.setText(sKontnum);

    }
}