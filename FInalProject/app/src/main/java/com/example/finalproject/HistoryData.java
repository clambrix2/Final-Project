package com.example.finalproject;


public class HistoryData {
    private String Title;
    private String Likes;
    private String Dislikes;
    private String Date;
    private int Usersid;
    private int postid;
    private String posttype;

    public HistoryData(String t,int pid, String pt, String l, String d, String da, int uid)
    {
        Title = t;
        Likes = l;
        Dislikes = d;
        Date = da;
        postid = pid;
        posttype = pt;
        Usersid = uid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLikes() {
        return Likes;
    }

    public void setLikes(String likes) {
        Likes = likes;
    }

    public String getDislikes() {
        return Dislikes;
    }

    public void setDislikes(String dislikes) {
        Dislikes = dislikes;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getUsersid() {
        return Usersid;
    }

    public void setUsersid(int usersid) {
        Usersid = usersid;
    }
}
