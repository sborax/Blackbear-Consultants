package com.example.teachingtasks;

import android.widget.LinearLayout;
import android.view.View;
import android.widget.TextView;

public class DeleteUserEventHandler {

    public void onClick(UserSelectActivity userSelectActivity, RegisterUserDBHelper mydb, TextView[] selectedUsers, LinearLayout constraintLayout, View v) {


        String [] temp = mydb.getAllUsers();

        for(int k = 0; k < selectedUsers.length; k++){
            if(selectedUsers[k] == null){
                return;
            }

            mydb.deleteUser(selectedUsers[k].getText().toString());
            constraintLayout.removeView(v.findViewById(selectedUsers[k].getId()));
        }
    }
}
