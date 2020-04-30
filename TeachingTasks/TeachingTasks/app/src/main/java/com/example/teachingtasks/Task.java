package com.example.teachingtasks;

import android.widget.Button;

import java.util.HashMap;
import java.util.UUID;

public class Task implements TaskInterface {

    String question;
    String questionObject;
    HashMap<String, Button> taskObjects;  //questionObject, ButtonObject
    int mastery = 1;
    UUID taskID;

    public Task(UUID id, String q, HashMap<String, Button> obj){

        this.taskID = id;
        this.question = q;
        this.taskObjects = obj;
    }

    @Override
    public HashMap<String, Button> getTaskObjects() {
        return taskObjects;
    }

    @Override
    public UUID getTaskID() {
        return taskID;
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
    public int getMastery() { return this.mastery; }

    @Override
    public void setQuestionObject(String qObj) {
        this.questionObject = qObj;
    }

    @Override
    public void setTaskObjects(HashMap<String, Button> objects) {
        this.taskObjects = objects;
    }

    @Override
    public void setMastery(int newMastery) {
        mastery = newMastery;
    }
}
