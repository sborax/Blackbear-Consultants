package com.example.teachingtasks;

import android.widget.Button;

import java.util.ArrayList;
import java.util.UUID;

public class Task implements TaskInterface {

    String question;
    String questionObject;
    ArrayList<Button> taskObjects;         //Images for Custom Tasks, Text or Images for regular Tasks
    int mastery = 0;
    UUID taskID;

    public Task(UUID id, String q, ArrayList<Button> obj){

        this.taskID = id;
        this.question = q;
        this.taskObjects = obj;
    }

    @Override
    public ArrayList<Button> getTaskObjects() {
        return taskObjects;
    }

    @Override
    public UUID getTaskID() {
        return null;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String getQuestionObject() {
        return this.questionObject;
    }

    @Override
    public int getMastery() {
        return this.mastery;
    }

    @Override
    public void setQuestionObject(String qObj) {
        this.questionObject = qObj;
    }

    @Override
    public void setTaskObjects(ArrayList<Button> objects) {
        this.taskObjects = objects;
    }

    @Override
    public void setMastery(int newMastery) {
        mastery = newMastery;
    }
}
