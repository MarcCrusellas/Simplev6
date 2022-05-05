package com.neuro.simplev6.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.neuro.simplev6.R;
import com.neuro.simplev6.databinding.FragmentHomeBinding;
import com.neuro.simplev6.ui.home.Adapter.EventAdapter;
import com.neuro.simplev6.ui.home.AddAlarm.CreateEvent;
import com.neuro.simplev6.ui.home.Database.DatabaseClass;
import com.neuro.simplev6.ui.home.Database.EntityClass;

import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener  {

    FloatingActionButton createEvent, delete;
    EventAdapter eventAdapter;
    RecyclerView recyclerview;
    DatabaseClass databaseClass;
    List<EntityClass> classList;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
// test
        createEvent = binding.facCreateEvent;
        recyclerview = binding.recyclerview;
        delete = binding.facDeleteallEvent;
        createEvent.setOnClickListener(this);
        delete.setOnClickListener(this);

        // ha cambiat


        databaseClass = DatabaseClass.getDatabase(getActivity());
// test


// test
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // test
    @Override
    public void onResume() {
        super.onResume();
        setAdapter();

    }

    private void setAdapter() {

        classList = databaseClass.EventDao().getAllData();
        eventAdapter = new EventAdapter(getContext(), classList);
        recyclerview.setAdapter(eventAdapter);

        recyclerview.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerview ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                    }

                    @Override public void onLongItemClick(View view, int position) {

                        new AlertDialog.Builder(getContext())
                                .setTitle("Quieres borrar esta Alarma?")
                                .setIcon(R.drawable.ic_baseline_delete_sweep_24)
                                .setPositiveButton("Si", (dialog, i) -> deteletdata())

                                .setNegativeButton("No",null)
                                .show();
                        return;
                    }
                })
        );
    }

    @Override
    public void onClick(View view) {
        if (view == createEvent) {
            goToCreateEventActivity();
        } else if(view == delete){
            goToDeleteAlarm();
        }
    }

    private void goToCreateEventActivity() {
        Intent intent = new Intent(getContext(), CreateEvent.class);
        startActivity(intent);
    }

    private void goToDeleteAlarm() {

        new AlertDialog.Builder(getContext())
                .setTitle("Quieres borrar todas las alarmas?")
                .setIcon(R.drawable.ic_baseline_delete_sweep_24)
                .setPositiveButton("Si", (dialog, i) -> deteletdatas())

                .setNegativeButton("No",null)
                .show();
        return;

    }
    private void deteletdatas() {
        databaseClass.EventDao().delete();
        recyclerview.setAdapter(null);
    }

    private void deteletdata() {

        databaseClass.EventDao().deleteevent("test");


        classList = databaseClass.EventDao().getAllData();
        eventAdapter = new EventAdapter(getContext(), classList);
        recyclerview.setAdapter(eventAdapter);


        Log.println(Log.VERBOSE,"animal", String.valueOf(recyclerview));
    }
    // test
}