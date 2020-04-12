package com.example.teachingtasks;

import android.content.Intent;

public class LoginEventHandler {
    public void onClick(LoginActivity loginActivity, String username, String passwordAttempt) {

        //Access database with username
        //Check if passwordAttempt == password from database
        //If yes, continue to Task screen logged in as username
        //Else, failed password attempt, ask them to re-enter

        RegisterUserDBHelper mydb = new RegisterUserDBHelper(loginActivity);



        //Change this to GameActivity once it's ready
        Intent statsIntent = new Intent(loginActivity.getBaseContext(), StatisticsActivity.class);
        loginActivity.startActivity(statsIntent);
    }
}
