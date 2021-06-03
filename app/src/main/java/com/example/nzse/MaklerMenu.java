package com.example.nzse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaklerMenu extends AppCompatActivity {
    EditText etSearch;
    TextView tvSwitch;
    Button bAdd;
    private RecyclerView rvAngebot;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private AngebotAdapter.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makler_menu);
        ArrayList<AngebotItem> angebotItemArrayList = AngebotItem.angebotlist;
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

        etSearch= findViewById(R.id.editTextSearch2);
        tvSwitch= findViewById(R.id.textViewSwitch2);
        bAdd = findViewById(R.id.buttonHinzufugen);

        tvSwitch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //zuruck zu main ohne nochmal onCreate();
                finish();
              }});
    }
/*    public void openKundenMenu(){
        Intent intent = new Intent(this,KundenMenu.class);
        startActivity(intent);
    }*/
}