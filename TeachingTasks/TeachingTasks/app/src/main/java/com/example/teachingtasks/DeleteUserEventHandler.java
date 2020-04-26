package com.example.teachingtasks;

import android.content.Intent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View;

import java.util.ArrayList;

public class DeleteUserEventHandler {

    public void onClick(UserSelectActivity userSelectActivity, ArrayList<EditText> selectedUsers, LinearLayout constraintLayout, View v) {

        RegisterUserDBHelper mydb = new RegisterUserDBHelper(userSelectActivity);

        ArrayList<String> temp = mydb.getAllUsers();

        for(int k = 0; k < selectedUsers.size(); k++){
            if(selectedUsers.get(k) == null){
                return;
            }

            mydb.deleteUser(userSelectActivity, selectedUsers.get(k).getText().toString());
            constraintLayout.removeView(v.findViewById(selectedUsers.get(k).getId()));
        }

        mydb.close();
        Intent userSelectIntent = new Intent(userSelectActivity.getBaseContext(), UserSelectActivity.class);
        userSelectActivity.startActivity(userSelectIntent);
    }
}
