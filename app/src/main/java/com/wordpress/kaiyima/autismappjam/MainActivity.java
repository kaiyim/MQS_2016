package com.wordpress.kaiyima.autismappjam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    TextView leaderboard;
    ProfileDBManager profileDBManager;
    EditText userNameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button welcomeButton = (Button)findViewById(R.id.welcomeButton);

        welcomeButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView welcomeTag = (TextView)findViewById(R.id.welcomeTag);
                        welcomeTag.setText("Entering Magic World!");
                        Intent toNavigation = new Intent(MainActivity.this, NavigationListActivity.class);
                        startActivity(toNavigation);
                    }
                }
        );

        welcomeButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView welcomeTag = (TextView)findViewById(R.id.welcomeTag);
                        welcomeTag.setText("You are awesome!");
                        return true;
                    }
                }
        );

        leaderboard = (TextView) findViewById(R.id.leader_board);
        profileDBManager = new ProfileDBManager(this, null, null, 1);

        final Button addUserButton = (Button)findViewById(R.id.add_user_button);
        final Button deleteUserButton = (Button)findViewById(R.id.delete_user_button);
        userNameInput = (EditText) findViewById(R.id.user_name_input);
        showDB();
    }

    public void showDB(){
        String dbString = profileDBManager.databaseToString();
        leaderboard.setText(dbString);
        userNameInput.setText("");
    }

    public void addButtonClicked(View view){
        String newUserName = userNameInput.getText().toString();
        if (newUserName != null) {
            profileDBManager.addProfile(new UserProfile(newUserName));
        }
        showDB();
    }

    public void deleteButtonClicked(View view){
        String deleteUserName = userNameInput.getText().toString();
        if (deleteUserName != null) {
            profileDBManager.deleteProfile(deleteUserName);
        }
        showDB();
    }

    public void addUser(String userName){
        profileDBManager.addProfile(new UserProfile(userName));
    }

    public void deleteUser(String userName){
        profileDBManager.deleteProfile(userName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
