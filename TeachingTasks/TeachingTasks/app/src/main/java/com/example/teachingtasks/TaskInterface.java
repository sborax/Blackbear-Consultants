package com.example.teachingtasks;

import java.util.ArrayList;
import java.util.UUID;

public interface TaskInterface {

    public UUID getTaskID();
    public String getQuestion();
    public ArrayList<T> getTaskObjects();
    public String getQuestionObject();
    public int getMastery();
    public void setMastery(int newMastery);
    public void setQuestionObject(String qObj);
    public void setTaskObjects(ArrayList<T> objects);
}
