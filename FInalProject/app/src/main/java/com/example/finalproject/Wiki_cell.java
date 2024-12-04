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

public class Wiki_cell extends BaseAdapter {
    DatabaseHelper dbhelper;
    String tablename;
    Context context;

    public Wiki_cell(Context c, DatabaseHelper db, String tn)
    {
        context = c;
        dbhelper = db;
        tablename = tn;
    }

    @Override
    public int getCount() {
        return dbhelper.countfromrecords(tablename);
    }

    @Override
    public Object getItem(int i) {
        Wikiinfo wi = dbhelper.getweaponinfo(i+1, tablename);
        return wi;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Login.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_wiki_cell, null);
        }
        TextView title = view.findViewById(R.id.Wiki_cell_name);
        TextView Date = view.findViewById(R.id.Wiki_cell_date);
        TextView Location = view.findViewById(R.id.Wiki_cell_location);
        Wikiinfo wi = dbhelper.getweaponinfo(i+1, tablename);
        if(wi != null)
        {
            Log.d("Entering", "Wiki Data");
            title.setText(wi.getTitle());
            Date.setText(wi.getDate());
            Location.setText(wi.getLocation());
        }
        Log.d("Skipped pass ", "Wiki info");

        return view;
    }
}
