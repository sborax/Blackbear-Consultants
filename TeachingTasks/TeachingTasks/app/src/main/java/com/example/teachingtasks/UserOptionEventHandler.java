package com.example.teachingtasks;

import android.content.Intent;

public class UserOptionEventHandler {

    public void onClick(UserSelectActivity userSelectActivity, String username) {

        Intent userLoginIntent = new Intent(userSelectActivity.getBaseContext(), LoginActivity.class);
        userLoginIntent.putExtra("EXTRA_USER", username);
        userSelectActivity.startActivity(userLoginIntent);
    }
}
