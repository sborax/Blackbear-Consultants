package com.example.teachingtasks;

import android.content.Intent;
import android.widget.Toast;

public class GameSelectionActivityEventHandler {
    public void onClick(GameSelectionActivity gameSelectionActivity, String username) {
//        RegisterUserDBHelper mydb = new RegisterUserDBHelper(gameSelectionActivity);

            //Change this to GameSelectionActivity once it's ready
            System.out.println("Loading Game");

//            mydb.close();
            Intent gameIntent = new Intent(gameSelectionActivity.getBaseContext(), GameActivity.class);
            gameIntent.putExtra("EXTRA_USER", username);
            gameSelectionActivity.startActivity(gameIntent);
    }
}
