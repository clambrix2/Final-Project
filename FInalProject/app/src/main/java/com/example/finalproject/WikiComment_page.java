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

public class WikiComment_page extends AppCompatActivity {
    ImageView User;
    ImageView Weapon;
    ImageView Item;
    ImageView Enemy;
    ImageView Soical;
    ImageView Goback;
    ImageView Create;
    ListView Wikicomments;
    WikiComment_cell adapter;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wiki_comment_page);
        User = findViewById(R.id.btn_v_comments_user);
        Weapon = findViewById(R.id.btn_v_comments_weapon);
        Item = findViewById(R.id.btn_v_comments_item);
        Enemy = findViewById(R.id.btn_v_comments_enemy);
        Soical = findViewById(R.id.btn_v_comments_soical);
        Goback = findViewById(R.id.btn_comments_goback);
        Create = findViewById(R.id.btn_v_comments_create);
        Wikicomments = findViewById(R.id.lv_v_comments_comments);
        dbhelper = new DatabaseHelper(this);
        onclicklinster();
        fillinfo();

    }
    public void fillinfo()
    {
        adapter = new WikiComment_cell(this,dbhelper);
        Wikicomments.setAdapter(adapter);

    }
    public void onclicklinster()
    {
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WikiComment_page.this, User_Page.class));
            }
        });
        Weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WikiComment_page.this, Weapon_Wiki.class));
            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WikiComment_page.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WikiComment_page.this, Enemies_Wiki.class));
            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WikiComment_page.this, Soicals_list_page.class));
            }
        });
        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WikiComment_page.this, Wiki_info_Page.class));
            }
        });
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WikiComment_page.this, Create_Comments.class));
            }
        });
    }


}