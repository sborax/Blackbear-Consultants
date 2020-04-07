package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText newUsername, newPassword;
    CheckBox showPass;
    Button createButton;
    DatabaseHelper mydb;
    String[] users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mydb = new DatabaseHelper(this);

        users = mydb.getAllUsers();

        //Sets the initial Content View
        setContentView(R.layout.activity_main);

        //Assign variables to UI components
        newUsername = (EditText) findViewById(R.id.newUserNameEditText);
        newPassword = (EditText) findViewById(R.id.newPasswordEditText);
        showPass = (CheckBox) findViewById(R.id.showPasswordCheckBox);
        createButton = (Button) findViewById(R.id.createUserButton);

        //Easy quick fix to making login default screen
        //Must change the classes around
        //Rename this class to RegisterUserActivity
        Button addButton = (Button) findViewById(R.id.addUsersButton);
        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent selectUserIntent = new Intent(MainActivity.this,UserSelectActivity.class);
                MainActivity.this.startActivity(selectUserIntent);
            }
        });


        //Set EventHandlers
        createButton.setOnClickListener(this);
        showPass.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        //Checks the ID and calls the appropriate EventHandler
        switch (v.getId()){
            case R.id.showPasswordCheckBox: new ShowPassEventHandler().onCheck(showPass, newPassword); break;
            case R.id.createUserButton: new CreateUserEventHandler().onClick(this, mydb, newUsername, newPassword); break;
            default: return;
        }
    }
}
