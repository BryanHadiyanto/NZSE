package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class gebuchteListe extends AppCompatActivity {
    private RecyclerView rvAngebot1;
    private BookedAdapter adapter1;
    private RecyclerView.LayoutManager layoutManager1;
    ArrayList<BookedItem> bookedItemArrayList = BookedItem.bookedlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebuchte_liste);
        //recyclerview
        rvAngebot1 = findViewById(R.id.rvAngebotlist1);
        rvAngebot1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this);
        adapter1 = new BookedAdapter(bookedItemArrayList);
        rvAngebot1.setLayoutManager(layoutManager1);
        rvAngebot1.setAdapter(adapter1);
        adapter1.setonClickListener(new BookedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onDeleteClick(int position) {
                bookedItemArrayList.remove(position);
                adapter1.notifyItemRemoved(position);
            }
        });

    }
}