package com.example.fyp_memory_game;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Highscore.db";
    //LEVEL ONE TABLE
    public static final String TABLE_NAME_LEVEL1 = "levelone_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SCORE";
    //LEVEL TWO TABLE
    public static final String TABLE_NAME_LEVEL2 = "leveltwo_table";
    public static final String COL_1_LVL2 = "ID";
    public static final String COL_2_LVL2 = "NAME";
    public static final String COL_3_LVL2 = "SCORE";
    //LEVEL THREE TABLE
    public static final String TABLE_NAME_LEVEL3 = "levelthree_table";
    public static final String COL_1_LVL3 = "ID";
    public static final String COL_2_LVL3 = "NAME";
    public static final String COL_3_LVL3 = "SCORE";
    //LEVEL FOUR TABLE
    public static final String TABLE_NAME_LEVEL4 = "levelfour_table";
    public static final String COL_1_LVL4 = "ID";
    public static final String COL_2_LVL4 = "NAME";
    public static final String COL_3_LVL4 = "SCORE";
    //LEVEL FIVE TABLE
    public static final String TABLE_NAME_LEVEL5 = "levelfive_table";
    public static final String COL_1_LVL5 = "ID";
    public static final String COL_2_LVL5 = "NAME";
    public static final String COL_3_LVL5 = "SCORE";
    //LEVEL SIX TABLE
    public static final String TABLE_NAME_LEVEL6 = "levelsix_table";
    public static final String COL_1_LVL6 = "ID";
    public static final String COL_2_LVL6 = "NAME";
    public static final String COL_3_LVL6 = "SCORE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 6);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME_LEVEL1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
        db.execSQL("create table " + TABLE_NAME_LEVEL2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
        db.execSQL("create table " + TABLE_NAME_LEVEL3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
        db.execSQL("create table " + TABLE_NAME_LEVEL4 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
        db.execSQL("create table " + TABLE_NAME_LEVEL5 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
        db.execSQL("create table " + TABLE_NAME_LEVEL6 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SCORE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LEVEL1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LEVEL2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LEVEL3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LEVEL4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LEVEL5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LEVEL6);

        onCreate(db);
    }

    //insert for level one
    public boolean insertData(String name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, score);
        long result = db.insert(TABLE_NAME_LEVEL1, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    //insert for level two
    public boolean insertData_leveltwo(String name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_LVL2, name);
        contentValues.put(COL_3_LVL2, score);
        long result = db.insert(TABLE_NAME_LEVEL2, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    //insert for level three
    public boolean insertData_levelthree(String name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_LVL3, name);
        contentValues.put(COL_3_LVL3, score);
        long result = db.insert(TABLE_NAME_LEVEL3, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    //insert for level four
    public boolean insertData_levelfour(String name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_LVL4, name);
        contentValues.put(COL_3_LVL4, score);
        long result = db.insert(TABLE_NAME_LEVEL4, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    //insert for level five
    public boolean insertData_levelfive(String name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_LVL5, name);
        contentValues.put(COL_3_LVL5, score);
        long result = db.insert(TABLE_NAME_LEVEL5, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    //insert for level six
    public boolean insertData_levelsix(String name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_LVL6, name);
        contentValues.put(COL_3_LVL6, score);
        long result = db.insert(TABLE_NAME_LEVEL6, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
