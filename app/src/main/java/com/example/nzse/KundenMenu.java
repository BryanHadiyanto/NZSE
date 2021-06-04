package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class KundenMenu extends AppCompatActivity {
    private EditText etSearch;
    private RecyclerView rvAngebot;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private AngebotAdapter.RecyclerViewClickListener listener;
    private TextView tvSwitch;
    private Button bGebuchte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunden_menu);
        AngebotItem angebotItem = new AngebotItem();
        ArrayList<AngebotItem> angebotItemArrayList = angebotItem.angebotlist;
        //recyclerview
        rvAngebot = findViewById(R.id.rvAngebotlist);
        //recyclerview Clicked
        rvAngebot.setHasFixedSize(true);
        listener = new AngebotAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), AngebotBuchen.class);
                intent.putExtra("get", angebotItemArrayList.get(position).getAdress());
//                intent.putExtra("get1", angebotItemArrayList.get(position).getEtage());
//                intent.putExtra("get2", angebotItemArrayList.get(position).getGroße());
//                intent.putExtra("get3", angebotItemArrayList.get(position).getPreis());
//                intent.putExtra("get4", angebotItemArrayList.get(position).getKontaktname());
//                intent.putExtra("get5", angebotItemArrayList.get(position).getKontaktnummer());
                startActivity(intent);
            }
        };
        layoutManager = new LinearLayoutManager(this);
        adapter = new AngebotAdapter(angebotItemArrayList,listener);
        rvAngebot.setLayoutManager(layoutManager);
        rvAngebot.setAdapter(adapter);

        etSearch = findViewById(R.id.editTextSearch);
        tvSwitch = findViewById(R.id.textViewSwitch);
        bGebuchte = findViewById(R.id.buttonBooked);

        tvSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaklerMenu();
            }
        });
        bGebuchte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGebuchteListe();
            }
        });
    }

    public void openMaklerMenu() {
        Intent intent = new Intent(this, MaklerMenu.class);
        startActivity(intent);
    }

    public void openGebuchteListe() {
        Intent intent = new Intent(this, gebuchteListe.class);
        startActivity(intent);
    }
}