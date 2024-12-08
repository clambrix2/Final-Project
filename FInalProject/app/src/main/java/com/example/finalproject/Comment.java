package com.example.finalproject;

public class Comment {
    private static String Body;
    private static int Likes;
    private static int Dislikes;
    private static int Postid;
    private static String Posttype;
    private static int Usersid;
    private static int Commentid;

    public Comment()
    {}

    public Comment(String b, int l, int d, int pi, String pt, int u, int c)
    {
        Body =b;
        Likes = l;
        Dislikes = d;
        Postid = pi;
        Posttype = pt;
        Usersid = u;
        Commentid = c;
    }

    public static int getCommentid() {
        return Commentid;
    }

    public static void setCommentid(int commentid) {
        Commentid = commentid;
    }

    public static String getBody() {
        return Body;
    }

    public static void setBody(String body) {
        Body = body;
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

    public static int getPostid() {
        return Postid;
    }

    public static void setPostid(int postid) {
        Postid = postid;
    }

    public static String getPosttype() {
        return Posttype;
    }

    public static void setPosttype(String posttype) {
        Posttype = posttype;
    }

    public static int getUsersid() {
        return Usersid;
    }

    public static void setUsersid(int usersid) {
        Usersid = usersid;
    }
}
