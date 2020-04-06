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
import android.widget.TextView;

public class UserSelectActivity extends AppCompatActivity {

    //userOptions limits each device to 20 users
    Button editButton, searchButton;
    TextView userOptions[] = new TextView[20];
    int count = 0;

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

        /*
        FIX THE IF STATEMENT AFTER TESTING IS DONE
        COUNT < 1
         */
        if(count < 0) {
            Intent createUserIntent = new Intent(UserSelectActivity.this, MainActivity.class);
            startActivity(createUserIntent);
        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count < 20) {
                    addUserOption();
                }
                else{
                    //Error message for max users reached
                }
            }
        });
    }

    private void addUserOption(){
        //Create new userOption to add to the userOptions array
        //Styles and formats new userOption

        TextView temp = new TextView(this);

        LinearLayout constraintLayout = (LinearLayout) findViewById(R.id.userSelectionLayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        temp.setLayoutParams(params);
        temp.setText("tempUser");
        temp.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
        temp.setTextColor(0xFFFFFFFF);
        temp.setTypeface(Typeface.create("casual", Typeface.BOLD), Typeface.BOLD);

        constraintLayout.addView(temp);
        userOptions[count] = temp;
        count++;

    }

    private void initializeUserOptions() {
        //Grab users from Database
        //Initialize userOptions with users from Database
//        userOptions[count] = (TextView) findViewById(R.id.userSelectOption);
//        count++;
    }
}
