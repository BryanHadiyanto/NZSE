package com.example.nzse;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class AngebotItem{
    private int image, anzahlplaetze;
    private String url,ort,adress,kontaktname,kontaktnummer,preis;
    private int id;
    static int x = 0;
    //private  int etage,preis;
    public static ArrayList<AngebotItem> angebotlist = new ArrayList<>();

    AngebotItem(){

    };

    AngebotItem(int image,String adress, String ort, String anzahlplaetze, String preis, String kontaktname, String kontaknummer){
        this.x++;
        id = x;
        this.image = image;
        this.adress = adress;
        this.ort = ort;
        this.anzahlplaetze = Integer.parseInt(anzahlplaetze);
        this.preis = preis;
        this.kontaktname = kontaktname;
        this.kontaktnummer = kontaknummer;
    }
       public void Example(){
          angebotlist.add(new AngebotItem(R.drawable.sample1,"Berliner-alle 1","Darmstadt","4","200","Test","1234"));
        //  angebotlist.add(new AngebotItem(R.drawable.sample2,"Kasinostrasse 1","Darmstadt","64289","150","Test","1234"));
      //    angebotlist.add(new AngebotItem(R.drawable.sample3,"Rhonring 1","Darmstadt","64289","100","Test","1234"));
   }
 /* /*    public void changeText1(String text){
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public static ArrayList<AngebotItem> getAngebotlist() {
        return angebotlist;
    }

    public static void setAngebotlist(ArrayList<AngebotItem> angebotlist) {
        AngebotItem.angebotlist = angebotlist;
    }
}
