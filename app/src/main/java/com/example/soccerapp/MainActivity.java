package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view){
        EditText username = (EditText) findViewById(R.id.email);
        EditText pass = (EditText) findViewById(R.id.password);

        // validate that these fields are not empty
        if (username.getText().toString().isEmpty() || pass.getText().toString().isEmpty() ) {
            Toast.makeText(getApplicationContext(), "Please Enter Email and password", Toast.LENGTH_SHORT).show();
        }
        else {
            // Compare username and pass with the ones on your DB
        }


    }

    public void GoToRegisterPage(View view){
        startActivity(new Intent(MainActivity.this, RegisterActivity.class ));

    }


}
