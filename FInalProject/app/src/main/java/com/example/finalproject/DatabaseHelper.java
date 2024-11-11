package com.example.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
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
    private static final String items_comments_table_name = "Icomments";
    private static final String weapons_comments_table_name = "WCcomments";
    private static final String enemies_comments_table_name = "Ecomments";
    public DatabaseHelper(Context c)
    {
        super(c, database_name, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
            db.execSQL("CREATE TABLE " + users_table_name + "(Usersid integer primary key autoincrement not null, Username varchar(50), Password varchar(50));");
            db.execSQL("CREATE TABLE " + items_table_name + "(Itemid integer primary key autoincrement not null, Title varchar(50), Body varchar(300), Date varchar(50), location varchar(50));");
            db.execSQL("CREATE TABLE " + weapons_table_name + "(Weaponsid integer primary key autoincrement not null, Title varchar(50), Body varchar(50), Date varchar(50), location varchar(50));");
            db.execSQL("CREATE TABLE " + enemies_table_name + "(Enemiesid integer primary key autoincrement not null, Title varchar(50), Body varchar(50), Date varchar(50), location varchar(50));");
            db.execSQL("CREATE TABLE " + post_table_name + "(Postid integer primary key autoincrement not null, Title varchar(50), Likes, Dislike, Body varchar(50), Date varchar(50), foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE " + bookmark_table_name + "(Bookmarkid integer primary key autoincrement not null, Title varchar(50), Body varchar(50), Date varchar(50), postid, posttype varchar(50));");
            db.execSQL("CREATE TABLE " + history_table_name + "(Historyid integer primary key autoincrement not null, Title varchar(50), pageid, posttype varchar(50), likes, dislike, Date varchar(50));");
            db.execSQL("CREATE TABLE " + comments_table_name + "(Commentid integer primary key autoincrement not null, Username varchar(50), Body varchar(50), Likes, Dislike, postid, posttype varchar(50), foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE "  + items_comments_table_name + "(ItemCommentid integer primary key autoincrement not null, Body varchar(100), Likes, Dislike, foreign key (Itemid)  references " + items_table_name + "(Itemid), foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE "  + weapons_comments_table_name + "(WeaponCommentid integer primary key autoincrement not null, Body varchar(100), Likes, Dislike, foreign key (Weaponid)  references " + weapons_table_name + "(Weaponsid), foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE "  + enemies_comments_table_name + "(EnemiesCommentid integer primary key autoincrement not null, Body varchar(100), Likes, Dislike, foreign key (Enemiesid)  references " + enemies_table_name + "(Enemiesid), foreign key (Usersid) references " + users_table_name + "(Usersid));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + users_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + items_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + weapons_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + enemies_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + post_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + bookmark_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + history_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + comments_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + items_comments_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + weapons_comments_table_name + ";");
        db.execSQL("DROP TABLE IF EXISTS " + enemies_comments_table_name + ";");

    }

//starting tables
    public String getUsers_table_name() {
        return users_table_name;
    }
    public String getItems_table_name() {
        return items_table_name;
    }
    public String getWeapons_table_name() {
        return weapons_table_name;
    }
    public String getEnemies_table_name() {
        return enemies_table_name;
    }
    public String getPost_table_name() {
        return post_table_name;
    }
    public String getBookmark_table_name() {
        return bookmark_table_name;
    }
    public String getHistory_table_name() {
        return history_table_name;
    }
    public String getComments_table_name() {
        return comments_table_name;
    }
    public String getItems_comments_table_name()
    {
        return items_comments_table_name;
    }
    public String getWeapons_comments_table_name()
    {
        return  weapons_comments_table_name;

    }
    public String getEnemies_comments_table_name()
    {
        return  enemies_comments_table_name;
    }
    public void initables()
    {
        initusers();
        inititems();
       initweapons();
        initenemies();
        initposts();
        initbookmark();
       inithistory();
       initcomments();
    }
    public void initusers()
    {
        if(countfromrecords(users_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + users_table_name + "(Username, Password) VALUES ('Admin', 'thisisanAdmin');");
            db.execSQL("INSERT INTO " + users_table_name + "(Username, Password) VALUES ('User1', 'password');");
            db.close();
        }
    }
    public void inititems()
    {
        if(countfromrecords(items_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + items_table_name + "(Title, Body, Date, Location) VALUES ('Mini Health Potion', 'A Mini Health Potion heals 10 hp back per use with a maxium use of 3. They can be found or bought.', '11/11/2024', 'Deep Forest');");
            db.close();
        }
        if(countfromrecords(items_comments_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + items_comments_table_name + "(Body, Likes, Dislikes, Itemdid, Usersid) VALUES ('How rare is this item in shops?', 3, 1, 1, 2);");
            db.close();
        }
    }
    public void initweapons()
    {
        if(countfromrecords(weapons_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + weapons_table_name + "(Title, Body, Date, Location) VALUES ('Old Spear', 'It is an Old Spear', '11/11/2024', 'Starter Weapon');");
            db.close();
        }
        if(countfromrecords(weapons_comments_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + weapons_comments_table_name + "(Body, Likes, Dislikes, Itemdid, Usersid) VALUES ('This is the best starter weapon in the game.', 10, 0, 1, 2);");
            db.close();
        }
    }
    public void initenemies()
    {
        if(countfromrecords(enemies_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            //db.execSQL("INSERT INTO " + enemies_table_name = "(Title, Body, Date, Location VALUES ('Zombie', 'It is an basic enemy in the game. Stats: 15 Hp, 1 Speed, 2 Damage, Solar Weakness', '11/11/2024', 'Deep Forest');");
        }
    }
    public void initposts()
    {

    }
    public void initbookmark()
    {

    }
    public void inithistory()
    {

    }
    public void initcomments()
    {

    }
    public int countfromrecords(String tablename)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        int rows = (int) DatabaseUtils.queryNumEntries(db, tablename);
        db.close();
        return rows;
    }
    //end
    //checking user login
   public User checkinguser(String username, String password)
   {
       SQLiteDatabase db = this.getReadableDatabase();
       String quary = "Select * From " + users_table_name + " WHERE Username = '" + username + "' AND  Password = '" + password + "';";
       Cursor cursor = db.rawQuery(quary, null);
       if(cursor.moveToFirst())
       {
           User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
           return user;

       }

       return null;
   }


}
