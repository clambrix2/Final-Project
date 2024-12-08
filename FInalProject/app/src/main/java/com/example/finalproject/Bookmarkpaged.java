package com.example.finalproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bookmarkpaged extends AppCompatActivity {
ListView lv_j_bookmark_bm;
ImageView iv_j_bookmark_useri;
ImageView iv_j_bookmark_weapons;
ImageView iv_j_bookmark_items;
ImageView iv_j_bookmark_enemies;
ImageView lv_j_bookmark_posts;
DatabaseHelper dbhelper;
Bookmark_cell adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookmarkpaged);
        lv_j_bookmark_bm = findViewById(R.id.lv_v_bookmark_bm);
        dbhelper = new DatabaseHelper(this);
        filllistview();
    }
    private void filllistview()
    {
        adapter = new Bookmark_cell(this, dbhelper);
        lv_j_bookmark_bm.setAdapter(adapter);


    }

}