package com.example.teachingtasks;

import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GameController {

    ArrayList<Category> categories = new ArrayList<Category>();

    public ArrayList<Category> getCategories(){
        return this.categories;
    }

    public boolean addCategory(Category cat){

        //ADD THIS TO THE DATABASE
        System.out.println("GameController.java Requires Database Setup... ");
        System.out.println("could/should add new Category to database in EventHandler");

        return this.categories.add(cat);
    }

    public boolean delCategory(Category cat){

        //If cat is a Custom Category, remove
        //Else, send error message
        return this.categories.remove(cat);
    }

    public Task getNextTask(){
        //Sort for category by mastery
        //Sort for task by mastery
        //Give task with lowest mastery first if last X questions mastered (answered correct in X tries)
        //Else, give task with higher mastery
        //^do a small math equation... Based on last X questions, the number mastered, and the index in list of tasks sorted by mastery
        //Give task with no recorded mastery if number of in-progress masteries < X
        //Give task with



        return new Task(new UUID(10,1), "Temp Task Question", new HashMap<String, Button>());
    }
}