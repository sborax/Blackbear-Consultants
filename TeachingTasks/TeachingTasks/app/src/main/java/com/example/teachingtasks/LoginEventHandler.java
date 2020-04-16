package com.example.teachingtasks;

import android.content.Intent;
import android.widget.Toast;

public class LoginEventHandler {

    public void onClick(LoginActivity loginActivity, String username, String passwordAttempt) {

        RegisterUserDBHelper mydb = new RegisterUserDBHelper(loginActivity);

        if(mydb.userPasswordCheck(username, passwordAttempt)){

            //Change this to GameSelectionActivity once it's ready
            System.out.println("LoginEventHandler.java requires access to GameSelectionActivity...");
            System.out.println("LoginEventHandler.java requires a popup for incorrect passwords...");

            Intent gameIntent = new Intent(loginActivity.getBaseContext(), GameActivity.class);
            gameIntent.putExtra("EXTRA_USER", username);
            loginActivity.startActivity(gameIntent);
        }
        else{
            Toast.makeText(loginActivity, "Incorrect Password", Toast.LENGTH_SHORT).show();
            loginActivity.inputPassword.setText("");
        }
    }
}
