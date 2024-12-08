package com.example.finalproject;

public class Post_info {
    private static String Title;
    private static int Likes;
    private static int Dislikes;
    private static String Body;
    private static String Date;
    private static int Userid;
    private static int Postid;
    private static boolean isative;

    public Post_info()
    {}
    public Post_info(String t, int l, int dl, String b, String d, int id, int pid, boolean a)
    {
        Title = t;
        Likes = l;
        Dislikes = dl;
        Body = b;
        Date = d;
        Userid = id;
        Postid = pid;
        isative = a;
    }

    public static boolean isIsative() {
        return isative;
    }

    public static void setIsative(boolean isative) {
        Post_info.isative = isative;
    }

    public static String getTitle() {
        return Title;
    }

    public static int getPostid() {
        return Postid;
    }

    public static void setPostid(int postid) {
        Postid = postid;
    }

    public static void setTitle(String title) {
        Title = title;
    }

    public static int getLikes() {
        return Likes;
    }

    public static void setLikes(int likes) {
        Likes = likes;
    }

    public static int getDislikes() {
        return Dislikes;
    }

    public static void setDislikes(int dislikes) {
        Dislikes = dislikes;
    }

    public static String getBody() {
        return Body;
    }

    public static void setBody(String body) {
        Body = body;
    }

    public static String getDate() {
        return Date;
    }

    public static void setDate(String date) {
        Date = date;
    }

    public static int getUserid() {
        return Userid;
    }

    public static void setUserid(int userid) {
        Userid = userid;
    }
}
