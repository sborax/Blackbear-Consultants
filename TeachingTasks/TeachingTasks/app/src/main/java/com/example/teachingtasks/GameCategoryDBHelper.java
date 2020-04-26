package com.example.teachingtasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class GameCategoryDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";
    public static final String TABLE_NAME = "game_category";
    public static final String TABLE_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_CATEGORY = "category";

    public static int version = 1;

    public GameCategoryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID+ " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_CATEGORY + " TEXT," + getTaskNames());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID+ " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_CATEGORY + " TEXT," + getTaskNames());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private String getTaskNames() {

        return "NumberTask" + " TEXT)";
    }

    public void addCategory(String user, String category){
        //Add a new Category

        //Call Writable
        SQLiteDatabase db = this.getWritableDatabase();

        //Set the new values
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, user);
        contentValues.put(COL_CATEGORY, category);
    }

    public void addCustomCategory(String user, String category){
        //Add a new Custom Category

        //Call Writable
        SQLiteDatabase db = this.getWritableDatabase();

        //Set the new values
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, user);
        contentValues.put(COL_CATEGORY, category + "_CUSTOM");
    }

    public ArrayList<String> getCategories() {

        //Call Readable
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<String> categories = new ArrayList<String>();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        res.moveToFirst();

        int count = 0;
        while(res.isAfterLast() == false){
            //If the next username is not an empty index, add to users
            //Else, keep going until the end of database is reached

            String temp = res.getString(res.getColumnIndex(COL_CATEGORY));
            if(!temp.isEmpty())
                if(temp.contains("_CUSTOM"))
                    categories.add(temp);
            res.moveToNext();
            count++;
        }

        return categories;
    }
}
