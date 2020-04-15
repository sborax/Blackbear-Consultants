package com.example.teachingtasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class RegisterUserDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database";
    public static final String TABLE_NAME = "users";
    public static final String TABLE_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static int version = 1;

    public RegisterUserDBHelper(Context context) {
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

    public ArrayList<String> getAllUsers() {
        //Returns a list of all users

        //Call Readable
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> users = new ArrayList<String>();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            //If the next username is not an empty index, add to users
            //Else, keep going until the end of database is reached

            String temp = res.getString(res.getColumnIndex(COL_USERNAME));
            if(!temp.isEmpty())
                users.add(temp);
            res.moveToNext();
        }

        return users;
    }

    public boolean containsUser(String tempUser) {
        //If the database contains the username, return true
        //Else, false

        ArrayList<String> users = this.getAllUsers();

        for(int k = 0; k < users.size(); k++){
            if(tempUser.equals(users.get(k))){
                return true;
            }
        }
        return false;
    }
}
