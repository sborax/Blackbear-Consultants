package com.example.teachingtasks;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class NavButtonEventHandler {

    Intent intent;

    public void onClick(Activity currActivity, View v, String user) {

        switch (v.getId()){
            case R.id.taskNavButton: gotoTask(currActivity, v, user); break;
            case R.id.statisticsNavButton: gotoStatistics(currActivity, v, user); break;
            case R.id.settingsNavButton: gotoSettings(currActivity, v, user); break;
        }
    }

    private void gotoTask(Activity currActivity, View v, String user) {

        intent = new Intent(currActivity, GameActivity.class);
        intent.putExtra("EXTRA_USER", user);
        intent.putExtra("EXTRA_QUESTION", "Click the Number");
        intent.putExtra("EXTRA_TASK_OBJECT", "Zero");
        currActivity.startActivity(intent);
    }

    private void gotoStatistics(Activity currActivity, View v, String user) {

        intent = new Intent(currActivity, StatisticsActivity.class);
        intent.putExtra("EXTRA_USER", user);
        currActivity.startActivity(intent);
    }

    private void gotoSettings(Activity currActivity, View v, String user) {

        intent = new Intent(currActivity, SettingsActivity.class);
        intent.putExtra("EXTRA_USER", user);
        currActivity.startActivity(intent);
    }



}
