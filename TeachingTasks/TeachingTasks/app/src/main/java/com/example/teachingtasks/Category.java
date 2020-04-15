package com.example.teachingtasks;

import java.util.Arrays;

public class Category implements CategoryInterface {

    String category;
    Task[] tasks;
    int taskCount;

    public Category(String newCatName, Task[] initTasks){

        this.category = newCatName;
        this.tasks = initTasks;
        taskCount = initTasks.length;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public Task[] getTasks() {
        return this.tasks;
    }

    @Override
    public void setCategory(String newCat) {
        this.category = newCat;
    }

    @Override
    public void addTask(Task newTask) {

        if(tasks.length == taskCount){
            this.tasks = resize();
        }

        this.tasks[taskCount] = newTask;
        taskCount++;
    }

    @Override
    public void deleteTask(Task delTask) {

        for(int k = 0; k < this.tasks.length; k++){
            if (this.tasks[k].getTaskID().equals(delTask.getTaskID())){
                this.tasks[k] = null;
            }
        }
    }

    private Task[] resize(){

        Task[] temp = Arrays.copyOf(this.tasks, taskCount+1);
        return temp;
    }
}
