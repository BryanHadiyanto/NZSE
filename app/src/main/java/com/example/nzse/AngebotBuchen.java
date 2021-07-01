package com.example.nzse;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.io.ByteArrayOutputStream;

public class AngebotBuchen extends AppCompatDialogFragment {
    buchen_dialogInterface buchen_dialogInterface;

    ImageView imageView;
    EditText etAdress,etOrt,etPlatz,etPreis,etKontakname,etKontaknummer, tvID;
//    Button button;
    KundenMenu kundenMenu;
    AngebotItem angebotItem;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_angebot_buchen, null);
        builder.setView(view)
                .setTitle("Booking")
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                }).setPositiveButton("Buchen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Bitmap image = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                String addresse = etAdress.getText().toString();
                String ort = etOrt.getText().toString();
                String platz = etPlatz.getText().toString();
                String preis = etPreis.getText().toString();
                String kontakname = etKontakname.getText().toString();
                String kontaknummer = etKontaknummer.getText().toString();
                buchen_dialogInterface.applyTexts(image,addresse, ort, platz, preis, kontakname, kontaknummer, 0);
            }
        });

        imageView = view.findViewById(R.id.imageView3);
        etAdress = view.findViewById(R.id.EditTextAdress);
        etOrt = view.findViewById(R.id.EditTextOrt);
        etPlatz = view.findViewById(R.id.EditTextPlatz);
        etPreis = view.findViewById(R.id.EditTextPreis);
        etKontakname = view.findViewById(R.id.EditTextKontakName);
        etKontaknummer = view.findViewById(R.id.EditTextKontaktPhone);
        tvID = view.findViewById(R.id.EditTextID);

//        tvID.setText(Integer.toString(angebotItem.angebotlist.get(kundenMenu.count).getId()));
        imageView.setImageBitmap(angebotItem.angebotlist.get(kundenMenu.count).getBitimage());
        etAdress.setText(angebotItem.angebotlist.get(kundenMenu.count).getAdress());
        etOrt.setText(angebotItem.angebotlist.get(kundenMenu.count).getOrt());
        etPlatz.setText(Integer.toString(angebotItem.angebotlist.get(kundenMenu.count).getPlatz()));
        etPreis.setText(angebotItem.angebotlist.get(kundenMenu.count).getPreis());
        etKontakname.setText(angebotItem.angebotlist.get(kundenMenu.count).getKontaktname());
        etKontaknummer.setText(angebotItem.angebotlist.get(kundenMenu.count).getKontaktnummer());

        //tvID.setEnabled(false);
        etAdress.setEnabled(false);
        etOrt.setEnabled(false);
        etPlatz.setEnabled(false);
        etPreis.setEnabled(false);
        etKontakname.setEnabled(false);
        etKontaknummer.setEnabled(false);

/*        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int id = Integer.parseInt(tvID.getText().toString());
                    for(int i = 0; i < kundenMenu.angebotItemArrayList.size(); i++){
                        if(id == kundenMenu.angebotItemArrayList.get(i).getId()){
                            Log.i("Anzahl before", kundenMenu.angebotItemArrayList.get(i).getPlatz()+"");
                            if(kundenMenu.angebotItemArrayList.get(i).getPlatz() == 0){
                                Toast toast = Toast.makeText(getApplicationContext(), "Error !", Toast.LENGTH_LONG);
                                toast.show();
                                break;
                            }
                            kundenMenu.angebotItemArrayList.get(i).setPlatz();
                            Log.i("Anzahl after", kundenMenu.angebotItemArrayList.get(i).getPlatz()+"");
                            Toast toast = Toast.makeText(getApplicationContext(), "Succees !", Toast.LENGTH_LONG);
                            toast.show();
                            break;
                        }
                    }
            }
        });*/
        return builder.create();
    }
    @Override
    public void onAttach(@NonNull Context context){
        buchen_dialogInterface = (buchen_dialogInterface) context;
        super.onAttach(context);
    }
    public interface buchen_dialogInterface {
        public void applyTexts(Bitmap image, String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer, int position);
    }
}