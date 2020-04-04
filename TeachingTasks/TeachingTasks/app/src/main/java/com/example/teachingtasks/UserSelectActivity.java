package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UserSelectActivity extends AppCompatActivity {

    //userOptions limits each device to 20 users
    Button editButton, searchButton;
    TextView userOptions[] = new TextView[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);

        //Initial variables with UI components
        editButton = (Button) findViewById(R.id.editUsersButton);
        searchButton = (Button) findViewById(R.id.searchButton);


        this.initializeUserOptions();
        //If no users found, Intent to CreateUser Activity
        //Else, user(s) found, userOptions initialized, display userOptions

        if(userOptions.length < 1) {
            Intent createUserIntent = new Intent(UserSelectActivity.this, MainActivity.class);
            startActivity(createUserIntent);
        }
        final TextView temp = new TextView(this);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(userOptions[0]);

                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.userSelectLayout);
                temp.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                temp.setText("tempUser");
                temp.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
                temp.setTextColor(0xFFFFFFFF);
                temp.setPadding(0,24,0,0);
                constraintLayout.addView(temp);
                userOptions[1] = temp;
            }
        });
    }

    private void initializeUserOptions() {
        //Grab users from Database
        //Initialize userOptions with users from Database
        userOptions[0] = (TextView) findViewById(R.id.userSelectOption);
    }
}
