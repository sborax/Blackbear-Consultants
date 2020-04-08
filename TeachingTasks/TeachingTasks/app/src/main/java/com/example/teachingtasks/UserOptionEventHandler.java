package com.example.teachingtasks;

import android.content.Intent;
import android.widget.EditText;

import com.example.teachingtasks.RegisterUserDBHelper;
import com.example.teachingtasks.RegisterUserActivity;

public class UserOptionEventHandler {

    public void onClick(UserSelectActivity userSelectActivity) {

        Intent userLoginIntent = new Intent(userSelectActivity.getBaseContext(), LoginActivity.class);
        userSelectActivity.startActivity(userLoginIntent);
    }
}
