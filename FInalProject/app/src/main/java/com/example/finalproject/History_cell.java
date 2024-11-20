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
import java.util.Date;

public class History_cell extends BaseAdapter {

    Context context;
    DatabaseHelper dbhelper;

    public History_cell(Context c, DatabaseHelper db)
    {
        context =c;
        dbhelper = db;
    }


    @Override
    public int getCount() {
        return dbhelper.countfromrecords(dbhelper.getHistory_table_name());
    }

    @Override
    public Object getItem(int i) {
        return 0;
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
            view = inflater.inflate(R.layout.activity_history_cell, null);
        }
        TextView Title = view.findViewById(R.id.tv_v_hiscell_title);
        TextView Likes = view.findViewById(R.id.tv_v_hiscell_likes);
        TextView Dislikes = view.findViewById(R.id.tv_v_hiscell_dislikes);
        TextView Date = view.findViewById(R.id.tv_v_hiscell_date);
        HistoryData ht = dbhelper.gethistoryinfo(i + 1);
        Title.setText(ht.getTitle());
        Likes.setText(ht.getLikes());
        Dislikes.setText(ht.getDislikes());
        Date.setText(ht.getDate());


        return view;
    }
}