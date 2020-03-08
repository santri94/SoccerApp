package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(), "Answer :" + result, Toast.LENGTH_SHORT).show();
    }
}
