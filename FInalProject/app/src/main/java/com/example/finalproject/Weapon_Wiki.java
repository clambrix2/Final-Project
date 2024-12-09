package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Weapon_Wiki extends AppCompatActivity {
    ImageView iv_j_weapons_user;
    ImageView iv_j_weapons_items;
    ImageView iv_j_weapons_enemies;
    ImageView iv_j_weapons_soical;
    ImageView Search;
    ListView lv_j_weapons_list;
    Wiki_cell adpater;
    DatabaseHelper dbhelper;
    Intent data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weapon_wiki);
        iv_j_weapons_user = findViewById(R.id.iv_v_weapons_user);
        iv_j_weapons_enemies = findViewById(R.id.iv_v_weapons_enemies);
        iv_j_weapons_items = findViewById(R.id.iv_v_weapons_items);
        iv_j_weapons_soical = findViewById(R.id.iv_v_weapons_social);
        lv_j_weapons_list = findViewById(R.id.lv_v_weapon_list);
        Search = findViewById(R.id.btn_v_weapon_wiki_search);
        dbhelper = new DatabaseHelper(this);
        onclicklinster();
        filllist();

    }
    public void onclicklinster()
    {
        iv_j_weapons_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weapon_Wiki.this, User_Page.class));
            }
        });
        iv_j_weapons_items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weapon_Wiki.this, Items_Wiki.class));

            }
        });
        iv_j_weapons_enemies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        iv_j_weapons_soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weapon_Wiki.this, Soicals_list_page.class));
            }
        });
        lv_j_weapons_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                data = new Intent(Weapon_Wiki.this, Wiki_info_Page.class);
                data.putExtra("Id", i);
                startActivity(data);
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Weapon_Wiki.this, Wiki_Search.class));
            }
        });
    }
    public void filllist()
    {
     adpater = new Wiki_cell(this, dbhelper, dbhelper.getWeapons_table_name() );
     lv_j_weapons_list.setAdapter(adpater);
    }


}