package com.example.nzse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Angebotabsagen extends AppCompatDialogFragment {
    absagen_dialogInterface absagen_dialogInterface;
    ImageView imageView;
    EditText etAdress,etOrt,etPlatz,etPreis,etKontakname,etKontaknummer, tvID;

    gebuchteListeKunden gebuchtelisteKunden;
    BookedItem bookedItem;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_angebotabsagen, null);
        builder.setView(view)
                .setTitle("Cancel Booking")
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                }).setPositiveButton("Absagen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                int pos = gebuchtelisteKunden.count;
                absagen_dialogInterface.removeTexts(pos);
            }
        });

        imageView = view.findViewById(R.id.imageView2);
        etAdress = view.findViewById(R.id.EditTextAdresse1);
        etOrt = view.findViewById(R.id.EditTextOrt1);
        etPlatz = view.findViewById(R.id.EditTextPlatz1);
        etPreis = view.findViewById(R.id.EditTextPreis1);
        etKontakname = view.findViewById(R.id.EditTextKontakName1);
        etKontaknummer = view.findViewById(R.id.EditTextKontaktPhone1);

        //tvID = view.findViewById(R.id.EditTextID);
        //tvID.setText(Integer.toString(angebotItem.angebotlist.get(kundenMenu.count).getId()));
        imageView.setImageBitmap(bookedItem.bookedlist.get(gebuchtelisteKunden.count).getBitmap());
        etAdress.setText(bookedItem.bookedlist.get(gebuchtelisteKunden.count).getAdress());
        etOrt.setText(bookedItem.bookedlist.get(gebuchtelisteKunden.count).getOrt());
        etPlatz.setText(bookedItem.bookedlist.get(gebuchtelisteKunden.count).getPlatz());
        etPreis.setText(bookedItem.bookedlist.get(gebuchtelisteKunden.count).getPreis());
        etKontakname.setText(bookedItem.bookedlist.get(gebuchtelisteKunden.count).getKontaktname());
        etKontaknummer.setText(bookedItem.bookedlist.get(gebuchtelisteKunden.count).getKontaktnummer());

        //tvID.setEnabled(false);
        etAdress.setEnabled(false);
        etOrt.setEnabled(false);
        etPlatz.setEnabled(false);
        etPreis.setEnabled(false);
        etKontakname.setEnabled(false);
        etKontaknummer.setEnabled(false);

        return builder.create();
    }
    @Override
    public void onAttach(@NonNull Context context){
        absagen_dialogInterface = (absagen_dialogInterface) context;
        super.onAttach(context);
    }
    public interface absagen_dialogInterface {
        public void removeTexts(int pos);
    }
}