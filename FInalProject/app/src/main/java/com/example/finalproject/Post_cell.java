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

public class Post_cell extends BaseAdapter {
Context context;
DatabaseHelper dbhelper;

public Post_cell(Context c, DatabaseHelper db)
{
    context = c;
    dbhelper = db;
}


    @Override
    public int getCount() {
        return dbhelper.countfromrecords(dbhelper.getPost_table_name());
    }

    @Override
    public Object getItem(int i) {
    Post_info pi = dbhelper.getPostinfo(i + 1);
        return pi;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

    if (view == null)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Login.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_post_cell, null);
    }
        TextView Title = view.findViewById(R.id.Post_v_Title);
        TextView Likes = view.findViewById(R.id.Post_v_Likes);
        TextView Dislikes = view.findViewById(R.id.Post_v_Dislikes);
        Post_info pi = dbhelper.getPostinfo(i + 1);
        if(pi != null) {
            Title.setText(pi.getTitle());
            Likes.setText(pi.getLikes() + "");
            Dislikes.setText(pi.getDislikes() + "");
        }
        return view;
    }
}