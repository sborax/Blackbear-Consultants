package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class CreateTaskActivity extends AppCompatActivity {
    Button taskNavButton, settingsNavButton, statisticsNavButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
    }

//        taskNavButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
//            }
//        });
//
//        statisticsNavButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
//            }
//        });
//
//        settingsNavButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                new NavButtonEventHandler().onClick(EditTaskActivity.this, v, username.getText().toString());
//            }
//        });
}
