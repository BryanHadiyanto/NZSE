package com.example.nzse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AngebotAdapter extends RecyclerView.Adapter<AngebotAdapter.AngebotHolder>{
    private ArrayList<AngebotItem> angebotlist;
    private RecyclerViewClickListener listener;

    public static class AngebotHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image;
        public TextView text1;
        public TextView text2;
        public TextView text3;
        
        public AngebotHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            text1 = itemView.findViewById(R.id.tvAdresse);
            text2 = itemView.findViewById(R.id.tvOrt);
            text3 = itemView.findViewById(R.id.tvPreis);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
    public AngebotAdapter(ArrayList<AngebotItem>angebotlist,RecyclerViewClickListener listener){
        this.angebotlist = angebotlist;
        this.listener = listener;
    }
    @Override
    public AngebotHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.angebot_item, parent,false);
        AngebotHolder angebotHolder = new AngebotHolder(view);
        return angebotHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AngebotHolder holder, int position) {
        AngebotItem currentItem = angebotlist.get(position);

        holder.image.setImageResource(currentItem.getImage());
        holder.text1.setText(currentItem.getAdress());
        holder.text2.setText(currentItem.getOrt());
        holder.text3.setText(currentItem.getPreis());
    }

    @Override
    public int getItemCount() {
        return angebotlist.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View view,int position);
    }
}
