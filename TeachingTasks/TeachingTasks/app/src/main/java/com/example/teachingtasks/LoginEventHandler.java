package com.example.teachingtasks;

import android.content.Intent;
import android.widget.Toast;

public class LoginEventHandler {

    public void onClick(LoginActivity loginActivity, String username, String passwordAttempt) {

        RegisterUserDBHelper mydb = new RegisterUserDBHelper(loginActivity);

        if(mydb.userPasswordCheck(username, passwordAttempt)){
            //The user entered the right login information, bring them to game selection menu.
            System.out.println("Authentication successful. Going to Game Selection.");
            mydb.close();
            Intent gameSelectionIntent = new Intent(loginActivity.getBaseContext(), GameSelectionActivity.class);
            gameSelectionIntent.putExtra("EXTRA_USER", username);
            loginActivity.startActivity(gameSelectionIntent);
        }
        else{
            Toast.makeText(loginActivity, "Incorrect Password", Toast.LENGTH_SHORT).show();
            loginActivity.inputPassword.setText("");
        }
    }
}
