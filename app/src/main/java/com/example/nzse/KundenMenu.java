package com.example.nzse;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KundenMenu extends AppCompatActivity implements AngebotBuchen.buchen_dialogInterface{
    private EditText etSearch;
    private RecyclerView rvAngebot;
    AngebotAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView tvSwitch;
    private Button bsortAdr, bsortPreis;
    private Toolbar toolbar;
    public static int count;
    AngebotItem angebotItem = new AngebotItem();
    ArrayList<AngebotItem> angebotItemArrayList = angebotItem.angebotlist;
    BookedItem bookedItem = new BookedItem();
    ArrayList<BookedItem> bookedItemArrayList = bookedItem.bookedlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunden_menu);
        //angebotItem.Example();
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
                count = position;
                AngebotBuchen dialog = new AngebotBuchen();
                dialog.show(getSupportFragmentManager(), "Booking");
            }
        });

        etSearch = findViewById(R.id.editTextSearch);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
        tvSwitch = findViewById(R.id.textViewSwitch);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMakler();
            }
        });
        bsortAdr = findViewById(R.id.buttonSortAdr);
        bsortAdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortArrayListAdresse();
            }
        });
        bsortPreis = findViewById(R.id.buttonSortpreis);
        bsortPreis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortArrayListPreis();
            }
        });
    }
    public void openMakler() {
//        Intent intent = new Intent(this, MaklerMenu.class);
//        startActivity(intent);
        finish();
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
            case R.id.icongebuchtlistKunden: {
                Intent intent = new Intent(this, gebuchteListeKunden.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void applyTexts(String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer, int position) {
        bookedItemArrayList.add(position,new BookedItem(R.drawable.sample1,addresse,ort,platz,preis,kontakname,kontaknummer));
    }

    private void filter(String text){
        ArrayList<AngebotItem> filteredList = new ArrayList<>();
        for(AngebotItem item : angebotItemArrayList){
            if(item.getOrt().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
    private void sortArrayListAdresse(){
        Collections.sort(angebotItemArrayList, new Comparator<AngebotItem>() {
            @Override
            public int compare(AngebotItem item, AngebotItem t1) {
                return item.getAdress().compareTo(t1.getAdress());
            }
        });
        adapter.notifyDataSetChanged();
    }
    private void sortArrayListPreis(){
        Collections.sort(angebotItemArrayList, new Comparator<AngebotItem>() {
            @Override
            public int compare(AngebotItem item, AngebotItem t1) {
                return item.getPreis().compareTo(t1.getPreis());
            }
        });
        adapter.notifyDataSetChanged();
    }
}