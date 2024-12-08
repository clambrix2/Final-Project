package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Create_Comments extends AppCompatActivity {
    ImageView User;
    ImageView Weapon;
    ImageView Item;
    ImageView Enemy;
    ImageView Soical;
    ImageView Goback;
    ImageView Create;
    EditText Body;
    DatabaseHelper dbhelper;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_comments);
        User = findViewById(R.id.btn_v_cratecomments_user);
        Weapon = findViewById(R.id.btn_v_createcomments_weapon);
        Item = findViewById(R.id.btn_v_createcomments_items);
        Enemy = findViewById(R.id.btn_v_createcomments_enemies);
        Soical = findViewById(R.id.btn_v_createcomments_soical);
        Goback = findViewById(R.id.btn_v_createcomments_goback);
        Create = findViewById(R.id.Btn_v_createcomments_create);
        Body = findViewById(R.id.et_v_createcomments_body);
        dbhelper = new DatabaseHelper(this);
        Intent pass = getIntent();
        if(pass.getIntExtra("Id", 0) >= 0)
        {
            id = pass.getIntExtra("Id", 0);
        }
        onclicklisnter();

    }
    public void onclicklisnter()
    {
    User.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Create_Comments.this, User_Page.class));
        }
    });
    Weapon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Create_Comments.this, Weapon_Wiki.class));
        }
    });
    Item.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Create_Comments.this, Items_Wiki.class));
        }
    });
    Enemy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Create_Comments.this, Enemies_Wiki.class));
        }
    });
    Soical.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Create_Comments.this, Soicals_list_page.class));
        }
    });
    Goback.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(id == 0)
            {
                dbhelper.createcomment(Body.getText().toString(), Wikiinfo.getType());
                startActivity(new Intent(Create_Comments.this, WikiComment_page.class));
            }
            else
            {
                startActivity(new Intent(Create_Comments.this, Comments_list_page.class));
            }
        }
    });
    Create.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(id == 0)
            {
                Log.d("Wiki Type", Wikiinfo.getType() + "");
                dbhelper.createcomment(Body.getText().toString(), Wikiinfo.getType());
                startActivity(new Intent(Create_Comments.this, User_Page.class));
            }
            else
            {
                dbhelper.createcomment(Body.getText().toString(), "Posts");
                startActivity(new Intent(Create_Comments.this, Comments_list_page.class));
            }
        }
    });
    }

}