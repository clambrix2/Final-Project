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

import java.time.LocalDate;
import java.util.zip.Inflater;

public class Bookmark_cell extends BaseAdapter {

    Context context;
    DatabaseHelper dbhelper;

    public Bookmark_cell(Context c, DatabaseHelper db)
    {
        context = c;
        dbhelper = db;
    }

    @Override
    public int getCount() {
        return dbhelper.countfromrecords(dbhelper.getBookmark_table_name());
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
        view = inflater.inflate(R.layout.activity_bookmark_cell, null);
    }
        TextView Title = view.findViewById(R.id.tv_j_bookcell_title);
        TextView Body = view.findViewById(R.id.tv_v_bookcell_body);
        TextView Date = view.findViewById(R.id.tv_j_bookcell_date);
        Title.setText(dbhelper.getbookmorakinfo(i + 1).getTitle());
        Body.setText(dbhelper.getbookmorakinfo(i + 1).getBody());
        Date.setText(dbhelper.getbookmorakinfo(i + 1).getDate());
        Log.d("counter", i + "");






        return view;
    }
}