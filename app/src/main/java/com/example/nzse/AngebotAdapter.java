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
    private OnItemClickListener listener;

    public interface  OnItemClickListener{
        void onItemClick(int position);
    }

    public void setonClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class AngebotHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView text1;
        public TextView text2;
        public TextView text3;
        public TextView text4;
        
        public AngebotHolder(View itemView,final OnItemClickListener listener) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            text1 = itemView.findViewById(R.id.tvAdresse);
            text2 = itemView.findViewById(R.id.tvOrt);
            text3 = itemView.findViewById(R.id.tvPreis);
            text4 = itemView.findViewById(R.id.tvPlatz);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public AngebotAdapter(ArrayList<AngebotItem>angebotlist){
        this.angebotlist = angebotlist;
    }
    @Override
    public AngebotHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.angebot_item, parent,false);
        AngebotHolder angebotHolder = new AngebotHolder(view, listener);
        return angebotHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AngebotHolder holder, int position) {
        AngebotItem currentItem = angebotlist.get(position);

        holder.image.setImageResource(currentItem.getImage());
        holder.text1.setText(currentItem.getAdress());
        holder.text2.setText(currentItem.getOrt());
        holder.text3.setText(currentItem.getPreis());
//        holder.text4.setText(currentItem.getPlatz());
    }

    @Override
    public int getItemCount() {
        return angebotlist.size();
    }

    public void filterList(ArrayList<AngebotItem>filteredList){
        angebotlist = filteredList;
        notifyDataSetChanged();
    }
}
