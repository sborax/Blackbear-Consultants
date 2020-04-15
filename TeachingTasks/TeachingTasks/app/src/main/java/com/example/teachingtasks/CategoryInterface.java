package com.example.teachingtasks;

public interface CategoryInterface {

    public String getCategory();
    public Task[] getTasks();
    public void setCategory(String newCat);
    public void addTask(Task newTask);
    public void deleteTask(Task delTask);
}
