package com.example.androidgoapp.androidgoapp.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * General functions of the group database.
 * @author Theresa Heine
 * @version 1.0
 */

public class DBHelperGroup extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "group.db";
    private SQLiteDatabase db;

    /**
     * Constructor to define general information of the database.
     * @param context
     */
    public DBHelperGroup(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * It is called first time when database is created.
     * @param sqLiteDatabase to create
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(FeedReaderContract.FeedEntryGroup.SQL_CREATE_ENTRIES_GROUP);
        } catch (Exception e) {

        }
    }

    /**
     *  Run when database is upgraded / changed, like drop tables, add tables etc.
     * @param sqLiteDatabase to upgrade
     * @param oldVersion of database
     * @param newVersion of database
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(FeedReaderContract.FeedEntryGroup.SQL_DELETE_ENTRIES_GROUP);
        onCreate(sqLiteDatabase);
    }

}
