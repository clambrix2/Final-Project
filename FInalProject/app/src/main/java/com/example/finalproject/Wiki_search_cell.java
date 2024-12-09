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

import java.util.ArrayList;

public class Wiki_search_cell extends BaseAdapter {
    Context context;
    DatabaseHelper dbhelper;
    String searchitem;
    int id;
    ArrayList<Wikiidclass> realid;
    String Type;


    public Wiki_search_cell(Context c, DatabaseHelper db, String s)
    {
        context = c;
        dbhelper = db;
        searchitem = s;
    }




    @Override
    public int getCount() {
        return dbhelper.Getsearchcount(searchitem, Wikiinfo.getType(), 0);
    }

    @Override
    public Object getItem(int i) {
        Wikiinfo wi = dbhelper.getweaponinfo(id, Type);
        return wi;
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
            view = inflater.inflate(R.layout.activity_wiki_search_cell, null);
        }
        TextView Title = view.findViewById(R.id.tv_v_search_cell_Title);
        TextView Location = view.findViewById(R.id.tv_v_search_cell_location);
        TextView Date = view.findViewById(R.id.tv_v_search_cell_date);
        TextView Id = view.findViewById(R.id.tv_wiki_realid);
        Wikiinfo wi = dbhelper.Searchwiki(searchitem, Wikiinfo.getType(), i);
        if(wi != null)
        {
            Title.setText(Wikiinfo.getTitle());
            Location.setText(Wikiinfo.getLocation());
            Date.setText(Wikiinfo.getDate());
            Id.setText(Wikiinfo.getId());
            Log.d("Count", "Count");
            id = Wikiinfo.getId();
            Type = Wikiinfo.getType();

        }
        Log.d("Is it null?", Wikiinfo.getTitle() + "");


        return view;
    }
}