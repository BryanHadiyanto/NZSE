package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class gebuchteListeMakler extends AppCompatActivity {
    private RecyclerView rvAngebot;
    private BookedAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<BookedItem> bookedItemArrayList = BookedItem.bookedlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebuchte_liste_makler);
        //recyclerview
        rvAngebot = findViewById(R.id.rvAngebotlist2);
        rvAngebot.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new BookedAdapter(bookedItemArrayList);
        rvAngebot.setLayoutManager(layoutManager);
        rvAngebot.setAdapter(adapter);
    }
}