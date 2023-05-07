package com.example.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        broadcastReceiver = new InternetReciver();
        internetStatus();
    }

    public void open_profile(View view) {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

    public void internetStatus(){
        registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    public void goToGithubPage(View view) {
        Intent GithubPage = new Intent(Intent.ACTION_VIEW);
        GithubPage.setData(Uri.parse("https://github.com/programmer-weeb/android-app"));
        startActivity(GithubPage);
    }

}