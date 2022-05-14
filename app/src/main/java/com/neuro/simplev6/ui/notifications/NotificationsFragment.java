package com.neuro.simplev6.ui.notifications;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.neuro.simplev6.R;
import com.neuro.simplev6.databinding.FragmentNotificationsBinding;
import com.neuro.simplev6.ui.notifications.emergencia.contactoemergencia;
import com.neuro.simplev6.ui.notifications.emergencia.contactoemergencia2;

import java.util.ArrayList;


public class NotificationsFragment extends Fragment {


    private FragmentNotificationsBinding binding;
    CardView cardView, cardView2, cardView5, cardView6, maps;
    TextView contactotext, contactotext2;
    String tel, tel2;
    private GoogleMap mMap;
    public static ArrayList<String> contact = new ArrayList<>();
    Fragment map;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



// ubi

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
        cardView5 = binding.cardView5;
        contactotext.setText(nom);
        cardView5.setOnClickListener(v -> {
            // contacte emergencia
            if (nom.equals("Contacto") || tel.equals("")) {
                Intent intent2 = new Intent(getContext(), contactoemergencia.class);
                intent2.putExtra("contacto", 1);
                startActivity(intent2);
            } else {
                Intent contactcall = new Intent(Intent.ACTION_DIAL);

                contactcall.setData(Uri.parse("tel:" + tel));
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
        SharedPreferences sp5 = requireContext().getSharedPreferences("com.neuro.simplev6", MODE_PRIVATE);
        tel2 = sp5.getString("tel2", "");



        contactotext2 = binding.contactotext2;
        cardView6 = binding.cardView6;
        contactotext2.setText(nom2);
        cardView6.setOnClickListener(v -> {
            // contacte emergencia
            if (nom2.equals("Contacto") || tel2.equals("")) {
                Intent intent2 = new Intent(getContext(), contactoemergencia2.class);
                intent2.putExtra("contacto", 1);
                startActivity(intent2);
            } else {
                Intent contactcall = new Intent(Intent.ACTION_DIAL);

                contactcall.setData(Uri.parse("tel:" + tel2));
                startActivity(contactcall);
            }

        });
        cardView6.setOnLongClickListener(v -> {
            Intent intent2 = new Intent(getContext(), contactoemergencia2.class);
            startActivity(intent2);
            return false;
        });


        cardView = binding.cardView;
        cardView2 = binding.cardView2;
        cardView.setOnClickListener(v -> call(1));
        cardView2.setOnClickListener(v -> call(2));



        maps = binding.maps;
        cardView2.setOnClickListener(v -> call(2));
        Button buttonmap = binding.buttonmap;
        buttonmap.setOnClickListener(v -> call(3));






        TextView calle= binding.calle;


        calle.setOnClickListener(v ->  {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Comment");

            final EditText input = new EditText(getContext());

            SharedPreferences sp6 = getContext().getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
            String calle1 = sp6.getString("calle", "");
            input.setText(calle1);

            input.setInputType(InputType.TYPE_CLASS_TEXT);
            input.setLines(1);
            input.setMaxLines(5);
            input.setGravity(Gravity.LEFT | Gravity.TOP);
            builder.setView(input);

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {

                    String nombreput = input.getText().toString();
                    SharedPreferences sp = getContext().getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("calle", nombreput);
                    editor.commit();
                    SharedPreferences sp6 = getContext().getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
                    String calle1 = sp6.getString("calle", "");
                    calle.setText(calle1);
                }
            });

            builder.setNegativeButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            /*
                String nombreput = calle.getText().toString();
                SharedPreferences sp = getContext().getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("calle", nombreput);
                editor.commit();

             */

        });
        SharedPreferences sp6 = getContext().getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
        String calle1 = sp6.getString("calle", "");
        calle.setText(calle1);

        return root;
    }


    private void call(int i) {

        if (i == 1) {
            Intent emergencias = new Intent(Intent.ACTION_DIAL);
            emergencias.setData(Uri.parse("tel:112"));
            startActivity(emergencias);
        } else if (i == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.MyAlertDialogTheme);
            builder.setTitle("A que Policia? (Preferiblemente emergencias)");
            builder.setNegativeButton("back", null);

            String[] animals = {"Mossos d'esquadra", "Guardia Civil", "Ertzaintza", "Policía Foral de Navarra"};
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


        } else if (i == 3) {
            // calle

            SharedPreferences sp = getContext().getSharedPreferences("com.neuro.simplev6", Activity.MODE_PRIVATE);
            String calle1 = sp.getString("calle", "");
            if (calle1.equals("")){
                return;
            }


// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,  Uri.parse("google.navigation:q="+calle1));
// Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");


// Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);









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