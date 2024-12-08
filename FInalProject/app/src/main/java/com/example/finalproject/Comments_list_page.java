package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Comments_list_page extends AppCompatActivity {
    ImageView User;
    ImageView Weapon;
    ImageView Item;
    ImageView Enemy;
    ImageView Soical;
    ImageView Goback;
    ImageView Create;
    ListView Comments;
    DatabaseHelper dbhelper;
    Comments_cell adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comments_list_page);
        User = findViewById(R.id.btn_v_comments_user);
        Weapon = findViewById(R.id.btn_v_comments_weapon);
        Item = findViewById(R.id.btn_v_comments_item);
        Enemy = findViewById(R.id.btn_v_comments_enemy);
        Soical = findViewById(R.id.btn_v_comments_soical);
        Goback = findViewById(R.id.btn_comments_goback);
        Create = findViewById(R.id.btn_v_comments_create);
        Comments = findViewById(R.id.lv_v_comments_comments);
        dbhelper = new DatabaseHelper(this);
        fillinfo();
        onclicklinster();

    }
    public void fillinfo()
    {
        Log.d("Hello", "Made it to Commentlistpage");
        adapter = new Comments_cell(this,dbhelper);
        Log.d("Hello", "Made it to Commentlistpage");
        Comments.setAdapter(adapter);
    }

    public void onclicklinster()
    {
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Comments_list_page.this, User_Page.class));
            }
        });
        Weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Comments_list_page.this, Weapon_Wiki.class));

            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Comments_list_page.this, Items_Wiki.class));

            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Comments_list_page.this, Enemies_Wiki.class));

            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(Comments_list_page.this, Soicals_list_page.class));
            }
        });
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(Comments_list_page.this, Create_Comments.class);
                pass.putExtra("Id", 1);
                startActivity(pass);
            }
        });
    }


}