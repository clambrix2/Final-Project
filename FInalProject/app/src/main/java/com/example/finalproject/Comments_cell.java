package com.example.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Comments_cell extends BaseAdapter {
    Context context;
    DatabaseHelper dbhelper;
    public Comments_cell(Context c, DatabaseHelper db)
    {
        context = c;
        dbhelper = db;
    }


    @Override
    public int getCount() {
        return dbhelper.countfromrecords(dbhelper.getComments_table_name());
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Login.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_comments_cell, null);
        }
        TextView Commentbody = view.findViewById(R.id.tv_v_comments_cell_comment);
        Log.d("Is Post Ative", Post_info.isIsative() + "");

           Comment  com = dbhelper.getcommentinfo(i + 1,Post_info.getPostid(),"Posts");
           if(com != null)
          {
                Commentbody.setText(Comment.getBody());
            }





        return view;
    }



}