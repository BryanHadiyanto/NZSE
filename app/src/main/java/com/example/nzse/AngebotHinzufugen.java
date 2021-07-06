package com.example.nzse;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class AngebotHinzufugen extends AppCompatDialogFragment{
    insert_dialogInterface insert_dialogInterface;

    ImageView ivAngebot;
    EditText etAdress,etOrt,etPlatz,etPreis,etKontakName,etKontakNummer;
    private Button mButtonBildeinfuegen;
  /*  private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    Bitmap bitmap;*/
    private Bitmap imageUri = null;
    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    private static final int PICK_IMAGE = 100;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_angebot_hinzufugen,null);
        builder.setView(view)
                .setTitle("Insert Item")
                .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        }).setPositiveButton("Hinzufugen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
               // Bitmap bmp = bitmap;
              //  bmp.compress(Bitmap.CompressFormat.PNG,100,stream);
                byte[] byteArray = stream.toByteArray();
               // Bitmap image = BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
                String addresse = etAdress.getText().toString();
                String ort = etOrt.getText().toString();
                String platz = etPlatz.getText().toString();
                String preis = etPreis.getText().toString();
                String kontakname = etKontakName.getText().toString();
                String kontaknummer = etKontakNummer.getText().toString();
                insert_dialogInterface.applyTexts(imageUri,addresse,ort,platz,preis,kontakname,kontaknummer,0);
            }
        });
        mButtonBildeinfuegen = view.findViewById(R.id.mButtonBildeinfuegen);
        mButtonBildeinfuegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //askPermissionsCamera();
                selectImage();
            }
        });

        ivAngebot = view.findViewById(R.id.imageViewAngebot);
        ivAngebot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                      //  requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else{
                       // pickImageFromGallery();
                    }
                }
                else{
                   // pickImageFromGallery();
                }
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
/*
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
               bitmap = scaleDownBitmap(bitmap, 200, this);
               ivAngebot.setImageBitmap(bitmap);
           }catch (IOException exception){
              exception.printStackTrace();
           }
        }
    }

    public static Bitmap scaleDownBitmap(Bitmap photo, int newHeight, AngebotHinzufugen context) {

        final float densityMultiplier = context.getResources().getDisplayMetrics().density;

        int h= (int) (newHeight*densityMultiplier);
        int w= (int) (h * photo.getWidth()/((double) photo.getHeight()));

        photo=Bitmap.createScaledBitmap(photo, w, h, true);

        return photo;
    }
*/
private void selectImage() {
    final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
     AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("Add Photo!");
    builder.setItems(options, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int item) {
            if (options[item].equals("Take Photo"))
            {
                //askPermissionsCamera();
                askPermissionsCamera();
            }
            else if (options[item].equals("Choose from Gallery"))
            {
                openGallery();
            }
            else if (options[item].equals("Cancel")) {
                dialog.dismiss();
            }
        }
    });
    builder.show();
}

    private void askPermissionsCamera() {
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA
            },CAMERA_PERM_CODE);
        }else {
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(getActivity(),"Camera Permission is Required to use camera",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera,CAMERA_REQUEST_CODE);
        // Toast.makeText(getApplication(),"open camera is clicked",Toast.LENGTH_SHORT).show();
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        //take a photo from the camera
        if (resultCode == RESULT_OK && requestCode == CAMERA_REQUEST_CODE) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            //mImageView.setImageBitmap(bitmap);
            imageUri = bitmap;
            //mImageView.setImageURI(data.getData());
        }

        //take a photo from the gallery
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            // mImageView.setImageURI(data.getData());
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                imageUri = bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onAttach(@NonNull Context context){
        insert_dialogInterface = (insert_dialogInterface) context;
        super.onAttach(context);
    }

    public interface insert_dialogInterface{
        public void applyTexts(Bitmap image ,String addresse, String ort, String platz, String preis, String kontakname, String kontaknummer,int position);
    }
}
