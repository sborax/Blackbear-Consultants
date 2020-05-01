package com.example.teachingtasks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateTaskActivity extends AppCompatActivity {
    TextView username;
    Button taskNavButton, settingsNavButton, statisticsNavButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        
        taskNavButton = (Button) findViewById(R.id.taskNavButton);
        statisticsNavButton = (Button) findViewById(R.id.statisticsNavButton);
        settingsNavButton = (Button) findViewById(R.id.settingsNavButton);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));



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
