package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Random;

public class UserSelectActivity extends AppCompatActivity {

    //userOptions limits each device to 20 users
    Button editButton, searchButton;
    HashMap<Integer, EditText> userOptions = new HashMap<Integer, EditText>();
    int count = 0;
    RegisterUserDBHelper mydb;
    String[] users;
    EditText[] selectedUsers = new EditText[20];
    EditText temp;                                    //Temp TextView to add userOptions to screen
    LinearLayout constraintLayout;
    UserSelectActivity userSelectActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        mydb = new RegisterUserDBHelper(this);

        //Initial variables with UI components
        editButton = (Button) findViewById(R.id.cancelButton);
        searchButton = (Button) findViewById(R.id.searchButton);
        constraintLayout = (LinearLayout) findViewById(R.id.userSelectionLayout);

        this.initializeUserOptions();

        //If no users found, Intent to RegisterUser Activity
        //Else, user(s) found, userOptions initialized, display userOptions
        if(users.length < 1) {
            Intent createUserIntent = new Intent(UserSelectActivity.this, RegisterUserActivity.class);
            startActivity(createUserIntent);
        }

        /*
        Search / Delete Button
        --- Event Handler ---
         */
        searchButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch (searchButton.getText().toString()){
                    case "Delete": new DeleteUserEventHandler().onClick(UserSelectActivity.this, mydb, selectedUsers, constraintLayout, v); break;
                    //case "": new SearchUsersEventHandler().onClick(mydb, searchButton.getTextORSOMETHING().toString()); break;
                }
            }
        });

        /*
        Edit / Add Button
        --- Event Handler ---
         */
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If clicked, swap the Text and do appropriate behavior.
               switch (editButton.getText().toString()){
                   case "Add": addUserOption(); break;
                   case "Edit": editButton.setText("Add"); editUserOption(); break;
                   default: return;
               }
            }
        });
    }

    /*
    Add User Option
     */
    private void addUserOption(){
        //Set all of the stuff back to normal and then go to Register User

        Intent registerUserIntent = new Intent(UserSelectActivity.this, RegisterUserActivity.class);
        UserSelectActivity.this.startActivity(registerUserIntent);
    }

    private void editUserOption(){
        //Create new userOption to add to the userOptions array
        //Styles and formats new userOption

        searchButton.setText("Delete");

        //Create the Select button
//        for(int k = 0; k < userOptions.length; k++){
            //Add the selection check bubble to each username

//        }
    }

    private void initializeUserOptions() {
        //Grab users from Database
        //Initialize userOptions with users from Database

        users = mydb.getAllUsers();

        for(int m = 0; m < users.length; m++){

            if(users[m] == null){
                return;
            }

//            temp = new EditText(userSelectActivity);
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            params.gravity = Gravity.CENTER;
//            temp.setLayoutParams(params);
//            temp.setId(R.id.selectUser + m);
//            temp.setText(users[m]);
//            temp.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
//            temp.setTextColor(0xFFFFFFFF);
//            temp.setTypeface(Typeface.create("casual", Typeface.BOLD));
//            temp.setInputType(InputType.TYPE_NULL);
//            temp.setOnClickListener(new View.OnClickListener(){

            Random rand = new Random();
            int id = rand.nextInt(9999999);

            userOptions.put(id, new EditText(userSelectActivity));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            userOptions.get(id).setLayoutParams(params);
            userOptions.get(id).setId(id);
            userOptions.get(id).setText(users[m]);
            userOptions.get(id).setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
            userOptions.get(id).setTextColor(0xFFFFFFFF);
            userOptions.get(id).setTypeface(Typeface.create("casual", Typeface.BOLD));
            userOptions.get(id).setInputType(InputType.TYPE_NULL);
            userOptions.get(id).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    System.out.println("Temp Values: " + userOptions.get(v.getId()).getText().toString());
                    EditText tempUser = (EditText) findViewById()
                    new UserOptionEventHandler().onClick(userSelectActivity);
                }
            });

            constraintLayout.addView(userOptions.get(id), m);
        }
    }

    private void handleUserOptionClick(View v, int id) {
        for (int k = 0; k < selectedUsers.length; k++){
            if(selectedUsers[k] == null){
                selectedUsers[k] = v.findViewById(id-k);
                return;
            }
        }
    }

}
