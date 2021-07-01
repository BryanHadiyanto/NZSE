package com.example.nzse;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class BookedItem {
    private Bitmap bitmap;
    private String ort,adress,kontaktname,kontaktnummer,platz,preis;
    public static ArrayList<BookedItem> bookedlist = new ArrayList<>();
    BookedItem(){};

    BookedItem(Bitmap bitmap,String adress, String ort, String platz, String preis, String kontaktname, String kontaknummer){
        this.bitmap = bitmap;
        this.adress = adress;
        this.ort = ort;
        this.platz = platz;
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }
    public Bitmap getBitmap(){ return bitmap; }
    public String getAdress(){
        return adress;
    }
    public String getOrt(){
        return ort;
    }
    public String getKontaktname(){
        return kontaktname;
    }
    public String getKontaktnummer(){
        return kontaktnummer;
    }
    public String getPlatz(){
        return platz;
    }
    public String getPreis(){
        return preis;
    }
    public void setAngebotlist(ArrayList<BookedItem> bookedlist) {
        this.bookedlist = bookedlist;
    }
    public ArrayList<BookedItem> getBookedlist() {
        return bookedlist;
    }
}
