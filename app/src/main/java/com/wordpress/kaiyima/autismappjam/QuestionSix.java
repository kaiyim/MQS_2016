package com.wordpress.kaiyima.autismappjam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionSix extends AppCompatActivity {

    TextView tv;
    Button btA;
    Button btB;
    Button btR;
    Button btP;
    Button btN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_six);
        tv = (TextView) findViewById(R.id.Q6answer);
        btA = (Button) findViewById(R.id.Q6buttonA);
        btB = (Button) findViewById(R.id.Q6buttonB);
        btR = (Button) findViewById(R.id.Q6return);
        btP = (Button) findViewById(R.id.Q6pre);
        btN = (Button) findViewById(R.id.Q6nex);

        btB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("Congratulations!!!\nButton B is a better choice!");
            }
        });
        btA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("\nButton B is a better choice :)\nYou can choose one more time!");
            }
        });
        btR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionSix.this, QuestionList.class);
                startActivity(i);
            }
        });
        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionSix.this ,QuestionSeven.class);
                startActivity(i);
            }
        });
        btP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionSix.this ,QuestionFive.class);
                startActivity(i);
            }
        });
    }
}
