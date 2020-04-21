package com.example.teachingtasks;

import android.app.Activity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GameController {

    ArrayList<Category> categories = new ArrayList<Category>();
    StatisticsDBHelper mydb;

    public GameController(GameActivity gameActivity){

        try {
            categories.add(new MatchingCategory(gameActivity,"", null));
            mydb = new StatisticsDBHelper(gameActivity);
            //Add the rest from the database
            categories.addAll(mydb.getCategories());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

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

    public Task getNextTask(Activity activity){
        //Sort for category by mastery
        //Sort for task by mastery
        //Give task with lowest mastery first if last X questions mastered (answered correct in X tries)
        //Else, give task with higher mastery
        //^do a small math equation... Based on last X questions, the number mastered, and the index in list of tasks sorted by mastery
        //Give task with no recorded mastery if number of in-progress masteries < X
        //Give task with


        int catMastery = -1;
        int taskMastery = -1;
        ArrayList<Task> tasks = new ArrayList<>();
        Task nextTask = null;

        //Get the most mastered Category
        for (int k = 0; k < this.categories.size(); k++){

            if(this.categories.get(k).getMastery() > catMastery){
                catMastery = this.categories.get(k).getMastery();
                tasks = this.categories.get(k).getTasks();
            }
        }

        //Get the most mastered Task
        for (int n = 0; n < tasks.size(); n++){

            if(tasks.get(n).getMastery() > taskMastery){
                nextTask = tasks.get(n);
                taskMastery = nextTask.getMastery();
            }
        }

        return nextTask;
    }
}