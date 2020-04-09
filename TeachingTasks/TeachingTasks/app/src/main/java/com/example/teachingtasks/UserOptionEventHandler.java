package com.example.teachingtasks;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.teachingtasks.RegisterUserDBHelper;
import com.example.teachingtasks.RegisterUserActivity;

public class UserOptionEventHandler {

    public void onClick(UserSelectActivity userSelectActivity, String username) {

        Intent userLoginIntent = new Intent(userSelectActivity.getBaseContext(), LoginActivity.class);
        userLoginIntent.putExtra("EXTRA_USER", username);
        userSelectActivity.startActivity(userLoginIntent);
    }
}
