package com.neuro.simplev6.ui.notifications;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.neuro.simplev6.R;
import com.neuro.simplev6.databinding.FragmentNotificationsBinding;
import com.neuro.simplev6.ui.notifications.emergencia.contactoemergencia;
import com.neuro.simplev6.ui.notifications.emergencia.contactoemergencia2;

import java.util.ArrayList;


public class NotificationsFragment extends Fragment {


    private FragmentNotificationsBinding binding;
    CardView cardView, cardView2, cardView5, cardView6;
    TextView contactotext, contactotext2;
    String tel, tel2;

    public static ArrayList<String> contact = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // animacio hori
        HorizontalScrollView sv = binding.scrollView;

        Handler h = new Handler();

        for (int i = 0; i < 300; ++i) {
            int finalI = i;
            h.postDelayed(new Runnable() {

                @Override
                public void run() {

                    sv.scrollTo(finalI, 0);
                }
            }, 2050); // 250 ms delay
        }
        for (int i = 0; i < 300; ++i) {
            int finalI = i;
            h.postDelayed(new Runnable() {

                @Override
                public void run() {

                    sv.scrollTo(0, finalI);

                }
            }, 2750); // 250 ms delay
        }







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
                intent2.putExtra("contacto",1);
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

// conacto 2
        // nombre
        SharedPreferences name2 = requireContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        String nom2 = name2.getString("nom2", "Contacto");
        // telefono
        SharedPreferences sp2 = requireContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        tel2 = sp2.getString("tel2", "");

        contactotext2 = binding.contactotext2;
        cardView6= binding.cardView6;
        contactotext2.setText(nom2);
        cardView6.setOnClickListener(v -> {
            // contacte emergencia
            if (nom2.equals("Contacto") || tel2.equals("")){
                Intent intent2 = new Intent(getContext(), contactoemergencia2.class);
                intent2.putExtra("contacto",1);
                startActivity(intent2);
            } else {
                Intent contactcall = new Intent(Intent.ACTION_DIAL);

                contactcall.setData(Uri.parse("tel:"+tel2));
                startActivity(contactcall);
            }

        });
        cardView6.setOnLongClickListener(v -> {
            Intent intent2 = new Intent(getContext(), contactoemergencia2.class);
            startActivity(intent2);
            return false;
        });




















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
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.MyAlertDialogTheme);
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


        // contacto 2
        SharedPreferences name2 = getContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        String nom2 = name2.getString("nom2", "Contacto");
        contactotext2.setText(nom2);

        SharedPreferences sp2 = getContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        tel2 = sp2.getString("tel2", "");









    }



    // Check whether user has phone contacts manipulation permission or not.







}