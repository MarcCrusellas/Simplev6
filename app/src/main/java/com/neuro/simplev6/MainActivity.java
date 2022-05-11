package com.neuro.simplev6;

import static com.neuro.simplev6.ui.dashboard.DashboardFragment.notes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.ArrayAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.neuro.simplev6.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    protected PowerManager.WakeLock wakelock;
    private ActivityMainBinding binding;

    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//evitar que la pantalla se apague
        final PowerManager pm=(PowerManager)getSystemService(Context.POWER_SERVICE);
        this.wakelock= pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "etiqueta");
        wakelock.acquire();

    }
    /*Esto, junto con el onDestroy, hacen que la pantalla siga encendida hasta que la actividad termine*/
    protected void onDestroy(){
        super.onDestroy();

        this.wakelock.release();
    }
    protected void onResume(){
        super.onResume();
        wakelock.acquire();
    }
    public void onSaveInstanceState(Bundle icicle) {
        super.onSaveInstanceState(icicle);
        this.wakelock.release();
    }

    ArrayList<String> notes2 = new ArrayList<>();



    public ArrayAdapter getlist(ArrayAdapter arrayAdapter2, Context context) {
        SharedPreferences sharedPref = getSharedPreferences("com.neuro.simplev6", Context.MODE_PRIVATE);

        HashSet<String> set2 = (HashSet<String>) sharedPref.getStringSet("notes", null);


        notes = new ArrayList<>(set2);

        arrayAdapter2 = new ArrayAdapter(context, R.layout.item_note,notes);
        return arrayAdapter2;
    }

}