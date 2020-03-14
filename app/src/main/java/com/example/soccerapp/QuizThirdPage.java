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

public class QuizThirdPage extends AppCompatActivity {

    RadioButton realmadrid, liverpool, barcelona, juventus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_third_page);
        realmadrid = (RadioButton)findViewById(R.id.RealMadrid);
        liverpool = (RadioButton)findViewById(R.id.Liverpool);
        barcelona = (RadioButton)findViewById(R.id.Barcelona);
        juventus = (RadioButton)findViewById(R.id.Juventus);
    }

    public void ThirdQuestion(View view)
    {
        //----------------------------------------------------------------------------------------
        //                              - Get selected answer
        //                              - Get array of email and answers
        //                              - try to add answer to this array
        //----------------------------------------------------------------------------------------

        String answerSelected = "";
        if (realmadrid.isChecked()){
            answerSelected = "Real Madrid";
        }
        if (liverpool.isChecked()){
            answerSelected = "Liverpool";
        }
        if (barcelona.isChecked()){
            answerSelected = "Barcelona";
        }
        if (juventus.isChecked()){
            answerSelected = "Juventus";
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
                        Intent intent=new Intent(QuizThirdPage.this,QuizFourthPage.class);
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


        //Toast.makeText(getApplicationContext(), "Answer :" + answersAndEmail.get(2), Toast.LENGTH_SHORT).show();

    }
}
