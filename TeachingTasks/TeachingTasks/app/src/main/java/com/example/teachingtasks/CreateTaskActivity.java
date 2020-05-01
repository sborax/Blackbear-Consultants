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
    TextView username, desc1, desc2;
    ImageView image1, image2;
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

        desc1 = (TextView) findViewById(R.id.text_object1);
        desc2 = (TextView) findViewById(R.id.text_object2);

        desc1.setText("Click on " + getIntent().getStringExtra("NEW_IMAGE_DESC"));

        byte[] byteArray = getIntent().getByteArrayExtra("NEW_IMAGE");
        image1 = (ImageView) findViewById(R.id.image1);
        image1.setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));

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
