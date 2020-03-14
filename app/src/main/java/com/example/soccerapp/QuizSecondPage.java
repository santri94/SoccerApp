package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizSecondPage extends AppCompatActivity {

    RadioButton harry, luka, kylian, cristiano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_second_page);
        harry = (RadioButton)findViewById(R.id.HarryKane);
        luka = (RadioButton)findViewById(R.id.LukaModric);
        kylian = (RadioButton)findViewById(R.id.KylianMbappe);
        cristiano = (RadioButton)findViewById(R.id.CristianoRonaldo);
    }

    public void SecondQuestion(View view){

        //----------------------------------------------------------------------------------------
        //                              - Get selected answer
        //                              - Get array of email and answers
        //                              - try to add answer to this array
        //----------------------------------------------------------------------------------------

        String answerSelected = "";
        if (harry.isChecked()){
            answerSelected = "Harry Kane";
        }
        if (luka.isChecked()){
            answerSelected = "Luka Modric";
        }
        if (kylian.isChecked()){
            answerSelected = "Kylian Mbappe";
        }
        if (cristiano.isChecked()){
            answerSelected = "Cristiano Ronaldo";
        }




        Bundle extras = getIntent().getExtras();
        ArrayList<String> answersAndEmail = extras.getStringArrayList("answersAndEmail");
        answersAndEmail.add(answerSelected);
        //------------------------------------------------------------------------------------------
        //                      Alert Dialog to confirm the answer
        //------------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------------


        Toast.makeText(getApplicationContext(), "Answer :" + answersAndEmail.get(1), Toast.LENGTH_SHORT).show();


    }
}
