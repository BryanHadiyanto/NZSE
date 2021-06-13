package com.example.nzse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import java.io.Serializable;
import java.util.ArrayList;

public class MaklerMenu extends AppCompatActivity implements Angebot_Hinzufugen.insert_dialogInterface{
    EditText etSearch;
    TextView tvSwitch;
    Toolbar toolbar1;
    RecyclerView rvAngebot;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    AngebotAdapter.RecyclerViewClickListener listener;
    ArrayList<AngebotItem> angebotItemArrayList = AngebotItem.angebotlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makler_menu);

        //recycelerview
        rvAngebot= findViewById(R.id.rvAngebotlist2);
        rvAngebot.setHasFixedSize(true);
        listener = new AngebotAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), AngebotLoschen.class);
                intent.putExtra("angebot", (Serializable) angebotItemArrayList.get(position));
                startActivity(intent);
            }
        };
        layoutManager = new LinearLayoutManager(this);
        adapter = new AngebotAdapter(angebotItemArrayList,listener);
        rvAngebot.setLayoutManager(layoutManager);
        rvAngebot.setAdapter(adapter);

        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        etSearch= findViewById(R.id.editTextSearch2);
        tvSwitch= findViewById(R.id.textViewSwitch2);
        tvSwitch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //zuruck zu main ohne nochmal onCreate();
                finish();
              }});
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
                Angebot_Hinzufugen dialog = new Angebot_Hinzufugen();
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