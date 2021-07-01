package com.example.nzse;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.ActivityCompat;

import java.io.IOException;

public class AngebotLoschen extends AppCompatDialogFragment {
    delete_dialogInterface delete_dialogInterface;
    ImageView imageView1;
    EditText etAdress,etOrt,etPlatz,etPreis,etKontakName,etKontakNummer;
    MaklerMenu maklerMenu;
    AngebotItem angebotItem;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    Bitmap bitmap;

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
                        Bitmap image = bitmap;
                        String addresse = etAdress.getText().toString();
                        String ort = etOrt.getText().toString();
                        String platz = etPlatz.getText().toString();
                        String preis = etPreis.getText().toString();
                        String kontakname = etKontakName.getText().toString();
                        String kontaknummer = etKontakNummer.getText().toString();
                        int pos = maklerMenu.count;
                        delete_dialogInterface.removeTexts(pos);
                        delete_dialogInterface.applyTexts(image,addresse,ort,platz,preis,kontakname,kontaknummer,pos);
                    }
                }).setPositiveButton("Loschen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                int pos= maklerMenu.count;
                delete_dialogInterface.removeTexts(pos);
            }
        });
        imageView1= view.findViewById(R.id.imageView5);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else{
                        pickImageFromGallery();
                    }
                }
                else{
                    pickImageFromGallery();
                }
            }
        });
        etAdress= view.findViewById(R.id.editTextAdresse1);
        etOrt= view.findViewById(R.id.editTextOrt1);
        etPlatz= view.findViewById(R.id.editTextPlatz1);
        etPreis= view.findViewById(R.id.editTextPreis1);
        etKontakName= view.findViewById(R.id.editTextTextKontakName1);
        etKontakNummer= view.findViewById(R.id.editTextKontaktPhone1);

//        tvID.setText(Integer.toString(kundenMenu.angebotItemArrayList.get(kundenMenu.count).getId()));
        imageView1.setImageBitmap(angebotItem.angebotlist.get(maklerMenu.count).getBitimage());
        etAdress.setText(angebotItem.angebotlist.get(maklerMenu.count).getAdress());
        etOrt.setText(angebotItem.angebotlist.get(maklerMenu.count).getOrt());
        etPlatz.setText(Integer.toString(angebotItem.angebotlist.get(maklerMenu.count).getPlatz()));
        etPreis.setText(angebotItem.angebotlist.get(maklerMenu.count).getPreis());
        etKontakName.setText(angebotItem.angebotlist.get(maklerMenu.count).getKontaktname());
        etKontakNummer.setText(angebotItem.angebotlist.get(maklerMenu.count).getKontaktnummer());
        return builder.create();
    }

    private void pickImageFromGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK) {
            try {
                Uri returnUri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                imageView1.setImageBitmap(bitmap);
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }
    @Override
    public void onAttach(@NonNull Context context){
        delete_dialogInterface = (delete_dialogInterface) context;
        super.onAttach(context);
    }


    public interface delete_dialogInterface {
        public void removeTexts(int pos);
        public void applyTexts(Bitmap image,String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer, int position);
    }
}

