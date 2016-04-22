package com.wordpress.kaiyima.autismappjam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionFive extends AppCompatActivity {

    TextView tv;
    Button btA;
    Button btB;
    Button btR;
    Button btP;
    Button btN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);
        tv = (TextView) findViewById(R.id.Q5answer);
        btA = (Button) findViewById(R.id.Q5buttonA);
        btB = (Button) findViewById(R.id.Q5buttonB);
        btR = (Button) findViewById(R.id.Q5return);
        btP = (Button) findViewById(R.id.Q5pre);
        btN = (Button) findViewById(R.id.Q5nex);

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
                Intent i = new Intent(QuestionFive.this, QuestionList.class);
                startActivity(i);
            }
        });
        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionFive.this ,QuestionSix.class);
                startActivity(i);
            }
        });
        btP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionFive.this ,QuestionFour.class);
                startActivity(i);
            }
        });
    }
}
