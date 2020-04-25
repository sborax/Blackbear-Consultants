package com.example.teachingtasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


class GameTaskDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database";
    private static final String TABLE_NAME = "task";
    private static final String TABLE_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_TASK = "task";
    private static final String COL_TIME = "time";
//    private static ArrayList<String> colTaskObjects;

//  private static final String
    public static int version = 1;

    public GameTaskDBHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_TASK + " TEXT, " + COL_TIME + " TEXT, " + getTaskObjects());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_TASK + " TEXT, " + COL_TIME + " TEXT, " + getTaskObjects());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private String getTaskObjects() {

        return "zero_correct INTEGER, " +
                "zero_incorrect INTEGER, " +
                "one_correct INTEGER, " +
                "one_incorrect INTEGER, " +
                "two_correct INTEGER, " +
                "two_incorrect INTEGER, " +
                "three_correct INTEGER, " +
                "three_incorrect INTEGER, " +
                "four_correct INTEGER, " +
                "four_incorrect INTEGER, " +
                "five_correct INTEGER, " +
                "five_incorrect INTEGER, " +
                "six_correct INTEGER, " +
                "six_incorrect INTEGER, " +
                "seven_correct INTEGER, " +
                "seven_incorrect INTEGER, " +
                "eight_correct INTEGER, " +
                "eight_incorrect INTEGER, " +
                "nine_correct INTEGER, " +
                "nine_incorrect INTEGER)";
    }

    public String getTaskMastery(){

        return "mastery GameTaskDBHelper.java";
    }

    public int getTaskObjectMastery(String username, String taskObject){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        res.moveToFirst();

        if(res.isAfterLast() == false){

            String temp = res.getString(res.getColumnIndex(COL_USERNAME));
            System.out.println("Username: " + temp);
//            String tempCorrect = res.getString(res.getColumnIndex(taskObject.toLowerCase().concat("_correct")));
//            String tempIncorrect = res.getString(res.getColumnIndex(taskObject.toLowerCase().concat("_incorrect")));
//
//            if(tempCorrect != null && tempIncorrect != null){
//
//                if(!tempCorrect.isEmpty() && !tempIncorrect.isEmpty()){
//                    int returnTemp = Integer.getInteger(tempCorrect) / Integer.getInteger(tempIncorrect);
//                    return returnTemp;
//                }
//            }
//            else {
//                System.out.println("GetTaskMastery Failed with: " + taskObject.toLowerCase().concat("_correct"));
//                System.out.println("GetTaskMastery Failed with: " + taskObject.toLowerCase().concat("_incorrect"));
//                return -1;
//            }
        }

        System.out.println("GameTaskDBHelper.java: getTaskObjectMastery FAILED");
        return 1;
    }

    public void addMastery(String username, String taskObject){

        String taskObjectCorrect = taskObject.toLowerCase().concat("_correct");
        String taskObjectIncorrect = taskObject.toLowerCase().concat("_incorrect");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(taskObjectCorrect, 10);
        contentValues.put(taskObjectIncorrect, 2);

        long temp = db.insert(TABLE_NAME, null, contentValues);
    }

    public void getAllCorrect(String object) {
        //Returns a list of all users
        //Limited to 20 users

        //Call Readable
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<String> users = new ArrayList<>();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        res.moveToFirst();

        int count = 0;
        while(res.isAfterLast() == false){
            //If the next username is not an empty index, add to users
            //Else, keep going until the end of database is reached

            String temp = res.getString(res.getColumnIndex(object));
            if(!temp.isEmpty())
                users.add(temp);
            res.moveToNext();
            count++;
        }

//        String[] cats = res.getColumnNames();
//        for (int k = 0; k < cats.length; k++) {
//            if(users.size() > k)
//                System.out.println("Printing " + object + ": " + users.get(k));
//            System.out.println("Column Names: " + cats[k]);
//        }
        return;
    }
}
