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
    private AngebotAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView tvSwitch;
    private Toolbar toolbar;
    int count = 0;
    ArrayList<AngebotItem> angebotItemArrayList = AngebotItem.angebotlist;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunden_menu);
        //recyclerview
        rvAngebot = findViewById(R.id.rvAngebotlist);
        //recyclerview Clicked
        rvAngebot.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new AngebotAdapter(angebotItemArrayList);
        rvAngebot.setLayoutManager(layoutManager);
        rvAngebot.setAdapter(adapter);
        adapter.setonClickListener(new AngebotAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(),AngebotBuchen.class);
                count = position;
                startActivity(intent);
            }
        });

        etSearch = findViewById(R.id.editTextSearch);
        tvSwitch = findViewById(R.id.textViewSwitch);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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