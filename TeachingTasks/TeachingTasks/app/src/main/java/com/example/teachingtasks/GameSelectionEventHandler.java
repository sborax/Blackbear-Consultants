package com.example.teachingtasks;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameSelectionEventHandler {


    public void onClick(RegisterUserActivity mainActivity, EditText newUsername, EditText newPassword) {

        //Check password meets required guidelines (Caps, special char, length, etc)
        //Check database for duplicate username
        //Add new username/password combo to database

        /*
        Temp Function until above is done
         */

        String pass = newPassword.getText().toString();
        boolean invalidPass = false;

        //If the username doesn't exist in the database already, check the password
        StatisticsDBHelper mydb = new StatisticsDBHelper(mainActivity);

        if(!mydb.containsUser(newUsername.getText().toString())){

            //If the password is acceptable, add the user
            if(isAcceptablePassword(pass)){

                createUser(mainActivity, newUsername.getText().toString(), newPassword.getText().toString());
                mydb.close();
                Intent userSelectIntent = new Intent(mainActivity.getBaseContext(),UserSelectActivity.class);
                mainActivity.startActivity(userSelectIntent);
            }
            //Else, the password was not acceptable
            else {
                invalidPass = true;
            }
        }
        else {
            Toast.makeText(mainActivity, "Duplicate username or Invalid password", Toast.LENGTH_LONG).show();
        }
        if(invalidPass){
            Toast.makeText(mainActivity, "Password must contain one Upper Case Letter, Number, and Special" + "" +
                                              "Character (@,$,!,?,...)" + " and a length of eight.",
                    Toast.LENGTH_LONG).show();
        }

    }

    private void createUser(RegisterUserActivity mainActivity, String username, String password) {
        //User was accepted, create the user

        GameCategoryDBHelper gameCategoryDB = new GameCategoryDBHelper(mainActivity);
        GameTaskDBHelper gameTasksDB = new GameTaskDBHelper(mainActivity);
        gameTasksDB.initializeTaskObjects(username);
        RegisterUserDBHelper registerUserDB = new RegisterUserDBHelper(mainActivity);

        registerUserDB.addUser(username, password);

        gameCategoryDB.addCategory(username, "Matching");

        gameCategoryDB.close();
        gameTasksDB.close();
        registerUserDB.close();
        return;
    }

    private boolean isAcceptablePassword(String pass) {
        //True if pass length > 7 and contains at least 1 letter, number, and special char.
        //Else, false.

        if(pass.length() > 7){
            //Create regex pattern to match
            //If pass contains capital letter, number, and special char such as !,@,#,$,?... etc.
            //Then return true, else, return false

            Pattern passPattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,24}$");
            Matcher matcher = passPattern.matcher(pass);

            return matcher.matches();
        }
        return false;
    }

}
