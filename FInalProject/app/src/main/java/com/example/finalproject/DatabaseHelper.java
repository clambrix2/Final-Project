package com.example.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String database_name = "WikiApp.db";
    private static final String items_table_name = "Items";
    private static final String weapons_table_name = "Weapons";
    private static final String enemies_table_name = "Enemies";
    private static final String bookmark_table_name = "Bookmark";
    private static final String history_table_name = "History";
    private static final String post_table_name = "Posts";
    private static final String users_table_name = "Users";
    private static final String comments_table_name = "Comments";
    public DatabaseHelper(Context c)
    {
        super(c, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
            db.execSQL("CREATE TABLE " + users_table_name + "(Usersid integer primary key autoincrement not null, Username varchar(50), Password varchar(50));");
            db.execSQL("CREATE TABLE " + items_table_name + "(Itemid integer primary key autoincrement not null, Title varchar(50), Body varchar(50), Date varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
