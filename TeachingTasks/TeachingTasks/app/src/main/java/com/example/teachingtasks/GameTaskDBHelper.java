package com.example.teachingtasks;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


class GameTaskDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database";
    private static final String TABLE_NAME = "task";
    private static final String TABLE_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_TASK = "task";
//    private static ArrayList<String> colTaskObjects;

//  private static final String
    public static int version = 1;

    public GameTaskDBHelper(Context context) {
        super(context, DATABASE_NAME, null, version);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_TASK + " TEXT, " + getTaskObjects());
    }

    private String getTaskObjects() {

        return "zero_correct, TEXT, " +
                "zero_incorrect, TEXT, " +
                "one_correct, TEXT, " +
                "one_incorrect, TEXT, " +
                "two_correct, TEXT, " +
                "two_incorrect, TEXT, " +
                "three_correct, TEXT, " +
                "three_incorrect, TEXT, " +
                "four_correct, TEXT, " +
                "four_incorrect, TEXT, " +
                "five_correct, TEXT, " +
                "five_incorrect, TEXT, " +
                "six_correct, TEXT, " +
                "six_incorrect, TEXT, " +
                "seven_correct, TEXT, " +
                "seven_incorrect, TEXT, " +
                "eight_correct, TEXT, " +
                "eight_incorrect, TEXT, " +
                "nine_correct, TEXT, " +
                "nine_incorrect, TEXT)";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_TASK + " TEXT, " + getTaskObjects());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public String getTaskMastery(){

        return "mastery GameTaskDBHelper.java";
    }

    public String getTaskObjectMastery(String taskObject){



        return "getMaster GameTaskDBHelper.java";
    }
}
