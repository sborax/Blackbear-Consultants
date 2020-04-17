package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

public class GameActivity extends AppCompatActivity {

    TextView username;
    TextView question;
    TextView questionObject;
    ArrayList<Button> taskObject = new ArrayList<>();
    Button taskNavButton, statisticsNavButton, settingsNavButton;
    ConstraintLayout taskObjectLayout;
    NumberTask numberTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        numberTask = new NumberTask(this, UUID.randomUUID(), "Click the Number", new ArrayList<Button>());

        taskObjectLayout = (ConstraintLayout) findViewById(R.id.taskObjectLayout);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        question = (TextView) findViewById(R.id.taskQuestion);
        question.setText(getIntent().getStringExtra("EXTRA_QUESTION"));

        questionObject = (TextView) findViewById(R.id.taskQuestionObject);
        questionObject.setText(getIntent().getStringExtra("EXTRA_TASK_OBJECT"));

        Button temp = new Button(this);
        taskObject.add(temp);
        temp.setId(taskObject.size()*1000);
        taskObjectLayout.addView(taskObject.get(taskObject.size()-1));

        if(questionObject.getText().toString().equals("2")){
            tryToChangeConstraints();
        }

        /*
        TEMP EVENT HANDLER
         */

        taskObject.get(taskObject.size()-1).setOnTouchListener(new View.OnTouchListener() {
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

        int idOne = taskObject.get(taskObject.size()-1).getId();

        ConstraintSet topSet = new ConstraintSet();
        topSet.clone(taskObjectLayout);

        topSet.connect(idOne, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        topSet.connect(idOne, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        topSet.connect(idOne, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);

        Button taskObjTwo = new Button(this);
        taskObjTwo.setId((taskObject.size()+1)*1000);

        topSet.connect(taskObjTwo.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        topSet.connect(taskObjTwo.getId(), ConstraintSet.LEFT, idOne, ConstraintSet.RIGHT, 0);
        topSet.connect(taskObjTwo.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        topSet.connect(taskObjTwo.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        topSet.constrainHeight(taskObjTwo.getId(),120);
        topSet.constrainWidth(taskObjTwo.getId(), 220);

        topSet.connect(idOne, ConstraintSet.RIGHT, taskObjTwo.getId(), ConstraintSet.LEFT, 0);

        taskObject.add(taskObjTwo);


        int idThree = taskObject.size()+1*1000;
        Button taskObjThree = new Button(this);
        taskObjThree.setId(idThree);

        topSet.connect(idThree, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        topSet.connect(idThree, ConstraintSet.TOP, idOne, ConstraintSet.BOTTOM, 0);
        topSet.connect(idThree, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        topSet.connect(idThree, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        topSet.constrainHeight(taskObjThree.getId(),120);
        topSet.constrainWidth(taskObjThree.getId(), 220);

        taskObjectLayout.addView(taskObjThree);
        taskObjectLayout.addView(taskObjTwo);
        topSet.applyTo(taskObjectLayout);
    }
}