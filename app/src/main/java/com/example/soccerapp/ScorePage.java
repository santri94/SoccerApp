package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ScorePage extends AppCompatActivity {
    TextView final_score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);
        final_score = (TextView)findViewById(R.id.FinalScore);
        DisplayFinalScore();
    }

    public void DisplayFinalScore() {
        //--------------------------------------------------------------------------------------
        // We can Just simply do if statements and check answers in answersAndEmail ArrayList.
        // Check index 1 for answer to question 1, then Check index 2 for answer to question 2
        // and so on till question 5, make sure you update the counter or score for each correct
        // answer. After this just display counter in final_score text view.
        //--------------------------------------------------------------------------------------
        Bundle extras = getIntent().getExtras();
        ArrayList<String> answersAndEmail = extras.getStringArrayList("answersAndEmail"); // getting all the answers

        int counter = 0; // initial score


        if (answersAndEmail.get(1).equals("CroatiaFrance")){
            counter += 1;
        }
        if (answersAndEmail.get(2).equals("Luka Modric")){
            counter += 1;
        }
        if (answersAndEmail.get(3).equals("Liverpool")){
            counter += 1;
        }
        if (answersAndEmail.get(4).equals("2 - 0")){
            counter += 1;
        }
        if (answersAndEmail.get(5).equals("Istanbul, Turkey")){
            counter += 1;
        }

        //made score a string
        String newScore = String.valueOf(counter);
        final_score.setText("Final Score : " + newScore);

        //Need this to save final Score for each user

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();


        //Saving Final Score to SharedPreferences
        // First Check if there is a score for this user already in SharedPrerences
        // if there is one, Get rid of it.
        String score = pref.getString("Score"+answersAndEmail.get(0),null);
        if(score != null){ //Meaning there is an older value, delete it.
            editor.remove("Score"+answersAndEmail.get(0));
            editor.commit();
            // then store new score
            editor.putString("Score"+answersAndEmail.get(0), newScore); //answersAndEmail.get(0) will contain email for each user
            editor.commit();
        }
        else {
            editor.putString("Score"+answersAndEmail.get(0), newScore); //answersAndEmail.get(0) will contain email for each user
            editor.commit();
        }






        //--------------------------------------------------------------------------------------
    }

    public void EndGame(View view)
    {
        finish();
    }
}
