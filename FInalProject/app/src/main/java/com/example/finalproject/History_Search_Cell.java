package com.example.finalproject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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

public class History_Search_Cell extends BaseAdapter {
Context context;
DatabaseHelper dbhelper;
String search;

public History_Search_Cell(Context c, DatabaseHelper db, String s)
{
    context = c;
    dbhelper = db;
    search = s;
}


    @Override
    public int getCount() {
        return dbhelper.searchhistorycount9(search);
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
            view = inflater.inflate(R.layout.activity_history_search_cell, null);
        }
        TextView Title = view.findViewById(R.id.tv_v_hiscell_title);
        TextView Likes = view.findViewById(R.id.tv_v_hiscell_likes);
        TextView Dislikes = view.findViewById(R.id.tv_v_hiscell_dislikes);
        TextView Date = view.findViewById(R.id.tv_v_hiscell_date);
        Log.d("Here", " In History search cell");
        HistoryData hi = dbhelper.searchhistorytime(search, i);
        if(hi  != null)
        {
            Title.setText(hi.getTitle());
            Likes.setText(hi.getLikes());
            Dislikes.setText(hi.getDislikes());
            Date.setText(hi.getDate());
        }
        return view;
    }
}