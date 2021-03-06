package com.example.paramas_wae.mydatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by paramas_wae on 6/13/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tasks.db";
    public static final String TABLE_TASKS = "tesks";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TASKNAME = "taskname";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_TASKS + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_TASKNAME + " TEXT );";
        db.execSQL(query);
    }

    public void addTasks(Tasks tasks) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASKNAME, tasks.get_taskname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TASKS, null, values);
        db.close();
    }

    public void removeTasks(String taskName) {
        String query = "DELETE FROM " + TABLE_TASKS + " WHERE " + COLUMN_TASKNAME + " = \"" + taskName + "\";";
        SQLiteDatabase db = getWritableDatabase(); // getWritableDatabase เริ่มดารเขียน database
        db.execSQL(query);
    }

    public String databaseToString(){
        String dataString="";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_TASKS;
        Cursor c = db.rawQuery(query,null); // Cursor ใช้ในการระบุุข้อมูลที่เลือก 
        c.moveToFirst(); //เลื่อน cursor ไป row หน้าสุด
        while(!c.isAfterLast()){ // isAfterLast ใช้ตรวจสอบ cursor ว่า อยู่ที่ตำแหน่งสุกท้ายหรือไม่
            if(c.getString(c.getColumnIndex(COLUMN_TASKNAME))!= null){ // getColumnIndex ใช้ในการดึงข้อมูลของ column ใน row นั้นๆ
                dataString += c.getString(c.getColumnIndex(COLUMN_TASKNAME));
                dataString += "\n";
            }
            c.moveToNext(); // moveToNext เลือน cursor ไป row ถัดไป
        }
        db.close();
        return dataString;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
