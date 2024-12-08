package com.example.finalproject;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

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
        super(c, database_name, null, 21);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
            db.execSQL("CREATE TABLE " + users_table_name + "(Usersid integer primary key autoincrement not null, Username varchar(50), Password varchar(50));");
            db.execSQL("CREATE TABLE " + items_table_name + "(Itemid integer primary key autoincrement not null, Title varchar(50), Body varchar(300), Date varchar(50), location varchar(50));");
            db.execSQL("CREATE TABLE " + weapons_table_name + "(Weaponsid integer primary key autoincrement not null, Title varchar(50), Body varchar(50), Date varchar(50), location varchar(50));");
            db.execSQL("CREATE TABLE " + enemies_table_name + "(Enemiesid integer primary key autoincrement not null, Title varchar(50), Body varchar(50), Date varchar(50), location varchar(50));");
            db.execSQL("CREATE TABLE " + post_table_name + "(Postid integer primary key autoincrement not null, Title varchar(50), Likes, Dislike, Body varchar(50), Date varchar(50),Usersid, foreign key (Usersid) references " + users_table_name + "(Usersid));" );
            db.execSQL("CREATE TABLE " + bookmark_table_name + "(Bookmarkid integer primary key autoincrement not null, Title varchar(50), Body varchar(50), Date varchar(50), postid, posttype varchar(50), Usersid, foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE " + history_table_name + "(Historyid integer primary key autoincrement not null, Title varchar(50), pageid, posttype varchar(50), likes, dislike, Date varchar(50), Usersid, foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE " + comments_table_name + "(Commentid integer primary key autoincrement not null, Username varchar(50), Body varchar(50), Likes, Dislike, Postid, Usersid, foreign key (Postid) references " + post_table_name + "(Postid), foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE "  + items_comments_table_name + "(ItemCommentid integer primary key autoincrement not null, Body varchar(100), Likes, Dislike, Itemid, Usersid, foreign key (Itemid)  references " + items_table_name + "(Itemid), foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE "  + weapons_comments_table_name + "(WeaponCommentid integer primary key autoincrement not null, Body varchar(100), Likes, Dislike,Weaponsid, Usersid, foreign key (Weaponsid)  references " + weapons_table_name + "(Weaponsid), foreign key (Usersid) references " + users_table_name + "(Usersid));");
            db.execSQL("CREATE TABLE "  + enemies_comments_table_name + "(EnemiesCommentid integer primary key autoincrement not null, Body varchar(100), Likes, Dislike,Enemiesid, Usersid, foreign key (Enemiesid)  references " + enemies_table_name + "(Enemiesid), foreign key (Usersid) references " + users_table_name + "(Usersid));");
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
        onCreate(db);

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
    }
    public void initusers()
    {
        if(countfromrecords(users_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + users_table_name + "(Username, Password) VALUES ('Admin', 'thisisanAdmin');");
            db.execSQL("INSERT INTO " + users_table_name + "(Username, Password) VALUES ('User1', 'password');");
            db.execSQL("INSERT INTO " + users_table_name + "(Username, Password) VALUES ('Gitgudgamer', '01702406395')");
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
            int temp = gettheidthatwontwork(1);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + items_comments_table_name + "(Body, Likes, Dislike, Itemid, Usersid) VALUES ('How rare is this item in shops?', 3, 1, '" + temp + "', 2);");
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
            int temp = gettheidthatwontwork(1);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + weapons_comments_table_name + "(Body, Likes, Dislike, Weaponsid, Usersid) VALUES ('This is the best starter weapon in the game.', 3, 3, '" + temp + "', 2);");
            db.close();
        }
    }
    public void initenemies()
    {
        if(countfromrecords(enemies_table_name) == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + enemies_table_name + "(Title, Body, Date, Location) VALUES ('Zombie', 'It is a basic enemy. Stats: 15 hp, 1 Speed, 2 Damage, Solar Weakness.', '11/11/2024', 'Deep Forest');");
            db.close();
        }
        if(countfromrecords(enemies_comments_table_name) == 0)
        {
            int temp = gettheidthatwontwork(1);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + enemies_comments_table_name + "(Body, Likes, Dislike, Enemiesid, Usersid) VALUES ('This Enemy is so hard.', 3, 6, '" + temp + "', 2);");
            db.close();
        }
    }
    public void initposts()
    {
        if(countfromrecords(post_table_name) == 0)
        {
            int temp = gettheidthatwontwork(2);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + post_table_name + "(Title, Likes, Dislike, Body, Date, Usersid) VALUES ('I Think this is the best Weapon', 2,30,'I think the Spear is the best weapon type in the game, it does a lot of damage, has good range, and it is easy to use', '11/13/2014', '" + temp + "');");
            db.close();
        }
        if(countfromrecords(comments_table_name) == 0)
        {
            int temp = gettheidthatwontwork(1);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + comments_table_name + "(Username, Body, Likes, Dislike, Postid, Usersid) VALUES ('Gitgudgamer', 'The Spear is the worst Weapon in the game, it has the lowest speed mod for the player. It turns you into a sitting duck', 10,3,'" + temp + "',3);");
            db.close();
        }
    }
    public void initbookmark()
    {
        if(countfromrecords(bookmark_table_name) == 0)
        {
            int temp = gettheidthatwontwork(2);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + bookmark_table_name + "(Title, Body, Date, postid, posttype, Usersid) VALUES ('I Think this is the best Weapon','I think the Spear is the best weapon type in the game, it does a lot of damage, has good range, and it is easy to use', '11/13/2014', 1, 'Posts', '" + temp + "');");
            db.close();
        }
    }
    public void inithistory()
    {
        if(countfromrecords(history_table_name) == 0)
        {
            int i = gettheidthatwontwork(3);
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + history_table_name + "(Title, pageid, posttype, likes,dislike, Date, Usersid) VALUES ('I Think this is the best Weapon', 1, 'Posts', 2, 30, '11/13/2024', '" + i + "');");
            db.close();
        }
    }
    public int countfromrecords(String tablename)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        int rows = (int) DatabaseUtils.queryNumEntries(db, tablename);
        db.close();
        return rows;
    }
    //end
    //checking  info
   public User checkinguser(String username, String password)
   {
       SQLiteDatabase db = this.getReadableDatabase();
       String quary = "Select * From " + users_table_name + " WHERE Username = '" + username + "' AND  Password = '" + password + "';";
       Cursor cursor = db.rawQuery(quary, null);
       if(cursor.moveToFirst())
       {
           User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
           LoginUser.setLoginuser(user);
           Log.d("user info", LoginUser.getloginuser().getUsername());
           return user;

       }

       return null;
   }
   public boolean checkinbookmark(String tn)
   {
        SQLiteDatabase db = this.getReadableDatabase();
        String quary = "SELECT * From " + tn + " WHERE postid = '" + Post_info.getPostid() + "' AND Usersid = '" + LoginUser.getloginuser().getUserid() + "';";
        Cursor cursor = db.rawQuery(quary, null);

        if(cursor.moveToFirst())
        {
            Log.d("Bookmark", " Already added");
            return true;
        }
        Log.d("Bookmark", "Not Added yet");
       return false;
   }

   //end
    //setting info on pages
    public int gettheidthatwontwork(int i)
    {
        //this is where because the same issue as last time, it wont pick up the 2 as usersid 2 but if i do this it will pick up 2 as usersid 2. it's really dumb and stuipd.
        SQLiteDatabase db = this.getReadableDatabase();
        String quary = "SELECT Usersid FROM " + users_table_name + " WHERE Usersid = '" + i + "';";
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        db.close();
        return cursor.getInt(0);
    }

    public String getusername(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String quary = "Select Username FROM " + users_table_name + " WHERE Usersid = '" + id + "';";
        Cursor cursor = db.rawQuery(quary, null);
        if(cursor.moveToFirst())
        {
                db.close();
            return cursor.getString(0);
        }
        db.close();
        return "Does Not Exist";
    }
   public Bookmark getbookmorakinfo(int i)
   {
       if(countfromrecords(bookmark_table_name) != 0) {
           Log.d("Trying to get bookmark", "");
           Log.d("Id i am using", LoginUser.getloginuser().getUserid() + "");
           SQLiteDatabase db = this.getReadableDatabase();
           String quary = " SELECT * FROM " + bookmark_table_name + " WHERE Usersid = '" + LoginUser.getloginuser().getUserid() + "';";
           Cursor cursor = db.rawQuery(quary, null);
            Log.d("Bookmark count", cursor.getCount() + "");
           if (i <= cursor.getCount()) {
               cursor.move(i);
               Bookmark bm = new Bookmark(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getString(5));
               db.close();
               return bm;
           }
           Log.d("Passed the bookmark", "");
           db.close();
       }
       Log.d("Fail to reach bookmark", "");
       return null;
   }
   public HistoryData gethistoryinfo(int i)
   {
       if(countfromrecords(history_table_name) != 0)
       {
           Log.d("History", "trying to add History");
           SQLiteDatabase db = this.getReadableDatabase();
           String quary = " SELECT * FROM " + history_table_name + " WHERE Usersid = '" + LoginUser.getloginuser().getUserid() + "';";
           Cursor cursor = db.rawQuery(quary, null);
           Log.d("Count", cursor.getCount() + "");
           if(i <= cursor.getCount())
           {
               Log.d("Succefully", "Added History data");
               cursor.move(i);
               HistoryData ht = new HistoryData(cursor.getString(1), cursor.getInt(2), cursor.getString(3),cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7));
               db.close();
               return  ht;
           }
           Log.d("Failed", "To add History Data");
           db.close();
       }
       return null;
   }
   public Wikiinfo getweaponinfo(int i, String tn)
   {
       if (countfromrecords(tn) != 0)
       {
           SQLiteDatabase db = this.getReadableDatabase();
           String quary = " SELECT * FROM " + tn + ";";
           Cursor cursor = db.rawQuery(quary,null);
           if(i <= cursor.getCount())
           {
               cursor.move(i);
               Wikiinfo wi = new Wikiinfo(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), tn, cursor.getInt(0));
               db.close();
               return wi;
           }
       }
       return null;
   }
   public Post_info getPostinfo(int i)
   {
       if (countfromrecords(post_table_name) != 0)
       {
           SQLiteDatabase db = this.getReadableDatabase();
           String quary = " SELECT * FROM " + post_table_name + ";";
           Cursor cursor = db.rawQuery(quary, null);
           if(i <= cursor.getCount())
           {
               cursor.move(i);
               Post_info pi = new Post_info(cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(0), true);
               db.close();
               return pi;
           }
       }


       return  null;
   }
    public Comment getcommentinfo(int i, int pid, String pt)
    {

            SQLiteDatabase db = this.getReadableDatabase();
            String quary  = " SELECT * FROM " + comments_table_name + " WHERE Postid = '" + pid + "';";
            Cursor cursor = db.rawQuery(quary, null);
            Log.d("The Count", cursor.getCount() + "");
            if(i <= cursor.getCount())
            {
                Log.d("Getting", "The Comment");
                cursor.move(i);
                Comment c = new Comment(cursor.getString(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(0));
                db.close();
                return c;
            }
        return null;
    }
    public Comment getwikicommentinfo(int i, int pid, String pt)
    {
        if(countfromrecords(weapons_comments_table_name) != 0 && pt.equals(weapons_table_name))
        {
            SQLiteDatabase db = this.getReadableDatabase();
            String quary  = " SELECT * FROM " + weapons_comments_table_name + " WHERE Weaponsid = '" + pid + "';";
            Cursor cursor = db.rawQuery(quary, null);
            Log.d("Count", cursor.getCount() + "");
            Log.d("Id", pid + "");
            if(i <= cursor.getCount())
            {
                cursor.move(i);
                Comment c =null;
                Comment.setBody(cursor.getString(1));
                Comment.setLikes(cursor.getInt(2));
                Comment.setDislikes(cursor.getInt(3));
                Comment.setPostid(cursor.getInt(4));
                Comment.setUsersid(cursor.getInt(5));
                db.close();
                Log.d("C", c + "");
                return c;
            }
        }
        else if(countfromrecords(items_comments_table_name) != 0 && pt.equals(items_table_name))
        {
            SQLiteDatabase db = this.getReadableDatabase();
            String quary  = " SELECT * FROM " + items_comments_table_name + " WHERE Itemid = '" + pid + "';";
            Cursor cursor = db.rawQuery(quary, null);
            if(i <= cursor.getCount())
            {

                cursor.move(i);
                Comment c = null;
                c.setBody(cursor.getString(1));
                c.setLikes(cursor.getInt(2));
                c.setDislikes(cursor.getInt(3));
                c.setPostid(cursor.getInt(4));
                c.setUsersid(cursor.getInt(5));
                db.close();
                return c;
            }
        }
        else if(countfromrecords(enemies_comments_table_name) != 0 && pt.equals(enemies_table_name))
        {
            SQLiteDatabase db = this.getReadableDatabase();
            String quary  = " SELECT * FROM " + enemies_comments_table_name + " WHERE Enemiesid = '" + pid + "';";
            Cursor cursor = db.rawQuery(quary, null);
            if(i <= cursor.getCount())
            {

                cursor.move(i);
                Comment c = null;
                c.setBody(cursor.getString(1));
                c.setLikes(cursor.getInt(2));
                c.setDislikes(cursor.getInt(3));
                c.setPostid(cursor.getInt(4));
                c.setUsersid(cursor.getInt(5));
                db.close();
                return c;
            }
        }
        return null;
    }










   ///updateing and deleteing stuff
    public void updatepassword(String p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + users_table_name + " SET Password = '" + p + "' WHERE Usersid = '" + LoginUser.getloginuser().getUserid() + "';");
        db.close();
    }
    public void updatelikes(int l)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + post_table_name + " SET Likes = '" + l + "' WHERE Postid = '" + Post_info.getPostid() + "';");
        db.close();
    }
    public void updatedislikes(int d)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + post_table_name + " SET Dislike = '" + d + "' WHERE Postid = '" + Post_info.getPostid() + "';");
        db.close();
    }
    public void addbookmark(String tn, String tp)
    {
        if(tp.equals("Post"))
        {
            Log.d("About to", " Add Bookmark");
            if(!checkinbookmark(tn))
            {
                Log.d("Adding", "Bookmark");
                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL("INSERT INTO " + bookmark_table_name + "(Title, Body, Date, postid , posttype, Usersid) VALUES ('" + Post_info.getTitle() + "','" + Post_info.getBody() + "','" + Post_info.getDate() + "','" + Post_info.getPostid() + "', 'Post' ,'" + LoginUser.getloginuser().getUserid() + "');");
                db.close();
            }

        }
    }
    public void createpost(String t, String b, Date c)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + post_table_name + "(Title, Likes, Dislike, Body, Date, Usersid) VALUES ('" + t + "',0, 0, '" + b + "','" + c.toString() + "', '" + LoginUser.getloginuser().getUserid() + "');");
        db.close();
    }
    public void createuser(String u, String p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + users_table_name + "(Username, Password) VALUES ('" + u + "','" + p + "');");
        db.close();
    }
    public void createwikipage(String tn, String n, String b, String l)
    {
        if(tn.equals("Weapon"))
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + weapons_table_name + "(Title, Body, Date, Location) VALUES ('" + n + "', '" + b +"', '" + Calendar.getInstance().getTime().toString() + "','" + l + "');");
            db.close();

        }
        else if(tn.equals("Item"))
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + items_table_name + "(Title, Body, Date, Location) VALUES ('" + n + "', '" + b +"', '" + Calendar.getInstance().getTime().toString() + "','" + l + "');");
            db.close();
        }
        else if(tn.equals("Enemy"))
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + enemies_table_name + "(Title, Body, Date, Location) VALUES ('" + n + "', '" + b +"', '" + Calendar.getInstance().getTime().toString() + "','" + l + "');");
            db.close();
        }
    }
    public void updatingpost(String t, String b)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + post_table_name + " SET Title = '" + t + "' WHERE Postid = '" + Post_info.getPostid() + "';");
        db.execSQL("UPDATE " + post_table_name + " SET Body = '" + b + "' WHERE Postid = '" + Post_info.getPostid() + "';");
        db.close();

    }
    public void createcomment(String t, String tn)
    {
        if(countfromrecords(weapons_comments_table_name) != 0 && tn.equals(weapons_table_name))
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + weapons_comments_table_name + "(Body, Likes, Dislike, Weaponsid, Usersid) VALUES ('" + t + "', 0, 0, '" + Wikiinfo.getId() + "','" + LoginUser.getloginuser().getUserid() + "');");
            db.close();
        }
        else if(countfromrecords(items_comments_table_name) != 0 && tn.equals(items_table_name))
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + items_comments_table_name + "(Body, Likes, Dislike, Itemid, Usersid) VALUES ('" + t + "', 0, 0, '" + Wikiinfo.getId() + "','" + LoginUser.getloginuser().getUserid() + "';");
            db.close();
        }
        else if (countfromrecords(enemies_comments_table_name) != 0 && tn.equals(enemies_table_name))
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + enemies_comments_table_name + "(Body, Likes, Dislike, Enemiesid, Usersid) VALUES ('" + t + "', 0, 0, '" + Wikiinfo.getId() + "','" + LoginUser.getloginuser().getUserid() + "';");
            db.close();
        }
        else
        {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO " + comments_table_name + "(Username, Body, Likes, Dislike, Postid, Usersid) VALUES ('" + LoginUser.getloginuser().getUsername() + "','" + t + "', 0, 0, '" + Post_info.getPostid() + "', '" + LoginUser.getloginuser().getUserid() + "');");
            db.close();

        }
    }










    //end
   //testing stuff
    public void testing()
    {
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + bookmark_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < bookmark_table_name.length(); i++)
        {
            if(i == 0) {

                Log.d("Bookmark", "Bookmark");
                Log.d("Title", cursor.getString(1));
                Log.d("Body", cursor.getString(2));
                Log.d("Date", cursor.getString(3));
                Log.d("Id", cursor.getInt(4) + "");
                Log.d("Type", cursor.getString(5));
                Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();

    }
    public void testing2()
    {
        Log.d("Users", "Users");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + users_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < users_table_name.length(); i++)
        {
            if(i < 3) {


                Log.d("Title", cursor.getString(1));
                Log.d("Body", cursor.getString(2));
              //  Log.d("Date", cursor.getString(3));
              //  Log.d("Id", cursor.getInt(4) + "");
              //  Log.d("Type", cursor.getString(5));
               // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing3()
    {
        Log.d("Items", "Items");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + items_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < items_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                Log.d("Body", cursor.getString(2));
                Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing4()
    {
        Log.d("Items comments", "Items comments");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + items_comments_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < items_comments_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
              //  Log.d("Body", cursor.getString(2));
               // Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing5()
    {
        Log.d("weapon", "weapon");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + weapons_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < weapons_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                 Log.d("Body", cursor.getString(2));
                 Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing6()
    {
        Log.d("weapon comments", "weapon comment");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + weapons_comments_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < weapons_comments_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                //  Log.d("Body", cursor.getString(2));
                // Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing7()
    {
        Log.d("enemies", "enemies");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + enemies_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < enemies_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                  Log.d("Body", cursor.getString(2));
                 Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing8()
    {
        Log.d("enenies comment", "enemies comment");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + enemies_comments_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < enemies_comments_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                //  Log.d("Body", cursor.getString(2));
                // Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing9()
    {
        Log.d("Posts", "Posts");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + post_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < post_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                Log.d("Body", cursor.getString(4));
                Log.d("Date", cursor.getString(5));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing10()
    {
        Log.d("Comments", "Comments");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + comments_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < comments_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                Log.d("Body", cursor.getString(2));
                // Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }
    public void testing11()
    {
        Log.d("History", "History");
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM " + history_table_name;
        Cursor cursor = db.rawQuery(quary, null);
        cursor.moveToFirst();
        for(int i = 0; i < history_table_name.length(); i++)
        {
            if(i < 1) {


                Log.d("Title", cursor.getString(1));
                 Log.d("posttype", cursor.getString(3));
                // Log.d("Date", cursor.getString(3));
                //  Log.d("Id", cursor.getInt(4) + "");
                //  Log.d("Type", cursor.getString(5));
                // Log.d("Usersid", cursor.getInt(6) + "");
                cursor.moveToNext();
            }
        }
        db.close();
    }







}
