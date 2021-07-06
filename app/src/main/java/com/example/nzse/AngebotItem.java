package com.example.nzse;

import android.graphics.Bitmap;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class AngebotItem{
    private Bitmap bitimage;
    private int anzahlplaetze;
    private String ort,adress,kontaktname,kontaktnummer,preis;
    private int id;
    static int x = 0;
    public static ArrayList<AngebotItem> angebotlist = new ArrayList<>();

    AngebotItem(){ }

    AngebotItem(Bitmap bitimage, String adress, String ort, String anzahlplaetze, String preis, String kontaktname, String kontaknummer){
        this.x++;
        id = x;
        this.bitimage = bitimage;
        this.adress = adress;
        this.ort = ort;
        this.anzahlplaetze = Integer.parseInt(anzahlplaetze);
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }
    //Ohne Image
    AngebotItem(String adress, String ort, String anzahlplaetze, String preis, String kontaktname, String kontaknummer){
        this.x++;
        id = x;
        this.adress = adress;
        this.ort = ort;
        this.anzahlplaetze = Integer.parseInt(anzahlplaetze);
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }

    public void setPlatz() {
        if(anzahlplaetze != 0)
            this.anzahlplaetze--;
    }
    public int getPlatz() {
        return anzahlplaetze;
    }

    public void setBitimage(Bitmap newBitimage) {
        this.bitimage = newBitimage;
    }
    public Bitmap getBitimage() {
        return bitimage;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    public String getOrt() {
        return ort;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getAdress() {
        return adress;
    }

    public void setKontaktname(String kontaktname) {
        this.kontaktname = kontaktname;
    }
    public String getKontaktname() {
        return kontaktname;
    }

    public void setKontaktnummer(String kontaktnummer) {
        this.kontaktnummer = kontaktnummer;
    }
    public String getKontaktnummer() {
        return kontaktnummer;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }
    public String getPreis() {
        return preis;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setAngebotlist(ArrayList<AngebotItem> angebotlist) {
        this.angebotlist = angebotlist;
    }
    public ArrayList<AngebotItem> getAngebotlist() {
        return angebotlist;
    }
}
