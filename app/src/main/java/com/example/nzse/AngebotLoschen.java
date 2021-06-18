package com.example.nzse;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AngebotLoschen extends AppCompatDialogFragment {
    delete_dialogInterface delete_dialogInterface;
    ImageView imageView1;
    EditText etAdress,etOrt,etPlatz,etPreis,etKontakName,etKontakNummer;
    MaklerMenu maklerMenu;
    AngebotItem angebotItem;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_angebot_loschen,null);
        builder.setView(view)
                .setTitle("Delete Item")
                .setNegativeButton("Andern", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String addresse = etAdress.getText().toString();
                        String ort = etOrt.getText().toString();
                        String platz = etPlatz.getText().toString();
                        String preis = etPreis.getText().toString();
                        String kontakname = etKontakName.getText().toString();
                        String kontaknummer = etKontakNummer.getText().toString();
                        int pos = maklerMenu.count;
                        delete_dialogInterface.removeTexts(pos);
                        delete_dialogInterface.applyTexts(addresse,ort,platz,preis,kontakname,kontaknummer,pos);
                    }
                }).setPositiveButton("Loschen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                int pos= maklerMenu.count;
                delete_dialogInterface.removeTexts(pos);
            }
        });
        imageView1 = view.findViewById(R.id.imageView5);
        etAdress= view.findViewById(R.id.editTextAdresse1);
        etOrt= view.findViewById(R.id.editTextOrt1);
        etPlatz= view.findViewById(R.id.editTextPlatz1);
        etPreis= view.findViewById(R.id.editTextPreis1);
        etKontakName= view.findViewById(R.id.editTextTextKontakName1);
        etKontakNummer= view.findViewById(R.id.editTextKontaktPhone1);

//        tvID.setText(Integer.toString(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getId()));
        imageView1.setImageResource(angebotItem.angebotlist.get(maklerMenu.count).getImage());
        etAdress.setText(angebotItem.angebotlist.get(maklerMenu.count).getAdress());
        etOrt.setText(angebotItem.angebotlist.get(maklerMenu.count).getOrt());
        etPlatz.setText(Integer.toString(angebotItem.angebotlist.get(maklerMenu.count).getPlatz()));
        etPreis.setText(angebotItem.angebotlist.get(maklerMenu.count).getPreis());
        etKontakName.setText(angebotItem.angebotlist.get(maklerMenu.count).getKontaktname());
        etKontakNummer.setText(angebotItem.angebotlist.get(maklerMenu.count).getKontaktnummer());
        return builder.create();
    }
    @Override
    public void onAttach(@NonNull Context context){
        delete_dialogInterface = (delete_dialogInterface) context;
        super.onAttach(context);
    }


    public interface delete_dialogInterface {
        public void removeTexts(int pos);
        public void applyTexts( String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer,int position);
    }
}

