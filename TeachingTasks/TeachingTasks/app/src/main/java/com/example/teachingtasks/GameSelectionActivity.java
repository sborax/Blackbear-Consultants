package com.example.teachingtasks;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameSelectionActivity extends AppCompatActivity {

    TextView category;
    Button leftArrow, rightArrow, startButton;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);

        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("EXTRA_USER"));


    }
}
