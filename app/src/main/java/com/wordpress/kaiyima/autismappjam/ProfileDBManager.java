package com.wordpress.kaiyima.autismappjam;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.HashMap;


public class ProfileDBManager extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "profile.db";
    public static final String TABLE_PROFILE = "profiles";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EXP = "exp";

    public ProfileDBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_PROFILE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_EXP + " INTEGER " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + TABLE_PROFILE);
        onCreate(sqLiteDatabase);
    }

    //Add new row to DB
    public void addProfile(UserProfile profile){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, profile.get_username());
        values.put(COLUMN_EXP, 0);
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        sqLiteDatabase.insert(TABLE_PROFILE, null, values);
        sqLiteDatabase.close();
    }

    //Delete a profile from DB
    public  void deleteProfile(String userName){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_PROFILE + " WHERE " + COLUMN_USERNAME+ "=\"" + userName + "\";");
    }

    public boolean updateProfile(int id, String userName, int exp){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", userName);
        contentValues.put("exp", exp);
        sqLiteDatabase.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PROFILE + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex(COLUMN_USERNAME)) != null){
                dbString += c.getString(c.getColumnIndex(COLUMN_USERNAME)) + ": " +
                        c.getString(c.getColumnIndex(COLUMN_EXP)) + "xp\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public HashMap<String, UserProfile> databaseToHashMap(){
        HashMap<String, UserProfile> dbMap = new HashMap<String, UserProfile>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PROFILE + " WHERE 1;";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex(COLUMN_USERNAME)) != null){
                UserProfile userProfile = new UserProfile(c.getString(c.getColumnIndex(COLUMN_USERNAME)));
                userProfile.set_id(c.getInt(c.getColumnIndex(COLUMN_ID)));
                userProfile.set_exp(c.getInt(c.getColumnIndex(COLUMN_EXP)));
                dbMap.put(c.getString(c.getColumnIndex(COLUMN_USERNAME)), userProfile);
            }
            c.moveToNext();
        }
        db.close();
        return dbMap;
    }
}
