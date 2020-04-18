package com.example.teachingtasks;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class TaskObjectEventHandler {

    public void  onClick(GameActivity gameActivity, View v, String username, String questionObject) {

        Button curr = (Button) v.findViewById(v.getId());

        if(curr.getText().toString().equals(questionObject)){
            Intent taskSuccessIntent = new Intent(gameActivity, TaskSuccessActivity.class);
            taskSuccessIntent.putExtra("EXTRA_USER", username);
            taskSuccessIntent.putExtra("EXTRA_TASK_OBJECT", questionObject);
            gameActivity.startActivity(taskSuccessIntent);
        }
        else {
            Toast.makeText(gameActivity, "Incorrect Answer", Toast.LENGTH_LONG).show();
        }
    }
}
