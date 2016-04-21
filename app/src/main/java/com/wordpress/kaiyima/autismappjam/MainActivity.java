package com.wordpress.kaiyima.autismappjam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.app.Service;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener
{

//    TextView leaderboard;
    ProfileDBManager profileDBManager;
    EditText userNameInput;
    InputMethodManager imm;
//    HashMap<String, UserProfile> profileHashMap;
    ArrayList<UserProfile> profileList;
    ArrayList<String> userNameList;
    String userChoice;
    ListView userList;
    ListAdapter adapter;
    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_layout).requestFocus();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        enterButton = (Button)findViewById(R.id.enter_button);
        enterButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(!userChoice.isEmpty()) {
                            TextView welcomeTag = (TextView) findViewById(R.id.welcomeText);
                            welcomeTag.setText("Entering Magic World!");
                            Intent toNavigation = new Intent(MainActivity.this, NavigationListActivity.class);
                            toNavigation.putExtra("userName", userChoice);
                            startActivity(toNavigation);
                        }else{
                            Toast.makeText(MainActivity.this, "You need to choose a user first before entering the Magic World",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        userChoice = "";
//        leaderboard = (TextView) findViewById(R.id.leader_board);
        profileDBManager = new ProfileDBManager(this, null, null, 1);
        profileList = profileDBManager.databaseToList();
//        profileHashMap = profileDBManager.databaseToHashMap();

//        final Button addUserButton = (Button)findViewById(R.id.add_user_button);
//        final Button deleteUserButton = (Button)findViewById(R.id.delete_user_button);
        userNameInput = (EditText) findViewById(R.id.user_name_input);
        userNameInput.setOnEditorActionListener(this);
        imm = (InputMethodManager)this.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(userNameInput.getWindowToken(), 0);
        imm.showSoftInput(userNameInput, 0);

        userNameList = new ArrayList<>();
        for (UserProfile k : profileList){
            userNameList.add(k.get_username());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userNameList);
        userList = (ListView) findViewById(R.id.user_list);
        userList.setAdapter(adapter);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) (userList.getItemAtPosition(position));
                setUserChoice(selected);
                setEnterButton(selected);
            }
        });

//        showDB();
    }

//    public void showDB(){
//        String dbString = profileDBManager.databaseToString();
//        leaderboard.setText(dbString);
//        userNameInput.setText("");
//    }

    public void addButtonClicked(View view){
        String newUserName = userNameInput.getText().toString();
        if (!newUserName.isEmpty()) {
            if (!userNameList.contains(newUserName)) {
                UserProfile newUser = new UserProfile(newUserName);
                profileDBManager.addProfile(newUser);
                userNameList.add(newUserName);
//                refreshUserList();
                ((BaseAdapter) userList.getAdapter()).notifyDataSetChanged();
            }
            else{
                Toast.makeText(this, "Oops! We already have a player using your name! Please change a name and try again!",
                        Toast.LENGTH_LONG).show();
            }
        }
        imm.hideSoftInputFromWindow(userNameInput.getWindowToken(), 0);
        findViewById(R.id.main_layout).requestFocus();
//        showDB();
    }

    public void deleteButtonClicked(View view){
        String deleteUserName = userNameInput.getText().toString();
        if (!deleteUserName.isEmpty()) {
            profileDBManager.deleteProfile(deleteUserName);
            userNameList.remove(deleteUserName);
//            refreshUserList();
            ((BaseAdapter) userList.getAdapter()).notifyDataSetChanged();
        }
        imm.hideSoftInputFromWindow(userNameInput.getWindowToken(), 0);
        findViewById(R.id.main_layout).requestFocus();
//        showDB();
    }



    private void setUserChoice(String userName){
        userChoice = userName;
    }

    private void setEnterButton(String userName){
        enterButton.setText("Hi " + userName + "! Click me to enter!");
    }

//    private UserProfile stringToProfile(String userName){
//        for (UserProfile i : profileList){
//            if (i.get_username() == userName)
//                return i;
//        }
//    }

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

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//        if (i == EditorInfo.IME_ACTION_DONE){
//            String newUserName = userNameInput.getText().toString();
//            addUser(newUserName);
//            return true;
//        }
        return false;
    }
}
