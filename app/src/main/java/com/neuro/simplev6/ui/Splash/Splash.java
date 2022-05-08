package com.neuro.simplev6.ui.Splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.neuro.simplev6.MainActivity;
import com.neuro.simplev6.R;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ConstraintLayout constraintLayout = findViewById(R.id.layout);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(3);
        animationDrawable.setExitFadeDuration(600);
        animationDrawable.start();


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (!animationDrawable.isRunning()) {
            animationDrawable.start();
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent2 = new Intent(Splash.this, MainActivity.class);
                startActivity(intent2);
            }
        }, 1500);

    }
}
