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
        getSupportActionBar().hide();
    }

    public void Register(View view) throws Exception{
        // Making sure all the data was entered
        EditText name = (EditText) findViewById(R.id.name);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText DOB = (EditText) findViewById(R.id.DOB);
        EditText username = (EditText) findViewById(R.id.emailRegistered);
        EditText password = (EditText) findViewById(R.id.passwordRegistered);

        // Some Validation for email, name and last name


        // validate that these fields are not empty
        if (name.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || DOB.getText().toString().isEmpty() || username.getText().toString().isEmpty()
                || password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter all the information", Toast.LENGTH_SHORT).show();
        }
        else if(name.getText().toString().length() < 3 || name.getText().toString().length() >= 30){
            Toast.makeText(getApplicationContext(), "Please Enter a correct name", Toast.LENGTH_SHORT).show();
        }
        else if(!username.getText().toString().contains("@")){
            Toast.makeText(getApplicationContext(), "Please Enter a valid email address", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                // save Information on DB then return to main window
                String email = username.getText().toString();
                String pass = password.getText().toString();
                String F_Name = name.getText().toString();
                String L_Name = lastName.getText().toString();
                String DateOfBirth = DOB.getText().toString();
                //Creating Database Object
                Database.DatabaseFunctions myDatabase = new Database.DatabaseFunctions();

                // Insert your data to database then return to main activity
                myDatabase.InsertUser(email,pass,F_Name,L_Name,DateOfBirth);

                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                finish();
            }catch (Exception e){
                System.out.println(e);
            }

        }




    }
}
