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

public class KundenMenu extends AppCompatActivity implements AngebotBuchen.buchen_dialogInterface{
    private EditText etSearch;
    private RecyclerView rvAngebot;
    AngebotAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView tvSwitch;
    private Toolbar toolbar;
    public static int count;
//    ArrayList<AngebotItem> angebotItemArrayList = AngebotItem.angebotlist;
    AngebotItem angebotItem = new AngebotItem();
    ArrayList<AngebotItem> angebotItemArrayList = angebotItem.angebotlist;
    BookedItem bookedItem = new BookedItem();
    ArrayList<BookedItem> bookedItemArrayList = bookedItem.bookedlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunden_menu);
        //recyclerview
        rvAngebot = findViewById(R.id.rvAngebotlist);
        rvAngebot.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new AngebotAdapter(angebotItemArrayList);
        rvAngebot.setLayoutManager(layoutManager);
        rvAngebot.setAdapter(adapter);
        adapter.setonClickListener(new AngebotAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println("COUNT: "+ count +" POSITION: "+ position);
                count = position;
                System.out.println("COUNT: "+ count +" POSITION: "+ position);
                AngebotBuchen dialog = new AngebotBuchen();
                dialog.show(getSupportFragmentManager(), "Booking");
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

    @Override
    public void applyTexts(String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer, Integer position) {
        bookedItemArrayList.add(position,new BookedItem(R.drawable.sample1,addresse,ort,platz,preis,kontakname,kontaknummer));
//        adapter.notifyItemInserted(position);
    }
}