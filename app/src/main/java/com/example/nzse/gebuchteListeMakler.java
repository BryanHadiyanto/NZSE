package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class gebuchteListeMakler extends AppCompatActivity {
    private RecyclerView rvAngebot;
    private BookedAdapterKunden adapter;
    private RecyclerView.LayoutManager layoutManager;
    BookedItem bookedItem = new BookedItem();
    ArrayList<BookedItem> bookedItemArrayList = bookedItem.getBookedlist();
    public static int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebuchte_liste_makler);
        //recyclerview
        rvAngebot = findViewById(R.id.rvAngebotlist2);
        rvAngebot.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new BookedAdapterKunden(bookedItemArrayList);
        rvAngebot.setLayoutManager(layoutManager);
        rvAngebot.setAdapter(adapter);
        adapter.setonClickListener(new BookedAdapterKunden.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                System.out.println("count: " + position);
                count = position;
                System.out.println("count1: " + position);
                Angebotabsagen dialog = new Angebotabsagen();
                dialog.show(getSupportFragmentManager(), "Booking Detail");
            }

            @Override
            public void onDeleteClick(int position) {
                bookedItemArrayList.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
    }
}