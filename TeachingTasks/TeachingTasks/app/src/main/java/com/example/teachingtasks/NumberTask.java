package com.example.teachingtasks;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.Button;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class NumberTask extends Task implements TaskInterface{

    private final UUID ID = UUID.randomUUID();
    private final String QUESTION = "Click the Number";
    private String questionObject;
    private HashMap<String, Button> taskObjects = new HashMap<>();
    private int mastery = 1;

    public NumberTask(Activity gameActivity, UUID id, String q, HashMap<String, Button> obj) {
        super(id, q, obj);

        Button zero = new Button(gameActivity.getBaseContext());
        Button one = new Button(gameActivity.getBaseContext());
        Button two = new Button(gameActivity.getBaseContext());
        Button three = new Button(gameActivity.getBaseContext());
        Button four = new Button(gameActivity.getBaseContext());
        Button five = new Button(gameActivity.getBaseContext());
        Button six = new Button(gameActivity.getBaseContext());
        Button seven = new Button(gameActivity.getBaseContext());
        Button eight = new Button(gameActivity.getBaseContext());
        Button nine = new Button(gameActivity.getBaseContext());

        String[] questionObjects = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        Button[] tempObjects = {zero, one, two, three, four, five, six, seven, eight, nine};

        for(int k = 0; k < questionObjects.length; k++){

            Button curr = tempObjects[k];

            curr.setText(Integer.toString(k));
            curr.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            curr.setTextColor(Color.WHITE);
            curr.setTextSize(44);
            curr.setId((k+1)*1000000);
            curr.setBackground(null);

            taskObjects.put(questionObjects[k], curr);
        }
    }

    @Override
    public UUID getTaskID() {
        return this.ID;
    }

    @Override
    public String getQuestion() {
        return this.QUESTION;
    }

    @Override
    public HashMap<String, Button> getTaskObjects() {
        return this.taskObjects;
    }

    @Override
    public String getQuestionObject() {
        return (String) this.taskObjects.keySet().toArray()[new Random().nextInt(9)];
    }

    @Override
    public int getMastery() {
        return this.mastery;
    }

    @Override
    public void setMastery(int newMastery) {

    }

    @Override
    public void setQuestionObject(String qObj) {

    }

    @Override
    public void setTaskObjects(HashMap<String, Button> objects) {

    }
}
