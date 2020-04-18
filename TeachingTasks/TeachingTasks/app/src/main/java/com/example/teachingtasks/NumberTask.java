package com.example.teachingtasks;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.fonts.FontFamily;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class NumberTask extends Task implements TaskInterface{

    private final UUID ID = UUID.randomUUID();
    private final String QUESTION = "Click the Number";
    private String questionObject;
    ArrayList<Button> taskObjects = new ArrayList<>();
    int mastery = 0;

    public NumberTask(GameActivity gameActivity, UUID id, String q, ArrayList<Button> obj) {
        super(id, q, obj);

        Button one = new Button(gameActivity.getBaseContext());
        Button two = new Button(gameActivity.getBaseContext());
        Button three = new Button(gameActivity.getBaseContext());
        Button four = new Button(gameActivity.getBaseContext());
        Button five = new Button(gameActivity.getBaseContext());
        Button six = new Button(gameActivity.getBaseContext());
        Button seven = new Button(gameActivity.getBaseContext());
        Button eight = new Button(gameActivity.getBaseContext());
        Button nine = new Button(gameActivity.getBaseContext());
        Button zero = new Button(gameActivity.getBaseContext());

        taskObjects.addAll(Arrays.asList(new Button[]{zero, one, two, three, four, five, six, seven, eight, nine}));

        for(int k = 0; k < taskObjects.size(); k++){

            Button curr = taskObjects.get(k);

            curr.setText(Integer.toString(k));
            curr.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            curr.setTextColor(Color.WHITE);
            curr.setTextSize(44);
            curr.setId((k+1)*1000000);
            curr.setBackground(null);

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
    public ArrayList<Button> getTaskObjects() {
        return this.taskObjects;
    }

    @Override
    public String getQuestionObject() {
        return null;
    }

    @Override
    public int getMastery() {
        return 0;
    }

    @Override
    public void setMastery(int newMastery) {

    }

    @Override
    public void setQuestionObject(String qObj) {

    }

    @Override
    public void setTaskObjects(ArrayList<Button> objects) {

    }
}
