package com.example.nzse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookedAdapter extends RecyclerView.Adapter<BookedAdapter.BookedHolder> {
    private ArrayList<BookedItem> bookedlist;
    private BookedAdapter.OnItemClickListener listener;

    public interface  OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setonClickListener(BookedAdapter.OnItemClickListener listener){
        this.listener = listener;
    }

    public static class BookedHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView text1;
        public TextView text2;
        public TextView text3;
        public ImageView deleteImage;

        public BookedHolder(View itemView, final BookedAdapter.OnItemClickListener listener) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView1);
            text1 = itemView.findViewById(R.id.tvAdresse1);
            text2 = itemView.findViewById(R.id.tvOrt1);
            text3 = itemView.findViewById(R.id.tvPreis1);
            deleteImage = itemView.findViewById(R.id.image_delete);
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

            deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }
    public BookedAdapter(ArrayList<BookedItem>bookedlist){
        this.bookedlist = bookedlist;
    }
    @Override
    public BookedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booked_item, parent,false);
        BookedHolder bookedHolder = new BookedHolder(view, listener);
        return bookedHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookedHolder holder, int position) {
        BookedItem currentItem = bookedlist.get(position);

        holder.image.setImageResource(currentItem.getImage());
        holder.text1.setText(currentItem.getAdress());
        holder.text2.setText(currentItem.getOrt());
        holder.text3.setText(currentItem.getPreis());
    }

    @Override
    public int getItemCount() {
        return bookedlist.size();
    }
}
