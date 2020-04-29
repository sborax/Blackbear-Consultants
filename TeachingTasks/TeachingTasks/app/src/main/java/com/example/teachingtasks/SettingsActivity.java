package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    TextView username, customTask, mute, logout;
    Button taskNavButton, settingsNavButton, statisticsNavButton, customTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        customTask = (TextView) findViewById(R.id.customTaskButton);
        mute = (TextView) findViewById(R.id.mute);
        logout = (TextView) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent userSelectIntent = new Intent(SettingsActivity.this, UserSelectActivity.class);
                SettingsActivity.this.startActivity(userSelectIntent);
            }
        });

        taskNavButton = (Button) findViewById(R.id.taskNavButton);
        statisticsNavButton = (Button) findViewById(R.id.statisticsNavButton);
        settingsNavButton = (Button) findViewById(R.id.settingsNavButton);

        customTaskButton = (Button) findViewById(R.id.customTaskButton);
        customTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createUserIntent = new Intent(SettingsActivity.this, EditTaskActivity.class);
                startActivity(createUserIntent);
            }
        });

        taskNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(SettingsActivity.this, v, username.getText().toString());
            }
        });

        statisticsNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(SettingsActivity.this, v, username.getText().toString());
            }
        });

        settingsNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(SettingsActivity.this, v, username.getText().toString());
            }
        });
    }
}
