package com.example.soccerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HistoryPage extends AppCompatActivity {
    TextView last_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_page);
        last_score = (TextView)findViewById(R.id.LastScore);
        DisplayScore();
    }

    public void DisplayScore(){

        //Get email
        Bundle extras = getIntent().getExtras();
        String email = extras.getString("email");
        //Need this to Get final Score for each user

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();


        // First Check if there is a score for this user already in SharedPrerences
        // if there is display it, if not display NO DATA.
        String score = pref.getString("Score"+email,null);
        if (score != null){
            last_score.setText("Last Game Score : "+score);
        }
        else {
            last_score.setText("NO DATA");
        }
    }

    public void GoBack(View view){
        finish();

    }
}
