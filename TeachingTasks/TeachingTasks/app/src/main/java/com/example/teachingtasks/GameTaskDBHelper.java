package com.example.teachingtasks;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class GameTaskDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database";
    private static final String TABLE_NAME = "task";
    private static final String TABLE_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_CATEGORY = "category";

//  private static final String
    public static int version = 1;

    public GameTaskDBHelper(Context context) {
        super(context, DATABASE_NAME, null, version);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_CATEGORY + " TEXT, " + getTaskNames());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_CATEGORY + " TEXT, " + getTaskNames());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private String getTaskNames() {

        return "NumberTask" + " TEXT)";
    }

    public String getMastery(String task){

        return "getMaster GameTaskDBHelper.java";
    }
}
