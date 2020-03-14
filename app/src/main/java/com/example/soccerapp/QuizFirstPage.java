package com.example.soccerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizFirstPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_first_page);

    }

    public void FirstQuestion(View view){
        CheckBox germany = (CheckBox)findViewById(R.id.Germany);
        CheckBox croatia = (CheckBox)findViewById(R.id.Croatia);
        CheckBox brazil = (CheckBox)findViewById(R.id.Brazil);
        CheckBox france = (CheckBox)findViewById(R.id.France);
        String email;



        //---------------------------------------------------------------------------
        //      Need to Store the answer on an array with the Email
        //           then pass this array to the new intent
        //              which would be second question
        //---------------------------------------------------------------------------
        String result = "";

        if(germany.isChecked()){
            result += "Germany";
        }
        if(croatia.isChecked()){
            result += "Croatia";
        }
        if(brazil.isChecked()){
            result += "Brazil";
        }
        if(france.isChecked()){
            result += "France";
        }

        Bundle extras = getIntent().getExtras();
        email = extras.getString("email");
        ArrayList<String> answersAndEmail = new ArrayList<String>();
        answersAndEmail.add(email);
        answersAndEmail.add(result);


        //Toast.makeText(getApplicationContext(), "Answer :" + result, Toast.LENGTH_SHORT).show();

        //---------------------------------------------------------------------------
        //      Need to create an alert Dialog to confirm the answer
        //           then launch the intent
        //---------------------------------------------------------------------------
        new AlertDialog.Builder(this, R.style.CustomDialogTheme)
                .setTitle("Submit Answer?")
                .setMessage(result)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //---------------------------------------------------------------------------
                        Intent intent=new Intent(QuizFirstPage.this,QuizSecondPage.class);
                        intent.putExtra("answersAndEmail",answersAndEmail);
                        startActivity(intent);
                        finish();
                        //---------------------------------------------------------------------------
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // No Action
                    }
                })
                .show();

        //---------------------------------------------------------------------------






    }
}
