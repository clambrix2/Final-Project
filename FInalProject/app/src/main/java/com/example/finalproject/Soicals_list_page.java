package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.search.SearchBar;

public class Soicals_list_page extends AppCompatActivity {
    ImageView Users;
    ImageView Weapoon;
    ImageView Item;
    ImageView Enemy;
    ImageView Craete;
    ImageView Search;
    DatabaseHelper dbhelper;
    ListView Post_list;
    Post_cell adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_soicals_list_page);
        Users = findViewById(R.id.iv_v_weapons_user);
        Weapoon = findViewById(R.id.iv_v_weapons_weapon);
        Item = findViewById(R.id.iv_v_weapons_items);
        Enemy = findViewById(R.id.iv_v_weapons_enemies);
        dbhelper = new DatabaseHelper(this);
        Post_list = findViewById(R.id.lv_v_weapon_list);
        Craete = findViewById(R.id.Btn_v_soical_create);
        Search = findViewById(R.id.Btn_v_soical_search);
        onclicklisnter();
        fillinfo();
    }
    public void onclicklisnter()
    {
        Users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soicals_list_page.this, User_Page.class));
            }
        });
        Weapoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soicals_list_page.this, Weapon_Wiki.class));
            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soicals_list_page.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soicals_list_page.this, Enemies_Wiki.class));
            }
        });
        Post_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(Soicals_list_page.this, Soical_Page_Info.class).putExtra("Postid", i));
            }
        });
        Craete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(Soicals_list_page.this, Create_Post.class));
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soicals_list_page.this, Search_Posts.class ));
            }
        });
    }
    public void fillinfo()
    {
        adapter = new Post_cell(this, dbhelper);
        Post_list.setAdapter(adapter);
    }

}