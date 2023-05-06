package com.example.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.button2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fromLoginToHome
                Intent intent = new Intent(login.this, home.class);
                startActivity(intent);
            }
        });
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