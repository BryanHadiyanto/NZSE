package com.example.nzse;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KundenMenu extends AppCompatActivity {

    private EditText etSearch;
    private RecyclerView rvAngebot;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private AngebotAdapter.RecyclerViewClickListener listener;
    private TextView tvSwitch;
    Toolbar toolbar;

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
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaklerMenu();
            }
        });
    }

    public void openMaklerMenu() {
        Intent intent = new Intent(this, MaklerMenu.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu_kunden,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.icongebuchtlist: {
                Intent intent = new Intent(this,gebuchteListe.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}