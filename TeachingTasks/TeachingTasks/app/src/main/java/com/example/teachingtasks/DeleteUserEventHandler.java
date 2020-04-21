package com.example.teachingtasks;

import android.content.Intent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.View;

import java.util.ArrayList;

public class DeleteUserEventHandler {

    public void onClick(UserSelectActivity userSelectActivity, RegisterUserDBHelper mydb, ArrayList<EditText> selectedUsers, LinearLayout constraintLayout, View v) {


        ArrayList<String> temp = mydb.getAllUsers();

        for(int k = 0; k < selectedUsers.size(); k++){
            if(selectedUsers.get(k) == null){
                return;
            }

            mydb.deleteUser(selectedUsers.get(k).getText().toString());
            constraintLayout.removeView(v.findViewById(selectedUsers.get(k).getId()));
        }

        Intent userSelectIntent = new Intent(userSelectActivity.getBaseContext(), UserSelectActivity.class);
        userSelectActivity.startActivity(userSelectIntent);
    }
}
