package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class UserSelectActivity extends AppCompatActivity {

    //userOptions limits each device to 20 users
    Button editButton, searchButton;
    TextView userOptions[] = new TextView[20];
    int count = 0;
    DatabaseHelper mydb;
    String[] users;
    TextView[] selectedUsers = new TextView[20];
    TextView temp;  //Temp TextView to add userOptions to screen
    LinearLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        mydb = new DatabaseHelper(this);

        //Initial variables with UI components
        editButton = (Button) findViewById(R.id.addUsersButton);
        searchButton = (Button) findViewById(R.id.searchButton);
        constraintLayout = (LinearLayout) findViewById(R.id.userSelectionLayout);

        this.initializeUserOptions();

        //If no users found, Intent to RegisterUser Activity
        //Else, user(s) found, userOptions initialized, display userOptions
        if(users.length < 1) {
            Intent createUserIntent = new Intent(UserSelectActivity.this, MainActivity.class);
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

        Intent registerUserIntent = new Intent(UserSelectActivity.this,MainActivity.class);
        UserSelectActivity.this.startActivity(registerUserIntent);
    }

    private void editUserOption(){
        //Create new userOption to add to the userOptions array
        //Styles and formats new userOption

        searchButton.setText("Delete");

        //Create the Select button
        for(int k = 0; k < userOptions.length; k++){
            //Add the selection check bubble to each username

        }
    }

    private void initializeUserOptions() {
        //Grab users from Database
        //Initialize userOptions with users from Database

        users = mydb.getAllUsers();

        for(int m = 0; m < users.length; m++){

            if(users[m] == null){
                return;
            }

            temp = new TextView(UserSelectActivity.this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            temp.setLayoutParams(params);
            temp.setId(R.id.selectUser + m);
            temp.setText(users[m]);
            temp.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
            temp.setTextColor(0xFFFFFFFF);
            temp.setTypeface(Typeface.create("casual", Typeface.BOLD));
            temp.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    int[] ids = new int[20];
                    for(int k = 0; k < userOptions.length; k++){
                        ids[k] = userOptions[k].getId() - R.id.selectUser;
                    }
                    handleUserOptionClick(v, 0);
                }
            });

            constraintLayout.addView(temp, m);
            userOptions[m] = temp;
            System.out.println(userOptions[m].getId());
        }
    }

    private void handleUserOptionClick(View v, int id) {
        for (int k = 0; k < selectedUsers.length; k++){
            if(selectedUsers[k] == null){
                Toast.makeText(UserSelectActivity.this, "InProgress: " + v.findViewById(id),Toast.LENGTH_SHORT).show();
                selectedUsers[k] = v.findViewById(id-k);
                return;
            }
        }
    }

}
