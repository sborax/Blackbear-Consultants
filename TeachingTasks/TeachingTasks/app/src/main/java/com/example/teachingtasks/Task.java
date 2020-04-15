package com.example.teachingtasks;

import java.util.ArrayList;
import java.util.UUID;

public class Task implements TaskInterface {

    String question;
    String questionObject;
    ArrayList<T> taskObjects;         //Images for Custom Tasks, Text or Images for regular Tasks
    int mastery = 0;
    UUID taskID;

    public Task(UUID id, String q, ArrayList<T> obj){

        this.taskID = id;
        this.question = q;
        this.taskObjects = obj;
    }

    @Override
    public ArrayList<T> getTaskObjects() {
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
    public void setTaskObjects(ArrayList<T> objects) {
        this.taskObjects = objects;
    }

    @Override
    public void setMastery(int newMastery) {
        mastery = newMastery;
    }
}
