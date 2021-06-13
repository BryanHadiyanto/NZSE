package com.example.nzse;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class AngebotItem{
    int image;
    private String url,ort,adress,kontaktname,kontaktnummer,platz,preis;
    //private  int etage,preis;
    public static ArrayList<AngebotItem> angebotlist = new ArrayList<>();
    AngebotItem(){};

    AngebotItem(int image,String adress, String ort, String platz, String preis, String kontaktname, String kontaknummer){
        this.image = image;
        this.adress = adress;
        this.ort = ort;
        this.platz = platz;
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }
    public void Example(){
        angebotlist.add(new AngebotItem(R.drawable.sample1,"Berliner-alle 1","Darmstadt","64283","200","Test","1234"));
        angebotlist.add(new AngebotItem(R.drawable.sample2,"Kasinostrasse 1","Darmstadt","64289","150","Test","1234"));
        angebotlist.add(new AngebotItem(R.drawable.sample3,"Rhonring 1","Darmstadt","64289","100","Test","1234"));
    }
/*    public void changeText1(String text){
        this.preis = text;
    }*/
/*    AngebotItem(String urlImage,String adress, String ort, String platz, String preis, String kontaktname, String kontaknummer){
        this.url = urlImage;
        this.adress = adress;
        this.ort = ort;
        this.platz = platz;
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }*/
    public int getImage(){ return image; }
//    public String getUrl(){ return url};
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
}
