package com.example.teachingtasks;

public class Task implements TaskInterface {

    String question;
    String questionObject;
    Object[] taskObjects;
    int mastery = 0;

    public Task(String q, Object[] obj){

        this.question = q;
        this.taskObjects = obj;
    }

    @Override
    public Object[] getTaskObjects() {
        return taskObjects;
    }

    @Override
    public void setQuestionObject(String qObj) {
        this.questionObject = qObj;
    }

    @Override
    public void setTaskObjects(Object[] objects) {
        this.taskObjects = objects;
    }

    @Override
    public void setMastery(int newMastery) {
        mastery = newMastery;
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
}
