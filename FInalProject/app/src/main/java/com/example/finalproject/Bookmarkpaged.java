package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bookmarkpaged extends AppCompatActivity {
ListView lv_j_bookmark_bm;
ImageView User;
ImageView Weapon;
ImageView Item;
ImageView Enemy;
ImageView Soical;
ImageView search;
DatabaseHelper dbhelper;
Bookmark_cell adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookmarkpaged);
        lv_j_bookmark_bm = findViewById(R.id.lv_v_bookmark_bm);
        User = findViewById(R.id.btn_v_bookmark_user);
        Weapon = findViewById(R.id.btn_v_bookmark_Weapon);
        Item = findViewById(R.id.btn_v_bookmark_item);
        Enemy = findViewById(R.id.btn_v_bookmark_enemy);
        Soical = findViewById(R.id.btn_v_bookmark_soical);
        search = findViewById(R.id.btn_v_book_search);
        dbhelper = new DatabaseHelper(this);
        filllistview();
        onclick();
    }
    public void onclick()
    {
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bookmarkpaged.this, User_Page.class));
            }
        });
        Weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bookmarkpaged.this, Weapon_Wiki.class));
            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bookmarkpaged.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bookmarkpaged.this, Enemies_Wiki.class));
            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bookmarkpaged.this, Soicals_list_page.class));
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bookmarkpaged.this, Search_Bookmark.class));
            }
        });
    }

    private void filllistview()
    {
        adapter = new Bookmark_cell(this, dbhelper);
        lv_j_bookmark_bm.setAdapter(adapter);


    }

}