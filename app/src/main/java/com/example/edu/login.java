package com.example.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText username, password;
    SharedPreferences sharedPreferences;
    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "my_channel";

    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.edittext1);
        password = (EditText) findViewById(R.id.edittext2);
//        createNotificationChannel();
        loginButton = (Button) findViewById(R.id.button2);
        sharedPreferences = getSharedPreferences("UserInfo", 0);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname= username.getText().toString();
                String pass= password.getText().toString();
                String res = sharedPreferences.getString("username", "");
                String res1 = sharedPreferences.getString("password", "");
                // fromLoginToHome
                if (uname.equals(res) && pass.equals(res1)){
                    createNotificationChannel();
                    sendNotification();
                    Intent intent = new Intent(login.this, home.class);
                    startActivity(intent);
                }
//                notification
//                sendNotification();
            }
        });
    }
    private void sendNotification() {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("Login occurred")
                        .setContentText("You have logged in successfully!");

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notification);
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void goToSignUpPage(View view) {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

    public void fromLoginToHome() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }



}