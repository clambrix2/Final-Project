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

import java.util.Calendar;

public class Search_Bookmark_cell extends BaseAdapter {

    Context context;
    DatabaseHelper dbhelper;
    String search;

    public Search_Bookmark_cell(Context c, DatabaseHelper db, String s)
    {
        context = c;
        dbhelper = db;
        search = s;
    }

    @Override
    public int getCount() {
        return dbhelper.searchbookmarkcount(search);
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
            view = inflater.inflate(R.layout.activity_search_bookmark_cell, null);
        }
        TextView Title = view.findViewById(R.id.tv_j_bookcell_title);
        TextView Date = view.findViewById(R.id.tv_j_bookcell_date);
        TextView Body = view.findViewById(R.id.tv_v_bookcell_body);
        Bookmark bm = dbhelper.searchbookmark(search, i);
        if(bm != null)
        {
            Title.setText(bm.getTitle());
            Body.setText(bm.getBody());
            Date.setText(bm.getDate());
        }
        return view;
    }
}