package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getSupportActionBar().hide();

    }


    public void Login(View view){
        EditText username = (EditText) findViewById(R.id.email);
        EditText pass = (EditText) findViewById(R.id.password);

        // validate that these fields are not empty
        if (username.getText().toString().isEmpty() || pass.getText().toString().isEmpty() ) {
            Toast.makeText(getApplicationContext(), "Please Enter Email and password", Toast.LENGTH_SHORT).show();
        }
        else {

            // Compare username and pass with the ones on your Preferences
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();

            String email;
            String password;

            email = pref.getString("#"+username.getText().toString(),null);
            password = pref.getString(username.getText().toString(),null);



            // User login Successful
            if (email.equals(username.getText().toString()) && password.equals(pass.getText().toString())) {
                username.setText(""); //clear email field
                pass.setText(""); // clear password field
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class ));

            }
            // User login failed
            else{
                Toast.makeText(getApplicationContext(), "Wrong Email or password", Toast.LENGTH_SHORT).show();
            }



        }


    }

    public void GoToRegisterPage(View view){
        startActivity(new Intent(MainActivity.this, RegisterActivity.class ));

    }


}
