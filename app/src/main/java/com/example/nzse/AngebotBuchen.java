package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AngebotBuchen extends AppCompatActivity {
    ImageView imageView;
    TextView tvAdress,tvOrt,tvPlatz,tvPreis,tvKontakname,tvKontaknummer, tvID;
    String sNum,sEt,sGr,sPr,sKontnam,sKontnum;
    Button button;
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
        tvID = findViewById(R.id.IDTextView);
        button = findViewById(R.id.buttonBuchen);

        tvID.setText(Integer.toString(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getId()));
        imageView.setImageResource(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getImage());
        tvAdress.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getAdress());
        tvOrt.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getOrt());
        tvPlatz.setText(Integer.toString(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getPlatz()));
        tvPreis.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getPreis());
        tvKontakname.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getKontaktname());
        tvKontaknummer.setText(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getKontaktnummer());

        tvID.setEnabled(false);
        tvAdress.setEnabled(false);
        tvOrt.setEnabled(false);
        tvPlatz.setEnabled(false);
        tvPreis.setEnabled(false);
        tvKontakname.setEnabled(false);
        tvKontaknummer.setEnabled(false);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int id = Integer.parseInt(tvID.getText().toString());
                    for(int i = 0; i < kundenMenu.angebotItemArrayList.size(); i++){
                        if(id == kundenMenu.angebotItemArrayList.get(i).getId()){
                            Log.i("Anzahl before", kundenMenu.angebotItemArrayList.get(i).getPlatz()+"");
                            if(kundenMenu.angebotItemArrayList.get(i).getPlatz() == 0){
                                Toast toast = Toast.makeText(getApplicationContext(), "Error !", Toast.LENGTH_LONG);
                                toast.show();
                                break;
                            }
                            kundenMenu.angebotItemArrayList.get(i).setPlatz();
                            Log.i("Anzahl after", kundenMenu.angebotItemArrayList.get(i).getPlatz()+"");
                            Toast toast = Toast.makeText(getApplicationContext(), "Succees !", Toast.LENGTH_LONG);
                            toast.show();
                            break;
                        }
                    }
            }
        });
    }


}