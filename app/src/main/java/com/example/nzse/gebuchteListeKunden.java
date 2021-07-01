package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class gebuchteListeKunden extends AppCompatActivity implements Angebotabsagen.absagen_dialogInterface {
    private RecyclerView rvAngebot1;
    private BookedAdapterKunden adapter1;
    private RecyclerView.LayoutManager layoutManager1;
    BookedItem bookedItem = new BookedItem();
    ArrayList<BookedItem> bookedItemArrayList = bookedItem.getBookedlist();
    public static int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebuchte_liste_kunden);
        //recyclerview
        rvAngebot1 = findViewById(R.id.rvAngebotlist1);
        rvAngebot1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this);
        adapter1 = new BookedAdapterKunden(bookedItemArrayList);
        rvAngebot1.setLayoutManager(layoutManager1);
        rvAngebot1.setAdapter(adapter1);
        adapter1.setonClickListener(new BookedAdapterKunden.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            System.out.println("count: " + position);
            count = position;
            System.out.println("count1: " + position);
            Angebotabsagen dialog = new Angebotabsagen();
            dialog.show(getSupportFragmentManager(), "Cancel Booking");
            }

            @Override
            public void onDeleteClick(int position) {
                bookedItemArrayList.remove(position);
                adapter1.notifyItemRemoved(position);
            }
        });

    }

    @Override
    public void removeTexts(int pos) {
        bookedItemArrayList.remove(pos);
    }
}