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

            System.out.println("TaskSuccessActivity.java requires updated EXTRA's");

            String newQuestionObject = "";
            Random rand = new Random();

            switch (rand.nextInt(9)){
                case 0: newQuestionObject = "Zero"; break;
                case 1: newQuestionObject = "One"; break;
                case 2: newQuestionObject = "Two"; break;
                case 3: newQuestionObject = "Three"; break;
                case 4: newQuestionObject = "Four"; break;
                case 5: newQuestionObject = "Five"; break;
                case 6: newQuestionObject = "Six"; break;
                case 7: newQuestionObject = "Seven"; break;
                case 8: newQuestionObject = "Eight"; break;
                case 9: newQuestionObject = "Nine"; break;
            }

            Intent gameIntent = new Intent(TaskSuccessActivity.this, GameActivity.class);
            gameIntent.putExtra("EXTRA_USER", username.getText());
            gameIntent.putExtra("EXTRA_QUESTION", "Click the Number");
            gameIntent.putExtra("EXTRA_TASK_OBJECT", newQuestionObject);
            TaskSuccessActivity.this.startActivity(gameIntent);
        }
        return false;
    }
}
