package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View view){
        // Making sure all the data was entered
        EditText name = (EditText) findViewById(R.id.name);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText DOB = (EditText) findViewById(R.id.DOB);
        EditText username = (EditText) findViewById(R.id.emailRegistered);
        EditText password = (EditText) findViewById(R.id.passwordRegistered);

        // validate that these fields are not empty
        if (name.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || DOB.getText().toString().isEmpty() || username.getText().toString().isEmpty()
                || password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter all the information", Toast.LENGTH_SHORT).show();
        }
        else {
            // save Information on DB then return to main window
            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Insert your data to database then return to main activity


    }
}
