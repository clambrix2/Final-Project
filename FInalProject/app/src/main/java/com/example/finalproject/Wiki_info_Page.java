package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Wiki_info_Page extends AppCompatActivity {
    TextView title;
    TextView body;
    TextView date;
    TextView location;
    ImageView user;
    ImageView weapon;
    ImageView items;
    ImageView enemies;
    ImageView soical;
    ImageView Comments;
    DatabaseHelper dbhelper;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wiki_info_page);
        title = findViewById(R.id.tv_v_wiki_name);
        body = findViewById(R.id.tv_v_wiki_body);
        date = findViewById(R.id.tv_v_wiki_date);
        location = findViewById(R.id.tv_v_wiki_location);
        user = findViewById(R.id.iv_v_wiki_user);
        weapon = findViewById(R.id.iv_v_wiki_weapon);
        items = findViewById(R.id.iv_v_wiki_items);
        enemies = findViewById(R.id.iv_v_wiki_enemies);
        soical = findViewById(R.id.iv_v_wiki_social);
        Comments = findViewById(R.id.btn_v_wikiinfo_comments);
        dbhelper = new DatabaseHelper(this);
        Intent pass = getIntent();
        i = pass.getIntExtra("Id", 0);
        onclicklinster();
        fillinfo();



    }
    public void onclicklinster()
    {
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_info_Page.this, User_Page.class));
            }
        });
        weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_info_Page.this, Weapon_Wiki.class));
            }
        });
        items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_info_Page.this, Items_Wiki.class));
            }
        });
        enemies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_info_Page.this, Enemies_Wiki.class));
            }
        });
        soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_info_Page.this, Soicals_list_page.class));
            }
        });
        Comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_info_Page.this, WikiComment_page.class));
            }
        });

    }
    public void fillinfo()
    {
        Wikiinfo wi = dbhelper.getweaponinfo(i + 1, Wikiinfo.getType());
       title.setText(Wikiinfo.getTitle());
       body.setText(Wikiinfo.getBody());
       date.setText(Wikiinfo.getDate());
       location.setText(Wikiinfo.getLocation());
    }


}