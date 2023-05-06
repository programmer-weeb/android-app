package com.example.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void open_profile(View view) {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

    public void openMap(View v) {
        Intent location = new Intent(Intent.ACTION_VIEW);
        location.setData(Uri.parse("https://maps.app.goo.gl/pjP1Tjz91963Sq6N8"));
        startActivity(location);
    }
}