package com.example.teachingtasks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


class GameTaskDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database";
    private static final String TABLE_NAME = "task";
    private static final String TABLE_ID = "id";
    private static final String COL_USERNAME = "username";
    private static final String COL_TASK = "task";
    private static final String COL_TIME = "time";

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

    public void initializeTaskObjects(String username) {

        SQLiteDatabase db = this.getWritableDatabase();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_TASK, "numbertask");
        contentValues.put(COL_TIME, formatter.format(date));
        contentValues.put("zero_correct", 0);
        contentValues.put("zero_incorrect", 0);
        contentValues.put("one_correct", 0);
        contentValues.put("one_incorrect", 0);
        contentValues.put("two_correct", 0);
        contentValues.put("two_incorrect", 0);
        contentValues.put("three_correct", 0);
        contentValues.put("three_incorrect", 0);
        contentValues.put("four_correct", 0);
        contentValues.put("four_incorrect", 0);
        contentValues.put("five_correct", 0);
        contentValues.put("five_incorrect", 0);
        contentValues.put("six_correct", 0);
        contentValues.put("six_incorrect", 0);
        contentValues.put("seven_correct", 0);
        contentValues.put("seven_incorrect", 0);
        contentValues.put("eight_correct", 0);
        contentValues.put("eight_incorrect", 0);
        contentValues.put("nine_correct", 0);
        contentValues.put("nine_incorrect", 0);

        long temp = db.insert(TABLE_NAME, null, contentValues);
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

    public int getTaskObjectMastery(String username, String taskObject){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        res.moveToFirst();

        while (res.isAfterLast() == false){

            String tempUser = res.getString(res.getColumnIndex(COL_USERNAME));

            if(tempUser.equalsIgnoreCase(username)){
                String temp = res.getString(res.getColumnIndex(taskObject));

                if(temp != null){
                    return Integer.parseInt(temp);
                }
                else{
                    return -1;
                }
            }
            res.moveToNext();
        }
        return -1;
    }

    public void subMastery(String username, String task, String taskObject){

        String taskObjectIncorrect = taskObject.toLowerCase().concat("_incorrect");

        SQLiteDatabase db = this.getWritableDatabase();

        int newMastery = this.getTaskObjectMastery(username, taskObjectIncorrect)+1;

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_TASK, task);
        contentValues.put(taskObjectIncorrect, newMastery);

        long temp = db.update(TABLE_NAME, contentValues, taskObjectIncorrect + " = ?", new String[]{Integer.toString(newMastery-1)});
    }

    public void addMastery(String username, String task, String taskObject){

        String taskObjectCorrect = taskObject.toLowerCase().concat("_correct");

        SQLiteDatabase db = this.getWritableDatabase();

        int newMastery = this.getTaskObjectMastery(username, taskObjectCorrect)+1;

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_TASK, task);
        contentValues.put(taskObjectCorrect, newMastery);

        long temp = db.update(TABLE_NAME, contentValues, taskObjectCorrect + " = ?", new String[]{Integer.toString(newMastery-1)});

    }

    public void deleteUser(String user) {

        SQLiteDatabase db = this.getWritableDatabase();

        String selection = COL_USERNAME + " LIKE ? ";

        String[] selectionArgs = { user };

        int temp = db.delete(TABLE_NAME, selection, selectionArgs);

        return;
    }

    public int getTaskMastery(String username, String task) {

        SQLiteDatabase db = this.getReadableDatabase();
        int totalCorrect = 1;
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        res.moveToFirst();

        while (res.isAfterLast() == false){

            String tempUser = res.getString(res.getColumnIndex(COL_USERNAME));

            if(tempUser.equalsIgnoreCase(username)){

                String tempTask = res.getString(res.getColumnIndex(COL_TASK));

                if(tempTask.equalsIgnoreCase(task)){

                    String[] columnNames = res.getColumnNames();

                    for (int k = 4; k < columnNames.length; k++){

                        String tempCorrect = columnNames[k];

                        totalCorrect += Integer.parseInt(res.getString(res.getColumnIndex(tempCorrect)));
                    }
                }
            }

            res.moveToNext();
        }

        return totalCorrect;
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
}
