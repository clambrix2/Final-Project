package com.example.finalproject;

import android.content.ClipData;
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

public class Enemies_Wiki extends AppCompatActivity {
    ImageView Users;
    ImageView Weapons;
    ImageView Items;
    ImageView Soical;
    ImageView Search;
    ListView enemies_list;
    DatabaseHelper dbhelper;
    Wiki_cell adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enemies_wiki);
        Users = findViewById(R.id.iv_v_weapons_user);
        Weapons = findViewById(R.id.iv_v_weapons_weapon);
        Items = findViewById(R.id.iv_v_weapons_items);
        Soical = findViewById(R.id.iv_v_weapons_social);
        enemies_list = findViewById(R.id.lv_v_weapon_list);
        Search = findViewById(R.id.btn_v_s_search);
        dbhelper = new DatabaseHelper(this);
        onclicklinster();
        fillinfo();
    }
    public void onclicklinster()
    {
        Users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Enemies_Wiki.this, User_Page.class));
            }
        });
        Weapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Enemies_Wiki.this, Weapon_Wiki.class));
            }
        });
        Items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Enemies_Wiki.this, Items_Wiki.class));
            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Enemies_Wiki.this, Soicals_list_page.class));
            }
        });
        enemies_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(Enemies_Wiki.this, Wiki_info_Page.class).putExtra("Id", i));
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Enemies_Wiki.this, Wiki_Search.class));
            }
        });
    }
    public void fillinfo()
    {
        adapter = new Wiki_cell(this, dbhelper, dbhelper.getEnemies_table_name());
        enemies_list.setAdapter(adapter);
    }

}