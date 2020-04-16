package com.example.teachingtasks;

import java.util.ArrayList;

public class Category implements CategoryInterface {

    String category;
    ArrayList<Task> tasks;
    int taskCount;

    public Category(String newCatName, ArrayList<Task> initTasks){

        this.category = newCatName;
        this.tasks = initTasks;
        taskCount = initTasks.size();
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public void setCategory(String newCat) {
        this.category = newCat;
    }

    @Override
    public void addTask(Task newTask) {
        this.tasks.add(newTask);
    }

    @Override
    public void deleteTask(Task delTask) {

        if(this.tasks.contains(delTask)){
            this.tasks.remove(delTask);
        }
    }
}
