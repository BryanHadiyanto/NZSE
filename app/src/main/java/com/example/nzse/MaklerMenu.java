package com.example.nzse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
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

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaklerMenu extends AppCompatActivity implements AngebotHinzufugen.insert_dialogInterface, AngebotLoschen.delete_dialogInterface{
    private EditText etSearch1;
    private Button bsortAdr1,bsortPreis1;
    private TextView tvSwitch;
    private Toolbar toolbar1;
    private RecyclerView rvAngebot;
    private FloatingActionButton fabInsrt;
    AngebotAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    AngebotItem angebotItem = new AngebotItem();
    ArrayList<AngebotItem> angebotItemArrayList = angebotItem.getAngebotlist();
    public static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makler_menu);
//        angebotItem.Example();
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
                count = position;
                AngebotLoschen dialog = new AngebotLoschen();
                dialog.show(getSupportFragmentManager(), "Delete Item");
            }
        });
        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        etSearch1= findViewById(R.id.editTextSearch2);
        etSearch1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
        tvSwitch= findViewById(R.id.textViewSwitch2);
        tvSwitch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openKundenMenu();
              }});
        bsortAdr1 = findViewById(R.id.buttonSortAdr1);
        bsortAdr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortArrayListAdresse();
            }
        });
        bsortPreis1 = findViewById(R.id.buttonSortpreis1);
        bsortPreis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortArrayListPreis();
            }
        });
        fabInsrt = findViewById(R.id.floatingActionButtonInsert);
        fabInsrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AngebotHinzufugen dialog = new AngebotHinzufugen();
                dialog.show(getSupportFragmentManager(), "Insert Item");
            }
        });
    }
    public void openKundenMenu() {
        Intent intent = new Intent(this, KundenMenu.class);
        startActivity(intent);
//        finish();
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
            case R.id.icongebuchtlistMakler: {
                Intent intent = new Intent(this, gebuchteListeMakler.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void applyTexts(Bitmap image, String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer, int position) {
        angebotItemArrayList.add(position,new AngebotItem(image,addresse,ort,platz,preis,kontakname,kontaknummer));
        adapter.notifyItemInserted(position);
    }

    @Override
    public void removeTexts(int position) {
        angebotItemArrayList.remove(position);
        adapter.notifyItemRemoved(position);
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