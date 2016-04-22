package com.wordpress.kaiyima.autismappjam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionEight extends AppCompatActivity {

    TextView tv;
    Button btA;
    Button btB;
    Button btR;
    Button btP;
    Button btN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_eight);
        tv = (TextView) findViewById(R.id.Q8answer);
        btA = (Button) findViewById(R.id.Q8buttonA);
        btB = (Button) findViewById(R.id.Q8buttonB);
        btR = (Button) findViewById(R.id.Q8return);
        btP = (Button) findViewById(R.id.Q8pre);
        btN = (Button) findViewById(R.id.Q8nex);

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
                Intent i = new Intent(QuestionEight.this, QuestionList.class);
                startActivity(i);
            }
        });
        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionEight.this ,QuestionEight.class);
                startActivity(i);
            }
        });
        btP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionEight.this ,QuestionSeven.class);
                startActivity(i);
            }
        });
    }
}
