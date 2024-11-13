package com.example.finalproject;

public class LoginUser {
    private static User loginuser;
    public static User getloginuser()
    {
        return loginuser;
    }
    public static void setLoginuser(User u)
    {
        loginuser = u;
    }

}
