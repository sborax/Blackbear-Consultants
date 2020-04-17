package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class TaskSuccessActivity extends AppCompatActivity {

    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_success);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        if (e.getAction() == MotionEvent.ACTION_DOWN){

            System.out.println("TaskSuccessActivity.java requires updated EXTRA's");

            Intent gameIntent = new Intent(TaskSuccessActivity.this, GameActivity.class);
            gameIntent.putExtra("EXTRA_USER", username.getText());
            gameIntent.putExtra("EXTRA_QUESTION", "Click the Number");
            gameIntent.putExtra("EXTRA_TASK_OBJECT", "2");
            TaskSuccessActivity.this.startActivity(gameIntent);
        }
        return false;
    }
}
