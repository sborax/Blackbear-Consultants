package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

public class GameActivity extends AppCompatActivity {

    TextView username;
    TextView question;
    TextView questionObject;
    HashMap<String, Button> taskObject = new HashMap<>();
    Button taskNavButton, statisticsNavButton, settingsNavButton;
    ConstraintLayout taskObjectLayout;
    NumberTask numberTask;
    ConstraintSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        numberTask = new NumberTask(this, UUID.randomUUID(), "Click the Number", new HashMap<String, Button>());

        taskObjectLayout = (ConstraintLayout) findViewById(R.id.taskObjectLayout);

        set = new ConstraintSet();
        set.clone(taskObjectLayout);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        question = (TextView) findViewById(R.id.taskQuestion);
        question.setText(getIntent().getStringExtra("EXTRA_QUESTION"));

        questionObject = (TextView) findViewById(R.id.taskQuestionObject);
        questionObject.setText(getIntent().getStringExtra("EXTRA_TASK_OBJECT"));

        taskObject = numberTask.getTaskObjects();

        tryToChangeConstraints();

        /*
        TEMP EVENT HANDLER
         */

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
        //Change constraints on taskObjects
        //Add them to the layout


        final String qObject = questionObject.getText().toString();

        //Going to need to check for mastery level to determine how many to include on screen
        //Mastery < 25% = 1 taskObject
        //Mastery < 50% = 2 taskObject
        //Mastery < 75% = 3 taskObject
        //Mastery < 100% = 4 taskObject
        //MAX = 4
        //MIN = 1
        int maxMastery =  1;

        //Create temp array for taskObjects that will be displayed
        //Add the questionObject to the array
        Iterator keySet = taskObject.keySet().iterator();
        final ArrayList<Button> tempObjects = new ArrayList<>();
        tempObjects.add(taskObject.get(qObject));

        //Add any random taskObjects necessary to match maxMastery
        while (keySet.hasNext() && tempObjects.size() != maxMastery){

            String temp = (String) keySet.next();
            if(!temp.equals(qObject))
                tempObjects.add(taskObject.get(temp));
        }

        //Randomize button locations by randomizing array index
        Collections.shuffle(tempObjects);

        //Loop through temp array to set layout of taskObjects
        for (int k = 0; k < maxMastery; k++){

            int currID = tempObjects.get(k).getId();
            int topID = ConstraintSet.PARENT_ID;
            int leftID = ConstraintSet.PARENT_ID;
            int leftConstraint = ConstraintSet.LEFT;

            //If this is the 2nd or 4th button, adjust constraints
            if (k % 2 != 0){

                int prevID = tempObjects.get(k-1).getId();
                leftID = prevID;
                leftConstraint = ConstraintSet.RIGHT;

                set.connect(prevID, ConstraintSet.RIGHT, currID, ConstraintSet.LEFT, 0);
            }

            //2x2 layout, so if we are on the second row, adjust constraints
            if(k > 1) {

                topID = tempObjects.get(k-2).getId();
                set.connect(topID, ConstraintSet.BOTTOM, currID, ConstraintSet.TOP, 0);
            }

            //If we only have 3 taskObjects to display, adjust constraints
            if(k == 2 && maxMastery == 3){

                int prevID = tempObjects.get(k-1).getId();
                set.connect(prevID, ConstraintSet.BOTTOM, currID, ConstraintSet.TOP, 0);
            }


            //Set all constraints
            set.connect(currID, ConstraintSet.TOP, topID, ConstraintSet.TOP, 0);
            set.connect(currID, ConstraintSet.LEFT, leftID, leftConstraint, 0);
            set.connect(currID, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
            set.connect(currID, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
            set.constrainHeight(currID, 180);
            set.constrainWidth(currID,250);


            //Set Event Handler and Text Styling
            tempObjects.get(k).setTypeface(Typeface.create("casual", Typeface.BOLD));
            tempObjects.get(k).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    new TaskObjectEventHandler().onClick(GameActivity.this, v, username.getText().toString(), qObject);
                    return false;
                }
            });


            //Add to layout and apply connections
            taskObjectLayout.addView(tempObjects.get(k));
            set.applyTo(taskObjectLayout);
        }

        //Ensure the last taskObject is constraint to the PARENT_RIGHT
        set.connect(tempObjects.get(maxMastery-1).getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.applyTo(taskObjectLayout);
    }
}