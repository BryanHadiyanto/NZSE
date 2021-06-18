package com.example.nzse;

import java.util.ArrayList;

public class BookedItem {
    int image;
    private String url,ort,adress,kontaktname,kontaktnummer,platz,preis;
    //private  int etage,preis;
    public static ArrayList<BookedItem> bookedlist = new ArrayList<>();
    BookedItem(){};

    BookedItem(int image,String adress, String ort, String platz, String preis, String kontaktname, String kontaknummer){
        this.image = image;
        this.adress = adress;
        this.ort = ort;
        this.platz = platz;
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }
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
