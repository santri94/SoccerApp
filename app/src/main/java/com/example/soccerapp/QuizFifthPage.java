package com.example.soccerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizFifthPage extends AppCompatActivity {
    RadioButton madrid_spain, istanbul_turkey, kiev_ukraine, rome_italy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_fifth_page);
        madrid_spain = (RadioButton)findViewById(R.id.Madrid_Spain);
        istanbul_turkey = (RadioButton)findViewById(R.id.Istanbul_Turkey);
        kiev_ukraine = (RadioButton)findViewById(R.id.Kiev_Ukraine);
        rome_italy = (RadioButton)findViewById(R.id.Rome_Italy);
    }

    public void FifthQuestion(View view)
    {
        //----------------------------------------------------------------------------------------
        //                              - Get selected answer
        //                              - Get array of email and answers
        //                              - try to add answer to this array
        //----------------------------------------------------------------------------------------

        String answerSelected = "";
        if (madrid_spain.isChecked()){
            answerSelected = "Madrid, Spain";
        }
        if (istanbul_turkey.isChecked()){
            answerSelected = "Istanbul, Turkey";
        }
        if (kiev_ukraine.isChecked()){
            answerSelected = "Kiev, Ukraine";
        }
        if (rome_italy.isChecked()){
            answerSelected = "Rome, Italy";
        }




        Bundle extras = getIntent().getExtras();
        ArrayList<String> answersAndEmail = extras.getStringArrayList("answersAndEmail");
        answersAndEmail.add(answerSelected);

        //------------------------------------------------------------------------------------------
        //                      Alert Dialog to confirm the answer
        //------------------------------------------------------------------------------------------

        new AlertDialog.Builder(this, R.style.CustomDialogTheme)
                .setTitle("Submit Answer?")
                .setMessage(answerSelected)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //---------------------------------------------------------------------------
                        Intent intent=new Intent(QuizFifthPage.this,ScorePage.class);
                        intent.putExtra("answersAndEmail",answersAndEmail);
                        startActivity(intent);
                        finish();
                        //---------------------------------------------------------------------------
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // No action
                    }
                })
                .show();






        //------------------------------------------------------------------------------------------


        //Toast.makeText(getApplicationContext(), "Answer :" + answersAndEmail.get(4), Toast.LENGTH_SHORT).show();

    }
}
