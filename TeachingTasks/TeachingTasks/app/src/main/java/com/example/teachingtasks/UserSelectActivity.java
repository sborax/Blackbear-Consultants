package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.HashMap;
import java.util.Random;

public class UserSelectActivity extends AppCompatActivity {

    Button cancelButton, editButton, addButton;
    HashMap<Integer, EditText> userOptions = new HashMap<Integer, EditText>();
    RegisterUserDBHelper mydb;
    String[] users;
    EditText[] selectedUsers = new EditText[20];
    LinearLayout linearLayout;
    ScrollView userSelectScrollView;
    UserSelectActivity userSelectActivity = this;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        mydb = new RegisterUserDBHelper(this);

        //Initial variables with UI components
        editButton = (Button) findViewById(R.id.editButton);
        addButton = (Button) findViewById(R.id.addButton);
        linearLayout = (LinearLayout) findViewById(R.id.userSelectionLayout);
        userSelectScrollView = (ScrollView) findViewById(R.id.userSelectScrollView);

        this.initializeUserOptions();

        //If no users found, Intent to RegisterUser Activity
        //Else, user(s) found, userOptions initialized, display userOptions
        if(users[0] == null) {
            Intent createUserIntent = new Intent(UserSelectActivity.this, RegisterUserActivity.class);
            startActivity(createUserIntent);
        }

        /*
        Search / Delete Button
        --- Event Handler ---
         */
        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch (addButton.getText().toString()){
                    case "Delete": new DeleteUserEventHandler().onClick(UserSelectActivity.this, mydb, selectedUsers, linearLayout, v); break;
                    case "Add": addUserOption(); break;
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
                   case "Cancel": cancelUserEdit(v); break;
                   case "Edit": editButton.setText("Cancel"); addButton.setText("Delete"); break;
                   default: return;
               }
            }
        });
    }

    private void cancelUserEdit(View v) {
        //Deselect all users and change Cancel to Edit

        editButton.setText("Edit");
        addButton.setText("Add");

        for(int k = 0; k < selectedUsers.length; k++){
            if(selectedUsers[k] == null){
                k = selectedUsers.length;
            }
            else{
                selectedUsers[k].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {

                    }
                });
                selectedUsers[k].clearFocus();
                selectedUsers[k].setTextSize(48);
            }
        }
        selectedUsers = new EditText[20];
    }

    /*
    Add User Option
     */
    private void addUserOption(){
        //Set all of the stuff back to normal and then go to Register User

        Intent registerUserIntent = new Intent(UserSelectActivity.this, RegisterUserActivity.class);
        UserSelectActivity.this.startActivity(registerUserIntent);
    }

    private void initializeUserOptions() {
        //Grab users from Database
        //Initialize userOptions with users from Database

        users = mydb.getAllUsers();

        for(int m = 0; m < users.length; m++){

            if(users[m] == null){
                return;
            }

            //Create a Unique ID for each userOption
            Random rand = new Random();
            int id = rand.nextInt(9999999);

            //Add the user text to userOption
            userOptions.put(id, new EditText(userSelectActivity));

            //Add attributes to the user text
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            userOptions.get(id).setLayoutParams(params);
            userOptions.get(id).setId(id);
            userOptions.get(id).setText(users[m]);
            userOptions.get(id).setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
            userOptions.get(id).setTextColor(0xFFFFFFFF);
            userOptions.get(id).setTypeface(Typeface.create("casual", Typeface.BOLD));
            userOptions.get(id).setInputType(InputType.TYPE_NULL);

            /*
            User Options
            --- EventHandler ---
             */
            userOptions.get(id).setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    switch (editButton.getText().toString()) {
                        case "Cancel":
                            handleUserOptionClick(userOptions.get(v.getId()));
                            break;
                        case "Edit":
                            new UserOptionEventHandler().onClick(userSelectActivity, userOptions.get(v.getId()).getText().toString());
                            break;
                    }
                    return false;
                }
            });

            //Add user text to the view
            linearLayout.addView(userOptions.get(id), m);
        }
    }

    private void handleUserOptionClick(View v) {
        //Add user to selectedUsers

        for(int j = 0; j < selectedUsers.length; j++){

            //If empty slot found, insert user into selectedUsers, return
            if(selectedUsers[j] == null){

                selectedUsers[j] = userOptions.get(v.getId());
                selectedUsers[j].setTextSize(52);
                selectedUsers[j].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        v.requestFocus();
                    }
                });
                return;
            }
        }
    }
}
