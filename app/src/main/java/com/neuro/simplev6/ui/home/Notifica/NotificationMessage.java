package com.neuro.simplev6.ui.home.Notifica;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neuro.simplev6.R;

public class NotificationMessage extends AppCompatActivity {

    TextView textView;
    Bundle bundle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_message);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        textView = findViewById(R.id.tv_message);
        bundle = getIntent().getExtras();
        textView.setText(bundle.getString("message"));
        Button butmap = findViewById(R.id.buttonmap2);

        butmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,  Uri.parse("google.navigation:q="+bundle.getString("message")));

                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
    }
});





    }




}