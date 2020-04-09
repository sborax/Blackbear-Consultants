package com.example.teachingtasks;

public class LoginEventHandler {
    public void onClick(LoginActivity loginActivity, String username, String passwordAttempt) {

        //Access database with username
        //Check if passwordAttempt == password from database
        //If yes, continue to Task screen logged in as username
        //Else, failed password attempt, ask them to re-enter

        RegisterUserDBHelper mydb = new RegisterUserDBHelper(loginActivity);


    }
}
