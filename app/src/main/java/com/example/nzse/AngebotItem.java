package com.example.nzse;

import android.graphics.Bitmap;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class AngebotItem{
    private Bitmap bitimage;
    private int image;
    private int anzahlplaetze;
    private String url,ort,adress,kontaktname,kontaktnummer,preis;
//    private String  anzahlplaetze;
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
//    AngebotItem(int image, String adress, String ort, String anzahlplaetze, String preis, String kontaktname, String kontaknummer){
//        this.x++;
//        id = x;
//        this.image = image;
//        this.adress = adress;
//        this.ort = ort;
//        this.anzahlplaetze = Integer.parseInt(anzahlplaetze);
//        this.preis = preis;
//        this.kontaktname = kontaktname;
//        this.kontaktnummer = kontaknummer;
//    }
//       public void Example(){
//          angebotlist.add(new AngebotItem(R.drawable.sample1,"Berliner-alle 1","Darmstadt","4","200","Test","1234"));
//          angebotlist.add(new AngebotItem(R.drawable.sample2,"Kasinostrasse 1","Darmstadt","64289","150","Test","1234"));
//          angebotlist.add(new AngebotItem(R.drawable.sample3,"Rhonring 1","Darmstadt","64289","100","Test","1234"));
//   }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPlatz() {
        return anzahlplaetze;
    }

    public void setPlatz() {
        if(anzahlplaetze != 0)
            this.anzahlplaetze--;
    }
    public void setBitimage(Bitmap newBitimage) {
        this.bitimage = newBitimage;
    }

    public Bitmap getBitimage() {
        return bitimage;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getKontaktname() {
        return kontaktname;
    }

    public void setKontaktname(String kontaktname) {
        this.kontaktname = kontaktname;
    }

    public String getKontaktnummer() {
        return kontaktnummer;
    }

    public void setKontaktnummer(String kontaktnummer) {
        this.kontaktnummer = kontaktnummer;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<AngebotItem> getAngebotlist() {
        return angebotlist;
    }

    public void setAngebotlist(ArrayList<AngebotItem> angebotlist) {
        AngebotItem.angebotlist = angebotlist;
    }
}
