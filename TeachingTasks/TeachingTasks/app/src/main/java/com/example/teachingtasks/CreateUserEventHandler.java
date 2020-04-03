package com.example.teachingtasks;

import android.content.Intent;
import android.widget.EditText;

public class CreateUserEventHandler {

    public void onClick(MainActivity mainActivity, EditText newUsername, EditText newPassword) {

        //Check password meets required guidelines (Caps, special char, length, etc)
        //Check database for duplicate username
        //Add new username/password combo to database

        /*
        Temp Function until above is done
         */

        Intent userSelectIntent = new Intent(mainActivity.getBaseContext(),UserSelectActivity.class);
        mainActivity.startActivity(userSelectIntent);
    }
}
