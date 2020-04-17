package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView username;
    TextView question;
    TextView questionObject;
    Button taskObject;
    Button taskNavButton, statisticsNavButton, settingsNavButton;
    GridLayout taskObjectLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        taskObjectLayout = (GridLayout) findViewById(R.id.taskObjectLayout);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        question = (TextView) findViewById(R.id.taskQuestion);
        question.setText(getIntent().getStringExtra("EXTRA_QUESTION"));

        questionObject = (TextView) findViewById(R.id.taskQuestionObject);
        questionObject.setText(getIntent().getStringExtra("EXTRA_TASK_OBJECT"));

        taskObject = new Button(this);
        taskObjectLayout.addView(taskObject);

        if(questionObject.getText().toString().equals("2")){
            tryToChangeConstraints();
        }

        /*
        TEMP EVENT HANDLER
         */

        taskObject.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent taskSuccessIntent = new Intent(GameActivity.this, TaskSuccessActivity.class);
                taskSuccessIntent.putExtra("EXTRA_USER", username.getText());
                GameActivity.this.startActivity(taskSuccessIntent);

                return false;
            }
        });





        taskNavButton = (Button) findViewById(R.id.taskNavButton);
        statisticsNavButton = (Button) findViewById(R.id.statisticsNavButton);
        settingsNavButton = (Button) findViewById(R.id.settingsNavButton);
        /*
        TEMP EVENT HANDLERS
         */

        taskNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent loginIntent = new Intent(GameActivity.this, LoginActivity.class);
                loginIntent.putExtra("EXTRA_USER", username.getText());
                GameActivity.this.startActivity(loginIntent);
                return false;
            }
        });

        statisticsNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent statsIntent = new Intent(GameActivity.this, StatisticsActivity.class);
                GameActivity.this.startActivity(statsIntent);
                return false;
            }
        });

        settingsNavButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent settingsIntent = new Intent(GameActivity.this, SettingsActivity.class);
                GameActivity.this.startActivity(settingsIntent);
                return false;
            }
        });
    }

    private void tryToChangeConstraints() {
        //Change constraints on taskObject
        //Create a duplicate to taskObject with a different text and/or background

        Button taskObjTwo = new Button(this);
//        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
//        params.startToEnd = taskObject.getRight();
//        params.endToEnd = taskObjectLayout.getRight();
//        params.bottomToBottom = taskObjectLayout.getBottom();
//        params.topToTop = taskObjectLayout.getTop();
//        taskObjTwo.setLayoutParams(params);

//        params = (ConstraintLayout.LayoutParams) taskObject.getLayoutParams();
//        params.endToStart = 0;
//        taskObject.setLayoutParams(params);

        taskObjectLayout.addView(taskObjTwo);
    }
}