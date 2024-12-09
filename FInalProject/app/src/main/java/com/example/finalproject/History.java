package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class History extends AppCompatActivity {

    ListView lv_j_history_historylist;
    ImageView Search;
    ImageView User;
    ImageView Weapon;
    ImageView Items;
    ImageView Enemy;
    ImageView Soical;
    Button btn_j_history_search;
    History_cell adapter;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);
        lv_j_history_historylist = findViewById(R.id.lv_v_history_historylist);
        Search = findViewById(R.id.btn_v_history_search);
        User = findViewById(R.id.btn_history_user);
        Weapon = findViewById(R.id.btn_history_weapon);
        Items = findViewById(R.id.btn_history_item);
        Enemy = findViewById(R.id.btn_history_enemy);
        Soical = findViewById(R.id.btn_history_soical);
        dbhelper = new DatabaseHelper(this);
        setuphistoryview();
        onclicklinster();
    }
    public void onclicklinster()
    {


        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Search_History.class));
            }
        });
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, User_Page.class));
            }
        });
        Weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Weapon_Wiki.class));
            }
        });
        Items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Enemies_Wiki.class));
            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, Soicals_list_page.class));
            }
        });

    }
    public void setuphistoryview()
    {
        adapter = new History_cell(this, dbhelper);
        lv_j_history_historylist.setAdapter(adapter);
    }




}