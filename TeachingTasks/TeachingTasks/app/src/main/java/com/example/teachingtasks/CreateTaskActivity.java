package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateTaskActivity extends AppCompatActivity {
    TextView username;
    Button taskNavButton, settingsNavButton, statisticsNavButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        taskNavButton = (Button) findViewById(R.id.taskNavButton);
        statisticsNavButton = (Button) findViewById(R.id.statisticsNavButton);
        settingsNavButton = (Button) findViewById(R.id.settingsNavButton);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        taskNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(CreateTaskActivity.this, v, username.getText().toString());
            }
        });

        statisticsNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(CreateTaskActivity.this, v, username.getText().toString());
            }
        });

        settingsNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NavButtonEventHandler().onClick(CreateTaskActivity.this, v, username.getText().toString());
            }
        });
    }
}
