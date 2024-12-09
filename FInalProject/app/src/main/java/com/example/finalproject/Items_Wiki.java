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

public class Items_Wiki extends AppCompatActivity {
    ImageView iv_j_items_user;
    ImageView iv_j_items_items;
    ImageView iv_j_items_enemies;
    ImageView iv_j_items_soical;
    ImageView iv_j_items_weapons;
    ListView lv_j_items_list;
    Wiki_cell adapter;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_items_wiki);
        iv_j_items_user = findViewById(R.id.iv_v_weapons_user);
        iv_j_items_enemies = findViewById(R.id.iv_v_weapons_enemies);
        iv_j_items_items = findViewById(R.id.iv_v_weapons_items);
        iv_j_items_soical = findViewById(R.id.iv_v_weapons_social);
        iv_j_items_weapons = findViewById(R.id.iv_v_weapons_weapon);
        lv_j_items_list = findViewById(R.id.lv_v_weapon_list);
        dbhelper = new DatabaseHelper(this);
        onclicklinster();
        fillinfo();


    }
    public void onclicklinster()
    {
        iv_j_items_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Items_Wiki.this, User_Page.class));
            }
        });
        iv_j_items_weapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Items_Wiki.this, Weapon_Wiki.class));
            }
        });
        iv_j_items_enemies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Items_Wiki.this, Enemies_Wiki.class));
            }
        });
        iv_j_items_soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Items_Wiki.this, Soicals_list_page.class));
            }
        });
        lv_j_items_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(Items_Wiki.this, Wiki_info_Page.class).putExtra("Id", i));
            }
        });
    }
    public void fillinfo()
    {
        adapter = new Wiki_cell(this, dbhelper, dbhelper.getItems_table_name());
        lv_j_items_list.setAdapter(adapter);
    }
}