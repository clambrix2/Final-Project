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
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class Search_History extends AppCompatActivity {
    ImageView User;
    ImageView Weapon;
    ImageView Item;
    ImageView Enemy;
    ImageView Soical;
    ImageView Search;
    ListView List;
    Spinner typeofsearch;
    History_Search_Cell adpater;
    ArrayAdapter<String> adapter2;
    DatabaseHelper dbhelper;
    ArrayList<String> Typelist = new ArrayList<>(Arrays.asList("Newest to Oldest", "Oldest to Newest"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_history);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Typelist);
        User = findViewById(R.id.btn_v_search_user);
        Weapon = findViewById(R.id.btn_v_search_weapon);
        Item = findViewById(R.id.btn_v_search_item);
        Enemy = findViewById(R.id.btn_v_search_enemy);
        Soical = findViewById(R.id.btn_v_Search_soical);
        List = findViewById(R.id.lv_v_search_list);
        Search = findViewById(R.id.btn_search);
        typeofsearch = findViewById(R.id.sp_v_history_list);
        typeofsearch.setAdapter(adapter2);
        dbhelper = new DatabaseHelper(this);
        onclick();

    }

    public void onclick()
    {
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_History.this, User_Page.class));
            }
        });
        Weapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_History.this, Weapon_Wiki.class));
            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_History.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Search_History.this, Enemies_Wiki.class));
        }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_History.this, Soicals_list_page.class));
            }
        });
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Help", "ME");
                fillinfo();
            }
        });

    }
    private void fillinfo()
    {
        Log.d("Test one", "Test twp");
        Log.d("test", typeofsearch.getSelectedItem().toString() + "");
         adpater = new History_Search_Cell(this, dbhelper, typeofsearch.getSelectedItem().toString());
        List.setAdapter(adpater);
    }




}