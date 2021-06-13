package com.example.nzse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import java.io.Serializable;
import java.util.ArrayList;

public class MaklerMenu<go> extends AppCompatActivity implements AngebotHinzufugen.insert_dialogInterface{
    private EditText etSearch;
    private TextView tvSwitch;
    private Toolbar toolbar1;
    private RecyclerView rvAngebot;
    private AngebotAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    AngebotItem angebotItem = new AngebotItem();
    ArrayList<AngebotItem> angebotItemArrayList = angebotItem.angebotlist;

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makler_menu);
        angebotItem.Example();
        //recycelerview
        rvAngebot= findViewById(R.id.rvAngebotlist2);
        rvAngebot.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new AngebotAdapter(angebotItemArrayList);
        rvAngebot.setLayoutManager(layoutManager);
        rvAngebot.setAdapter(adapter);
        adapter.setonClickListener(new AngebotAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getApplicationContext(), AngebotLoschen.class);
                count = position;
                startActivity(intent);
            }
        });

        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        etSearch= findViewById(R.id.editTextSearch2);
        tvSwitch= findViewById(R.id.textViewSwitch2);
        tvSwitch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openKundenMenu();
              }});
    }
    public void openKundenMenu() {
        Intent intent = new Intent(this, KundenMenu.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu_makler,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.iconInsert: {
                AngebotHinzufugen dialog = new AngebotHinzufugen();
                dialog.show(getSupportFragmentManager(), "Insert Item");
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void applyTexts(String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer, Integer position) {
        angebotItemArrayList.add(position,new AngebotItem(R.drawable.sample1,addresse,ort,platz,preis,kontakname,kontaknummer));
        adapter.notifyItemInserted(position);
    }
}