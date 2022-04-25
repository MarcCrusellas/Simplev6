package com.neuro.simplev6.ui.dashboard;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.neuro.simplev6.R;
import com.neuro.simplev6.databinding.FragmentDashboardBinding;
import com.neuro.simplev6.ui.dashboard.AddNote.NotesActivity;

import java.util.ArrayList;
import java.util.HashSet;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private FloatingActionButton floating;


    public static ArrayList<String> notes = new ArrayList<>();
    public static ArrayAdapter arrayAdapter;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
// prova


        ListView listView = binding.listView;

        SharedPreferences sharedPref = getContext().getSharedPreferences("com.neuro.simplev6", Context.MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPref.getStringSet("notes", null);
        if (set == null){
            notes.add("escrive aqui");
        } else {
            notes = new ArrayList<>(set);
        }


        arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_note,notes);
        listView.setAdapter(arrayAdapter);



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemToDelete= i;
                new AlertDialog.Builder(getContext())
                        .setTitle("Quieres borrar la nota?")
                        .setIcon(R.drawable.ic_baseline_delete_sweep_24)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick (DialogInterface dialog,int i){
                                notes.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();
                                SharedPreferences sharedPref = getContext().getSharedPreferences("com.neuro.simplev6", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet<>(DashboardFragment.notes);
                                sharedPref.edit().putStringSet("notes", set).apply();
                            }
                        })

                        .setNegativeButton("No",null)
                        .show();
                return true;

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), NotesActivity.class); // posible error
                intent.putExtra("noteId", i);
                startActivity(intent);
            }
        });

// prova
        floating = binding.floatingActionButton2;
        floating.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Accediendo a \n Añadir notas", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getContext(), NotesActivity.class);
                startActivity(intent2);
                // notes.add("escrive aqui");
                // ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
            }
        });

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}