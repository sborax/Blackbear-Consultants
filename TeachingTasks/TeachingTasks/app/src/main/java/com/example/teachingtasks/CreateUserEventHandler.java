package com.example.teachingtasks;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUserEventHandler {

    public void onClick(MainActivity mainActivity, DatabaseHelper mydb, EditText newUsername, EditText newPassword) {

        //Check password meets required guidelines (Caps, special char, length, etc)
        //Check database for duplicate username
        //Add new username/password combo to database

        /*
        Temp Function until above is done
         */

        System.out.println("Clicked Create User Button");
        String pass = newPassword.getText().toString();
        boolean invalidPass = false;

        if(!mydb.containsUser(newUsername.getText().toString())){

            if(isAcceptablePassword(pass)){

                mydb.addUser(newUsername.getText().toString(), newPassword.getText().toString());

                Intent userSelectIntent = new Intent(mainActivity.getBaseContext(),UserSelectActivity.class);
                mainActivity.startActivity(userSelectIntent);
            }
            else {
                invalidPass = true;
            }
        }
        else {
            Toast.makeText(mainActivity, "Duplicate username or Invalid password", Toast.LENGTH_LONG).show();
        }
        if(invalidPass){
            Toast.makeText(mainActivity, "Password must contain one Upper Case Letter, Number, and Special" + "" +
                                              "Character (@,$,!,?,...)",
                    Toast.LENGTH_LONG).show();
        }

    }

    private boolean isAcceptablePassword(String pass) {
        //True if pass length > 7 and contains at least 1 letter, number, and special char.
        //Else, false.

        System.out.println("Acceptance Pass: " + pass);

        if(pass.length() > 7){
            //Create regex match
            //If regex contains capital letter, number, and special char such as !,@,#,$,<,?... etc.
            //Then return true, else, return false

            System.out.println("Checking Acceptablility");
            return true;
        }
        return false;
    }

}
