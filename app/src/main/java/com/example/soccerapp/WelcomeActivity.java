package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        LoadUser();
        //getSupportActionBar().hide();
    }

    public void LoadUser(){
        TextView username = (TextView) findViewById(R.id.hi);


        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email");
        username.setText("Hi: "+email);

    }

    public void LogOut(View view){
        finish();

    }

}
