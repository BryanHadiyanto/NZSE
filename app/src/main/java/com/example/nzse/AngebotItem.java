package com.example.nzse;

import android.os.Parcelable;

import java.util.ArrayList;

public class AngebotItem {
    int image;
    private String nummer,große,kontaktname,kontaktnummer,etage,preis;
    //private  int etage,preis;
    public static ArrayList<AngebotItem> angebotlist = new ArrayList<>();
    AngebotItem(){
        angebotlist.add(new AngebotItem(R.drawable.sample1,"A01","1","10x10","200","Test","1234"));
        angebotlist.add(new AngebotItem(R.drawable.sample2,"A02","1","8x8","150","Test","1234"));
        angebotlist.add(new AngebotItem(R.drawable.sample3,"A03","1","4x4","100","Test","1234"));
    }
    AngebotItem(int image,String nummer, String etage, String große, String preis, String kontaktname, String kontaknummer){
        this.image = image;
        this.nummer = nummer;
        this.etage = etage;
        this.große = große;
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }
    public int getImage(){ return image; }
    public String getNummer(){
        return nummer;
    }
    public String getGroße(){
        return große;
    }
    public String getKontaktname(){
        return kontaktname;
    }
    public String getKontaktnummer(){
        return kontaktnummer;
    }
    public String getEtage(){
        return etage;
    }
    public String getPreis(){
        return preis;
    }
}
