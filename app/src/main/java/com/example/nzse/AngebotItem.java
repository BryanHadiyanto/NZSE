package com.example.nzse;

import android.os.Parcelable;

import java.util.ArrayList;

public class AngebotItem {
    private String nummer,große,kontaktname,kontaktnummer,etage,preis;
    //private  int etage,preis;
    public static ArrayList<AngebotItem> angebotlist = new ArrayList<>();
    AngebotItem(){
        angebotlist.add(new AngebotItem("Nummer","\0","Große","Preis","\0","\0"));
        angebotlist.add(new AngebotItem("A01","1","10x10","200","Test","1234"));
        angebotlist.add(new AngebotItem("A02","1","8x8","150","Test","1234"));
        angebotlist.add(new AngebotItem("A03","1","4x4","100","Test","1234"));
    }
    AngebotItem(String nummer, String etage, String große, String preis, String kontaktname, String kontaknummer){
        this.nummer = nummer;
        this.etage = etage;
        this.große = große;
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }
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
