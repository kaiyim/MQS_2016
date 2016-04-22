package com.wordpress.kaiyima.autismappjam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuestionList extends AppCompatActivity {

    ListView lv;
    String[] questions = {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5",
            "Question 6", "Question 7", "Question 8", "Question 9", "Question 10", "Question 11",
            "Question 12", "Question 13", "Question 14", "Question 15", "Question 16", "Question 17",
            "Question 18", "Question 19", "Question 20", "Question 21", "Question 22", "Question 23",
            "Question 24", "Question 25", "Question 26", "Question 27", "Question 28", "Question 29",
            "Question 30", "Question 31", "Question 32", "Question 33", "Question 34", "Question 35",
            "Question 36", "Question 37", "Question 38", "Question 39"};
    ArrayAdapter<String> adapter;
    String userName;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);
        Bundle userData = getIntent().getExtras();
        if(userData != null){
            userName = userData.getString("userName");
        }

        lv = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, questions);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i = new Intent(QuestionList.this, QuestionOne.class);
                    startActivity(i);
                }else if(position==1) {
                    Intent i = new Intent(QuestionList.this, QuestionTwo.class);
                    startActivity(i);
                }else if(position==2) {
                    Intent i = new Intent(QuestionList.this, QuestionThree.class);
                    startActivity(i);
                }else if(position==3) {
                    Intent i = new Intent(QuestionList.this, QuestionFour.class);
                    startActivity(i);
                }else if(position==4) {
                    Intent i = new Intent(QuestionList.this, QuestionFive.class);
                    startActivity(i);
                }else if(position==5) {
                    Intent i = new Intent(QuestionList.this, QuestionSix.class);
                    startActivity(i);
                }else if(position==6) {
                    Intent i = new Intent(QuestionList.this, QuestionSeven.class);
                    startActivity(i);
                }else if(position==7) {
                    Intent i = new Intent(QuestionList.this, QuestionEight.class);
                    startActivity(i);
                }else {
                    Intent i = new Intent(QuestionList.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }


}
