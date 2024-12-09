package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Search_Posts extends AppCompatActivity {
    ImageView User;
    ImageView Weapeon;
    ImageView Item;
    ImageView Enemy;
    ImageView Soical;
    EditText Searchbar;
    ListView List;
    Post_Search_cell adapter;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_posts);
        User = findViewById(R.id.btn_v_search_user);
        Weapeon = findViewById(R.id.btn_v_search_weapon);
        Item = findViewById(R.id.btn_v_search_item);
        Enemy  = findViewById(R.id.btn_v_search_enemy);
        Soical = findViewById(R.id.btn_v_Search_soical);
        Searchbar = findViewById(R.id.et_v_search_search);
        List = findViewById(R.id.lv_v_search_list);
        dbhelper = new DatabaseHelper(this);
        onclick();

    }
    public void fillinfo()
    {
        adapter = new Post_Search_cell(this, dbhelper, Searchbar.getText().toString());
        List.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void onclick()
    {
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_Posts.this, User_Page.class));
            }
        });
        Weapeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_Posts.this, Weapon_Wiki.class));
            }
        });
        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_Posts.this, Items_Wiki.class));
            }
        });
        Enemy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_Posts.this, Enemies_Wiki.class));
            }
        });
        Soical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Search_Posts.this, Soicals_list_page.class));
            }
        });
        Searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    fillinfo();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}