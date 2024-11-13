package com.example.finalproject;

public class Bookmark
{
    private String Title;
    private String Body;
    private String Date;
    private int postid;
    private String postype;
    public Bookmark()
    {}

    public Bookmark(String t, String b, String d, int id, String p)
    {
        Title = t;
        Body = b;
        Date = d;
        postid = id;
        postype = p;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getPostype() {
        return postype;
    }

    public void setPostype(String postype) {
        this.postype = postype;
    }
}
