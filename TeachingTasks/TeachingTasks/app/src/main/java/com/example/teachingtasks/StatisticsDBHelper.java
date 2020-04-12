package com.example.teachingtasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class StatisticsDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";
    public static final String TABLE_NAME = "statistics";
    public static final String TABLE_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_SQUARE_CORRECT= "correct_square";
    public static final String COL_SQUARE_INCORRECT= "incorrect_square";
    public static final String COL_CIRCLE_CORRECT= "correct_circle";
    public static final String COL_CIRCLE_INCORRECT= "incorrect_circle";

    public static int version = 1;

    public StatisticsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_SQUARE_CORRECT + " INTEGER, " + COL_SQUARE_INCORRECT + " INTEGER, " + COL_CIRCLE_CORRECT + " INTEGER, " + COL_CIRCLE_INCORRECT + " INTEGER)");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + TABLE_ID + " INTEGER PRIMARY KEY," + COL_USERNAME + " TEXT, " + COL_SQUARE_CORRECT + " INTEGER, " + COL_SQUARE_INCORRECT + " INTEGER, " + COL_CIRCLE_CORRECT + " INTEGER, " + COL_CIRCLE_INCORRECT + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser (String user){
        //Add a new user to the database

        //Call Writable
        SQLiteDatabase db = this.getWritableDatabase();

        //Set the new values
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, user);
        contentValues.put(COL_SQUARE_CORRECT, 0);
        contentValues.put(COL_SQUARE_INCORRECT, 0);
        contentValues.put(COL_CIRCLE_CORRECT, 0);
        contentValues.put(COL_CIRCLE_INCORRECT, 0);

        //Insert and return
        long temp = db.insert(TABLE_NAME, null, contentValues);

        return;
    }

    public void deleteUser(String user){
        //Delete a user from the database

        SQLiteDatabase db = this.getWritableDatabase();

        String selection = COL_USERNAME + " LIKE ? ";

        String[] selectionArgs = { user };

        int temp = db.delete(TABLE_NAME, selection, selectionArgs);

        return;
    }

    public String[] getAllUsers() {
        //Returns a list of all users
        //Limited to 20 users

        //Call Readable
        SQLiteDatabase db = this.getReadableDatabase();

        String[] users = new String[20];
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        res.moveToFirst();

        int count = 0;
        while(res.isAfterLast() == false){
            //If the next username is not an empty index, add to users
            //Else, keep going until the end of database is reached

            String temp = res.getString(res.getColumnIndex(COL_USERNAME));
            if(!temp.isEmpty())
                users[count] = temp;
            res.moveToNext();
            count++;
        }

        return users;
    }

    public boolean containsUser(String tempUser) {
        //If the database contains the username, return true
        //Else, false

        String[] users = this.getAllUsers();

        for(int k = 0; k < users.length-1; k++){
            if(tempUser.equals(users[k])){
                return true;
            }
        }
        return false;
    }

    public void update(String user, String col, int value) {
        //Updates column col with value
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col, value);
        db.update(TABLE_NAME, cv, COL_USERNAME + " = ?", new String[] {user});
    }

    public void increment(String user, String col) {
        //Increments value in col
        int temp = getValue(user, col);
        temp++;
        update(user, col, temp);
    }

    public int getValue(String user, String col) {
        //returns value in col
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.query(TABLE_NAME, new String[] {COL_USERNAME, col}, "? = ?", new String[] {COL_USERNAME, user}, null, null, null);
        int ret = res.getInt(res.getColumnIndex(col));  //FIXME: android.database.CursorIndexOutOfBoundsException: Index -1 requested, with a size of 0
        return ret;
    }
}
