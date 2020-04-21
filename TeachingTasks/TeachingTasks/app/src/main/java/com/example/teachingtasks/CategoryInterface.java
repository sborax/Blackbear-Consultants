package com.example.teachingtasks;

import java.util.ArrayList;

public interface CategoryInterface {

    public String getCategory();
    public ArrayList<Task> getTasks();
    public void setCategory(String newCat);
    public void addTask(Task newTask);
    public void deleteTask(Task delTask);
    public int getMastery();
}
