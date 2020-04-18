package com.example.teachingtasks;

import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public interface TaskInterface {

    public UUID getTaskID();
    public String getQuestion();
    public HashMap<String, Button> getTaskObjects();
    public String getQuestionObject();
    public int getMastery();
    public void setMastery(int newMastery);
    public void setQuestionObject(String qObj);
    public void setTaskObjects(HashMap<String, Button> objects);
}
