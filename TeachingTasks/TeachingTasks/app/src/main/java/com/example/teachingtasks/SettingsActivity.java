package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        if (e.getAction() == MotionEvent.ACTION_DOWN){

            Intent userSelectIntent = new Intent(SettingsActivity.this, UserSelectActivity.class);
            SettingsActivity.this.startActivity(userSelectIntent);
        }
        return false;
    }
}
