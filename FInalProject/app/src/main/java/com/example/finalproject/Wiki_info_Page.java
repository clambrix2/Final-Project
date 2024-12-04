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
    Intent data;
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
        onclicklinster();
        fillinfo();



    }
    public void onclicklinster()
    {
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public void fillinfo()
    {
       title.setText(Wikiinfo.getTitle());
       body.setText(Wikiinfo.getBody());
       date.setText(Wikiinfo.getDate());
       location.setText(Wikiinfo.getLocation());
    }


}