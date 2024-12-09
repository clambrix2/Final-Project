package com.example.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Post_Search_cell extends BaseAdapter {
    Context context;
    DatabaseHelper dbhelper;
    String search;

    public Post_Search_cell(Context c, DatabaseHelper db, String s)
    {
        context = c;
        dbhelper = db;
        search = s;
    }


    @Override
    public int getCount() {
        return dbhelper.seachpostcount(search);
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Login.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_post_search_cell, null);
        }
        TextView Title = view.findViewById(R.id.Post_v_Title);
        TextView Likes = view.findViewById(R.id.Post_v_Likes);
        TextView Dislikes = view.findViewById(R.id.Post_v_Dislikes);
        Post_info pi = dbhelper.searchpost(search, i);
        if(pi != null)
        {
            Title.setText(Post_info.getTitle());
            Likes.setText(Post_info.getLikes() + "");
            Dislikes.setText(Post_info.getDislikes() + "");
        }
        return view;
    }
}