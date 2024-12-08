package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class Create_Wiki extends AppCompatActivity {
    EditText Name;
    EditText Body;
    EditText Location;
    Spinner Types;
    ArrayList<String> typelist =new ArrayList<>(Arrays.asList("Weapon", "Item", "Enemy"));
    ArrayAdapter<String> adapter;
    ImageView goback;
    ImageView create;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_wiki);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, typelist);
        Name = findViewById(R.id.et_v_createwiki_name);
        Body = findViewById(R.id.et_v_createwiki_body);
        Location = findViewById(R.id.et_v_createwiki_location);
        Types = findViewById(R.id.sp_v_createwiki_type);
        goback = findViewById(R.id.btn_v_createwiki_goback);
        create = findViewById(R.id.btn_v_createwiki_create);
        Types.setAdapter(adapter);
        dbhelper = new DatabaseHelper(this);
        onclicklisnter();

    }
    public void onclicklisnter()
    {
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Create_Wiki.this, User_Page.class));
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelper.createwikipage(Types.getSelectedItem().toString(), Name.getText().toString(), Body.getText().toString(), Location.getText().toString());
                startActivity(new Intent(Create_Wiki.this, User_Page.class));
            }
        });
    }

}