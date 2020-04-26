package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class TaskSuccessActivity extends AppCompatActivity {

    TextView username;
    TextView taskObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_success);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        taskObject = (TextView) findViewById(R.id.taskObject);
        taskObject.setText(getIntent().getStringExtra("EXTRA_TASK_OBJECT"));
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        if (e.getAction() == MotionEvent.ACTION_DOWN){

            Intent gameIntent = new Intent(TaskSuccessActivity.this, GameActivity.class);
            gameIntent.putExtra("EXTRA_USER", username.getText());
            TaskSuccessActivity.this.startActivity(gameIntent);
        }
        return false;
    }
}
