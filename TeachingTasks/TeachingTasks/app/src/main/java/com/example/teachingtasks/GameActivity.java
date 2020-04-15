package com.example.teachingtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView username;
    View square;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));

        square = (View) findViewById(R.id.square);

        /*
        TEMP EVENT HANDLER
         */

        square.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Intent taskSuccessIntent = new Intent(GameActivity.this, TaskSuccessActivity.class);
                taskSuccessIntent.putExtra("EXTRA_USER", username.getText());
                GameActivity.this.startActivity(taskSuccessIntent);

                return false;
            }
        });





        Button taskNavButton = (Button) findViewById(R.id.taskNavButton);
        /*
        TEMP EVENT HANDLER
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
    }
}