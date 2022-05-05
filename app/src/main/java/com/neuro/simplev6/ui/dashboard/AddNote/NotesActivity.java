package com.neuro.simplev6.ui.dashboard.AddNote;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.neuro.simplev6.R;
import com.neuro.simplev6.ui.dashboard.DashboardFragment;

import java.util.HashSet;

public class NotesActivity extends AppCompatActivity {


    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ImageView imageView = findViewById(R.id.cancel);
        imageView.setOnClickListener(view -> finish());

        Toolbar toolbar = findViewById(R.id.toolbar);

        AnimationDrawable animationDrawable = (AnimationDrawable) toolbar.getBackground();

        animationDrawable.setEnterFadeDuration(3);
        animationDrawable.setExitFadeDuration(600);
        animationDrawable.start();

// el que fa que el hint puji


        EditText editText = findViewById(R.id.edittext);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        if (noteId != -1){
            editText.setText(DashboardFragment.notes.get(noteId));
        }
        else {
            DashboardFragment.notes.add("");
            noteId=DashboardFragment.notes.size()-1;
            DashboardFragment.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                DashboardFragment.notes.set(noteId,String.valueOf(charSequence));
                DashboardFragment.arrayAdapter.notifyDataSetChanged();


                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("com.neuro.simplev6", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(DashboardFragment.notes);
                sharedPref.edit().putStringSet("notes",set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}