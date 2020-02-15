package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void Login(View view) throws Exception {
        EditText username = (EditText) findViewById(R.id.email);
        EditText pass = (EditText) findViewById(R.id.password);

        // validate that these fields are not empty
        if (username.getText().toString().isEmpty() || pass.getText().toString().isEmpty() ) {
            Toast.makeText(getApplicationContext(), "Please Enter Email and password", Toast.LENGTH_SHORT).show();
        }
        else {
            try{
                // Compare username and pass with the ones on your DB
                Database.DatabaseFunctions myDatabase = new Database.DatabaseFunctions(); // connect to database

                // returns a User object if there was a match if not then returns a null
                User currentUser = myDatabase.GetUser(username.getText().toString(), pass.getText().toString());

                if (currentUser != null) {
                    Toast.makeText(getApplicationContext(), "Hi "+ currentUser.F_Name, Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Email or password", Toast.LENGTH_SHORT).show();
                }



            } catch (Exception ex) {
                System.out.println(ex);
            }


        }


    }

    public void GoToRegisterPage(View view){
        startActivity(new Intent(MainActivity.this, RegisterActivity.class ));

    }


}
