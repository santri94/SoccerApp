package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;

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

    public void Register(View view) {
        // Making sure all the data was entered
        EditText name = (EditText) findViewById(R.id.name);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText DOB = (EditText) findViewById(R.id.DOB);
        EditText username = (EditText) findViewById(R.id.emailRegistered);
        EditText password = (EditText) findViewById(R.id.passwordRegistered);

        //Testing SharedPreferences
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        // Some Validation for email, name and last name
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String emailTmp = username.getText().toString();

        // validate that these fields are not empty
        if (name.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || DOB.getText().toString().isEmpty() || username.getText().toString().isEmpty()
                || password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Enter all the information", Toast.LENGTH_SHORT).show();
        }
        else if(name.getText().toString().length() < 3 || name.getText().toString().length() >= 30){
            Toast.makeText(getApplicationContext(), "Please Enter a correct name", Toast.LENGTH_SHORT).show();
        }
        else if(!emailTmp.matches(regex)){
            Toast.makeText(getApplicationContext(), "Please Enter a valid email address", Toast.LENGTH_SHORT).show();
        }
        else {

            editor.putString("#"+emailTmp, emailTmp);
            editor.putString(emailTmp,password.getText().toString());
            editor.commit();

            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
            finish();

        }




    }
}
