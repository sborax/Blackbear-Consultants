package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UserSelectActivity extends AppCompatActivity {

    //userOptions limits each device to 20 users
    Button editButton, searchButton;
    EditText userOptions[] = new EditText[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        //Initial variables with UI components
        editButton = (Button) findViewById(R.id.editUsersButton);
        searchButton = (Button) findViewById(R.id.searchButton);


        initializeUserOptions(userOptions);
        //If no users found, Intent to CreateUser Activity
        //Else, user(s) found, userOptions initialized, display userOptions

        if(userOptions.length < 1){
            Intent createUserIntent = new Intent(UserSelectActivity.this,MainActivity.class);
            startActivity(createUserIntent);
        }

    }

    private void initializeUserOptions(EditText[] userOptions) {
        //Grab users from Database
        //Initialize userOptions with users from Database

        userOptions[0] = (EditText) findViewById(R.id.userNameOption);
    }
}
