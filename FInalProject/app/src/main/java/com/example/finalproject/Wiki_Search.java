package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Wiki_Search extends AppCompatActivity {
    ImageView User;
    ImageView weapon;
    ImageView Item;
    ImageView Enemy;
    ImageView Soical;
    EditText Searchbar;
    ListView Searchlist;
    Wiki_search_cell adapter;
    DatabaseHelper dbhelper;
    boolean searchrun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wiki_search);
        User = findViewById(R.id.btn_v_search_user);
        weapon = findViewById(R.id.btn_v_search_weapon);
        Item = findViewById(R.id.btn_v_search_item);
        Enemy = findViewById(R.id.btn_v_search_enemy);
        Soical = findViewById(R.id.btn_v_Search_soical);
        Searchbar = findViewById(R.id.et_v_search_search);
        Searchlist = findViewById(R.id.lv_v_search_list);
        dbhelper = new DatabaseHelper(this);
        onclick();
        textwatcher();

    }
    public void textwatcher()
    {
        Searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    search();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onclick() {
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_Search.this, User_Page.class));
            }
        });
        weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_Search.this, Weapon_Wiki.class));
            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_Search.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_Search.this, Enemies_Wiki.class));
            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wiki_Search.this, Soicals_list_page.class));
            }
        });
        Searchlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent pass = new Intent(Wiki_Search.this, Wiki_info_Page.class);
                pass.putExtra("Id", -1);
                pass.putExtra("Realid", i);
                startActivity(pass);
            }
        });

    }
    public void search()
    {
            adapter = new Wiki_search_cell(this, dbhelper, Searchbar.getText().toString());
            Searchlist.setAdapter(adapter);
            adapter.notifyDataSetChanged();


    }

}