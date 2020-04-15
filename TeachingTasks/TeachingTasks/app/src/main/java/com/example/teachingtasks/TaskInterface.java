package com.example.teachingtasks;

public interface TaskInterface {

    public String getQuestion();
    public Object[] getTaskObjects();
    public String getQuestionObject();
    public int getMastery();
    public void setMastery(int newMastery);
    public void setQuestionObject(String qObj);
    public void setTaskObjects(Object[] objects);
}
