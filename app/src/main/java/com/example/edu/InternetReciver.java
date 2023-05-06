package com.example.edu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InternetReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = CheckInternet.getNetworkInfo(context);
        if(status.equals("connected")) {
            Toast.makeText(context, "Internet Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Internet Not Connected", Toast.LENGTH_SHORT).show();
        }
    }
}
