package com.example.teachingtasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";
    public static final String TABLE_NAME = "users";
    public static final String TABLE_ID = "1";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static int version = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_PASSWORD + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser (String user, String pass){
        //Add a new user to the database

        //Call Writable
        SQLiteDatabase db = this.getWritableDatabase();

        //Set the new values
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, user);
        contentValues.put(COL_PASSWORD, pass);

        //Insert and return
        db.insert(TABLE_NAME, null, contentValues);
        return;
    }

    public void deleteUser(String user){
        //Delete a user from the database

        SQLiteDatabase db = this.getWritableDatabase();

        String selection = COL_USERNAME + " LIKE ? ";

        String[] selectionArgs = { user };

        db.delete(TABLE_NAME, selection, selectionArgs);
    }
}
