package com.wordpress.kaiyima.autismappjam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionSeven extends AppCompatActivity {

    TextView tv;
    Button btA;
    Button btB;
    Button btR;
    Button btP;
    Button btN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_seven);
        tv = (TextView) findViewById(R.id.Q7answer);
        btA = (Button) findViewById(R.id.Q7buttonA);
        btB = (Button) findViewById(R.id.Q7buttonB);
        btR = (Button) findViewById(R.id.Q7return);
        btP = (Button) findViewById(R.id.Q7pre);
        btN = (Button) findViewById(R.id.Q7nex);

        btA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Congratulations!!!\nButton A is a better choice!");
            }
        });
        btB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("\nButton A is a better choice :)\nYou can choose one more time!");
            }
        });
        btR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionSeven.this, QuestionList.class);
                startActivity(i);
            }
        });
        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionSeven.this ,QuestionEight.class);
                startActivity(i);
            }
        });
        btP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionSeven.this ,QuestionSix.class);
                startActivity(i);
            }
        });
    }
}
