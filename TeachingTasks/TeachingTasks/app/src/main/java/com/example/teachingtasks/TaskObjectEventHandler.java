package com.example.teachingtasks;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class TaskObjectEventHandler {

    public void  onClick(GameActivity gameActivity, View v, String username, String questionObject) {

        Button curr = (Button) v.findViewById(v.getId());

        String qObject = "";

        switch (questionObject){
            case "Zero": qObject = "0"; break;
            case "One": qObject = "1"; break;
            case "Two": qObject = "2"; break;
            case "Three": qObject = "3"; break;
            case "Four": qObject = "4"; break;
            case "Five": qObject = "5"; break;
            case "Six": qObject = "6"; break;
            case "Seven": qObject = "7"; break;
            case "Eight": qObject = "8"; break;
            case "Nine": qObject = "9"; break;
        }

        if(curr.getText().toString().equals(qObject)){
            Intent taskSuccessIntent = new Intent(gameActivity, TaskSuccessActivity.class);
            taskSuccessIntent.putExtra("EXTRA_USER", username);
            taskSuccessIntent.putExtra("EXTRA_TASK_OBJECT", qObject);
            gameActivity.startActivity(taskSuccessIntent);
        }
        else {
            Toast.makeText(gameActivity, "Incorrect Answer", Toast.LENGTH_LONG).show();
        }
    }
}
