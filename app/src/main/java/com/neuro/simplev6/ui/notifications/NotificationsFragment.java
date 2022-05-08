package com.neuro.simplev6.ui.notifications;

import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.neuro.simplev6.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.Objects;


public class NotificationsFragment extends Fragment {


    private FragmentNotificationsBinding binding;
    CardView cardView, cardView2, cardView5;
    TextView contactotext;

    String tel;
    ImageView img5;

    public static ArrayList<String> contact = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
// conacto 1
        // nombre
        SharedPreferences name = requireContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        String nom = name.getString("nom", "Contacto");
        // telefono
        SharedPreferences sp = requireContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        tel = sp.getString("tel", "");


        contactotext = binding.contactotext;
        cardView5= binding.cardView5;
        contactotext.setText(nom);
        cardView5.setOnClickListener(v -> {
            // contacte emergencia
            if (nom.equals("Contacto") || tel.equals("")){
                Intent intent2 = new Intent(getContext(), contactoemergencia.class);
                intent2.putExtra("contacto1",1);
                startActivity(intent2);
            } else {
                Intent contactcall = new Intent(Intent.ACTION_DIAL);

                contactcall.setData(Uri.parse("tel:"+tel));
                startActivity(contactcall);
            }

        });
        cardView5.setOnLongClickListener(v -> {
            Intent intent2 = new Intent(getContext(), contactoemergencia.class);
            startActivity(intent2);
            return false;
        });

        img5 = binding.img5;;

        // foto

        SharedPreferences fot = getContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        String image = fot.getString("image", "null");
        /*
        if (image.equals("null")){
            Uri imageUri = Uri.parse(image);
            img5.setImageURI(imageUri);
            Toast.makeText(getActivity(), "sip", Toast.LENGTH_LONG).show();

        }


         */
















        cardView = binding.cardView;
        cardView2= binding.cardView2;
        cardView.setOnClickListener(v -> call(1));
        cardView2.setOnClickListener(v -> call(2) );

        return root;
    }



    private void call(int i) {

        if (i == 1) {
            Intent emergencias = new Intent(Intent.ACTION_DIAL);
            emergencias.setData(Uri.parse("tel:112"));
            startActivity(emergencias);
        } else if(i == 2){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("A que Policia? (Preferiblemente emergencias)");
            builder.setNegativeButton("back",null);

            String[] animals = { "Mossos d'esquadra","Guardia Civil","Ertzaintza","Policía Foral de Navarra"};
            builder.setItems(animals, (dialog, which) -> {
                switch (which) {
                    case 0:
                        Intent Mossos = new Intent(Intent.ACTION_DIAL);
                        Mossos.setData(Uri.parse("tel:012"));
                        startActivity(Mossos);
                        break;
                    case 1:
                        Intent Guardia = new Intent(Intent.ACTION_DIAL);
                        Guardia.setData(Uri.parse("tel:062"));
                        startActivity(Guardia);
                        break;
                    case 2:
                        Intent Ertzaintza = new Intent(Intent.ACTION_DIAL);
                        Ertzaintza.setData(Uri.parse("tel:900 103 584"));
                        startActivity(Ertzaintza);
                        break;
                    case 3:
                        Intent Foral = new Intent(Intent.ACTION_DIAL);
                        Foral.setData(Uri.parse("tel:848 426 853"));
                        startActivity(Foral);
                        break;
// 061
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences name = getContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        String nom = name.getString("nom", "Contacto");
        contactotext.setText(nom);

        SharedPreferences sp = getContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        tel = sp.getString("tel", "");

        SharedPreferences fot = getContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        String image = fot.getString("image", "null");
        if (image.equals("null")){
            Uri imageUri = Uri.parse(image);
            img5.setImageURI(imageUri);
        }








    }



    // Check whether user has phone contacts manipulation permission or not.







}