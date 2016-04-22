package com.wordpress.kaiyima.autismappjam;

import android.content.Intent;
import android.content.pm.InstrumentationInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuestionOne extends AppCompatActivity {

    TextView tv;
    Button btA;
    Button btB;
    Button btR;
    Button btP;
    Button btN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        tv = (TextView) findViewById(R.id.Q1answer);
        btA = (Button) findViewById(R.id.Q1buttonA);
        btB = (Button) findViewById(R.id.Q1buttonB);
        btR = (Button) findViewById(R.id.Q1return);
        btP = (Button) findViewById(R.id.Q1pre);
        btN = (Button) findViewById(R.id.Q1nex);

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
                Intent i = new Intent(QuestionOne.this ,QuestionList.class);
                startActivity(i);
            }
        });
        btN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuestionOne.this ,QuestionTwo.class);
                startActivity(i);
            }
        });


    }
}
