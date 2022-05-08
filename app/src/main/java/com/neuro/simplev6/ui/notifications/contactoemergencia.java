package com.neuro.simplev6.ui.notifications;

import static com.neuro.simplev6.ui.notifications.NotificationsFragment.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.neuro.simplev6.R;
import com.neuro.simplev6.ui.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.HashSet;

public class contactoemergencia extends AppCompatActivity {

    EditText nombre, telefono;
    int noteId, telephone;
    int PICK_IMAGE_REQUEST = 200;
    private ImageView fotocontact;
    private Uri mImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactoemergencia);
        // permissionsCheck();
        // eliminar toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        // hacer que el apartado de arriva se vea del mismo color
        /*
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

         */


// nombre
        SharedPreferences name = getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
        String nom = name.getString("nom", "Contacto");
// telefono
        SharedPreferences sp = getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
        String tel = sp.getString("tel", "");

        nombre= findViewById(R.id.nombre);
        nombre.setText(nom);

        telefono= findViewById(R.id.telefono);
        telefono.setText(tel);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        telephone = intent.getIntExtra("telephone", -1);
        if (noteId != -1 & telephone != -1 ){
            nombre.setText(contact.get(noteId));
            telefono.setText(contact.get(telephone));

        }
        else {

        }

        fotocontact= findViewById(R.id.fotocontact);
        fotocontact.setOnClickListener(v -> imageChooser());
// foto
        SharedPreferences fot = getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        String image = fot.getString("image", "null");
/*
        try{
            Uri imageUri = Uri.parse(image);
            fotocontact.setImageURI(imageUri);
        }catch(Exception e) {
            Log.println(Log.VERBOSE,"animal", "error");
        }


 */
        nombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nombreput = nombre.getText().toString();
                SharedPreferences name = getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = name.edit();
                editor.putString("nom", nombreput);
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        telefono.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nombreput = telefono.getText().toString();
                SharedPreferences sp = getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("tel", nombreput);
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check which request we're responding to
        if (requestCode == PICK_IMAGE_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a image.
                // The Intent's data Uri identifies which item was selected.
                if (data != null) {

                    // This is the key line item, URI specifies the name of the data
                    mImageUri = data.getData();


                    // Saves image URI as string to Default Shared Preferences
                    SharedPreferences preferences = getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("image", String.valueOf(mImageUri));
                    editor.commit();



                    // Sets the ImageView with the Image URI
                    fotocontact.setImageURI(mImageUri);
                    fotocontact.invalidate();
                }
            }
        }
    }
    /*
    public void permissionsCheck() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            return;
        }
    }

     */
}