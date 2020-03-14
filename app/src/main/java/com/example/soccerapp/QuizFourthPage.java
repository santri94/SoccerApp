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

public class QuizFourthPage extends AppCompatActivity {

    RadioButton one_zero, four_two, two_zero, two_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_fourth_page);
        one_zero = (RadioButton)findViewById(R.id.One_Zero);
        four_two = (RadioButton)findViewById(R.id.Four_Two);
        two_zero = (RadioButton)findViewById(R.id.Two_Zero);
        two_one = (RadioButton)findViewById(R.id.Two_One);
    }

    public void FourthQuestion(View view)
    {
        //----------------------------------------------------------------------------------------
        //                              - Get selected answer
        //                              - Get array of email and answers
        //                              - try to add answer to this array
        //----------------------------------------------------------------------------------------

        String answerSelected = "";
        if (one_zero.isChecked()){
            answerSelected = "1 - 0";
        }
        if (four_two.isChecked()){
            answerSelected = "4 - 2";
        }
        if (two_zero.isChecked()){
            answerSelected = "2 - 0";
        }
        if (two_one.isChecked()){
            answerSelected = "2 - 1";
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
                        Intent intent=new Intent(QuizFourthPage.this,QuizFifthPage.class);
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


        //Toast.makeText(getApplicationContext(), "Answer :" + answersAndEmail.get(3), Toast.LENGTH_SHORT).show();

    }
}
