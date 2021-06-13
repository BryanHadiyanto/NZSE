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

public class Angebot_Hinzufugen extends AppCompatDialogFragment {
    insert_dialogInterface insert_dialogInterface;
    ImageView ivImage;
    EditText etAdress,etOrt,etPlatz,etPreis,etKontakName,etKontakNummer;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_angebot_hinzufugen,null);
        builder.setView(view)
                .setTitle("Insert Item")
                .setNegativeButton("Hinzufugen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
//                Integer image =  ivImage.getImageAlpha();
                String addresse = etAdress.getText().toString();
                String ort = etOrt.getText().toString();
                String platz = etPlatz.getText().toString();
                String preis = etPreis.getText().toString();
                String kontakname = etKontakName.getText().toString();
                String kontaknummer = etKontakNummer.getText().toString();
                int pos = 0;
                insert_dialogInterface.applyTexts(addresse,ort,platz,preis,kontakname,kontaknummer,0);
            }
        }).setPositiveButton("Abbrechen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        etAdress= view.findViewById(R.id.editTextAdresse);
        etOrt= view.findViewById(R.id.editTextOrt);
        etPlatz= view.findViewById(R.id.editTextPlatz);
        etPreis= view.findViewById(R.id.editTextPreis);
        etKontakName= view.findViewById(R.id.editTextTextKontakName);
        etKontakNummer= view.findViewById(R.id.editTextKontaktPhone);
        return builder.create();
    }
    @Override
    public void onAttach(@NonNull Context context){
        insert_dialogInterface = (insert_dialogInterface) context;
        super.onAttach(context);
    }

    public interface insert_dialogInterface{
        public void applyTexts( String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer,Integer position);
    }
}
