package com.zybooks.moybrandonweighttracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //database properties
    private static final String DATABASE_NAME = "register.db";
    private static final String TABLE_NAME = "registration";
    //table fields
    private static final String COL_1 = "ID";
    private static final String COL_2= "Username";
    private static final String COL_3 = "Password";
    private static final String COL_4E = "Phonenumber";

    //sets up database variables
    public DatabaseHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    //creates the table in the sqLiteDatabase
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registration (ID INTEGER PRIMARY KEY AUTOINCREMENT,Username TEXT, Password TEXT, Phonenumber TEXT)");
    }
    //drops table if it already exists
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    //add account/user function
    public long addUser(String user, String password, String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",user );
        contentValues.put("Password",password );
        contentValues.put("Phonenumber",phonenumber );
        long result = db.insert("registration", null, contentValues);
        db.close();
        return result;
    }
    //checks to see if account exists or not
    public boolean checkAccount (String username, String password){
        String [] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String [] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        db.close();

        if (count>0){
            return true;
        }
        else{
            return false;
        }
    }
}
