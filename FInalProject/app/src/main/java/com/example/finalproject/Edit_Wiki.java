package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Edit_Wiki extends AppCompatActivity {

    EditText Title;
    EditText Body;
    EditText Location;
    ImageView Goback;
    ImageView Edit;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_wiki);
        Title = findViewById(R.id.et_v_Editwiki_Title);
        Body = findViewById(R.id.et_v_editwiki_body);
        Location = findViewById(R.id.et_v_editwiki_location);
        Goback = findViewById(R.id.btn_v_editwiki_goback);
        Edit = findViewById(R.id.btn_v_editwiki_edit);
        dbhelper = new DatabaseHelper(this);
        fillinfo();
        onclicklisnter();
    }
    public void fillinfo()
    {
        Title.setText(Wikiinfo.getTitle());
        Body.setText(Wikiinfo.getBody());
        Location.setText(Wikiinfo.getLocation());
    }
    public void onclicklisnter()
    {
        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Edit_Wiki.this, Wiki_info_Page.class));

            }
        });
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelper.Editwiki(Wikiinfo.getType(), Title.getText().toString(), Body.getText().toString(), Location.getText().toString(), Wikiinfo.getId());
                startActivity(new Intent(Edit_Wiki.this, User_Page.class));
            }
        });
    }


}