package com.example.teachingtasks;

import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MatchingCategory extends Category implements CategoryInterface {

    private final String CATEGORY = "Matching";
    private ArrayList<Task> tasks = new ArrayList<>();
    private int mastery = 0;

    public MatchingCategory(GameActivity gameActivity, String newCatName, ArrayList<Task> initTasks) throws InstantiationException, IllegalAccessException {
        super(newCatName, initTasks);

        tasks.add(new NumberTask(gameActivity, new UUID(1000000, 10), "Click the Number", new HashMap<String, Button>()));
    }

    @Override
    public String getCategory(){
        return this.CATEGORY;
    }
    @Override
    public int getMastery(){
        return this.mastery;
    }

    @Override
    public ArrayList<Task> getTasks(){
        return this.tasks;
    }

}
