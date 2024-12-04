package com.example.finalproject;

public class Wikiinfo
{
    private static String Title;
    private static String Body;
    private static String Date;
    private static String Location;

    public Wikiinfo()
    {}
    public Wikiinfo(String t, String b, String d, String l)
    {
        Title = t;
        Body = b;
        Date = d;
        Location = l;
    }

    public static String getTitle() {
        return Title;
    }

    public static void setTitle(String title) {
        Title = title;
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

    public static String getLocation() {
        return Location;
    }

    public static  void setLocation(String location) {
        Location = location;
    }
}
