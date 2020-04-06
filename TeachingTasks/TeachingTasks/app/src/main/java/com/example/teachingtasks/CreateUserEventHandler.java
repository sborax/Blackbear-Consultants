package com.example.teachingtasks;

import android.content.Intent;
import android.widget.EditText;

public class CreateUserEventHandler {

    public void onClick(MainActivity mainActivity, DatabaseHelper mydb, EditText newUsername, EditText newPassword) {

        //Check password meets required guidelines (Caps, special char, length, etc)
        //Check database for duplicate username
        //Add new username/password combo to database

        /*
        Temp Function until above is done
         */

        String pass = newPassword.getText().toString();

        if(!mydb.containsUser(newUsername.getText().toString())){

            if(isAcceptablePassword(pass)){

                mydb.addUser(newUsername.getText().toString(), newPassword.getText().toString());

                Intent userSelectIntent = new Intent(mainActivity.getBaseContext(),UserSelectActivity.class);
                mainActivity.startActivity(userSelectIntent);
            }
        }

    }

    private boolean isAcceptablePassword(String pass) {
        //True if pass length > 8 and contains at least 1 letter, number, and special char.
        //Else, false.

        if(pass.length() > 8){
            //Create regex match
            //If regex contains capital letter, number, and special char such as !,@,#,$,<,?... etc.
            //Then return true, else, return false

            return true;
        }
    }

}
