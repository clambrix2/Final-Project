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

public class WikiComment_cell extends BaseAdapter {


    Context context;
    DatabaseHelper dbhelper;
    public WikiComment_cell(Context c, DatabaseHelper db)
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
        Comment c = dbhelper.getcommentinfo(i + 1, Wikiinfo.getId(), Wikiinfo.getType());
        return c;
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
            view = inflater.inflate(R.layout.activity_wiki_comment_cell, null);
        }
        TextView Commentbody = view.findViewById(R.id.tv_v_comments_cell_comment);
        TextView Likes = view.findViewById(R.id.tv_v_commentslist_likes);
        TextView Dislikes = view.findViewById(R.id.tv_v_comments_cell_dislikes);
        Comment com = dbhelper.getwikicommentinfo(i + 1,Wikiinfo.getId(),Wikiinfo.getType());
        Log.d("Body", com.getBody() + "");

        if(Comment.getBody() != null)
        {
            Log.d("Put info", "INto the comment");
            Commentbody.setText(Comment.getBody());
            Likes.setText(Comment.getLikes() + "");
            Dislikes.setText(Comment.getDislikes() + "");
        }





        return view;
    }
}