package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;
import  java.util.Calendar;

public class Create_Post extends AppCompatActivity {
    EditText Title;
    EditText Body;
    ImageView Goback;
    ImageView Create;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_post);
        Title = findViewById(R.id.et_v_CreatePost_Title);
        Body = findViewById(R.id.Et_v_Createpost_Body);
        Goback = findViewById(R.id.Btn_v_CreatePost_Goback);
        Create = findViewById(R.id.Btn_v_CreatePost_Create);
        dbhelper = new DatabaseHelper(this);
        onclicklinster();

    }
    public void onclicklinster()
    {
        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Create_Post.this, Soicals_list_page.class));

            }

        });
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Title.getText().toString().isEmpty() && !Body.getText().toString().isEmpty())
                {
                    Date Time = Calendar.getInstance().getTime();
                    dbhelper.createpost(Title.getText().toString(), Body.getText().toString(), Time);
                    startActivity(new Intent(Create_Post.this, Soicals_list_page.class));

                }
            }
        });
    }

}