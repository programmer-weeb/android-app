package com.example.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText uname, pass, mail;
    Button signupButton;
    TextView loginText;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        uname = (EditText) findViewById(R.id.edittext1);
        pass = (EditText) findViewById(R.id.edittext2);
        mail = (EditText) findViewById(R.id.emailtext);
        signupButton = (Button) findViewById(R.id.button2);
        loginText = (TextView) findViewById(R.id.textView3);
        sharedPreferences = getSharedPreferences("UserInfo", 0);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fromLoginToHome
                String username = uname.getText().toString();
                String password = pass.getText().toString();
                String email = mail.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (username.length() > 1){
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.putString("email", email);
                    editor.apply();
                    Toast.makeText(signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(signup.this, "ENTERVALUE in the field", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
    public void goToLoginPage(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    public void fromSignupToHome(View view) {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    public void Emptyfield(){
        uname.setText("");
        pass.setText("");
        mail.setText("");

    }
}