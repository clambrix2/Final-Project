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

public class Edit_Post extends AppCompatActivity {
    EditText Title;
    EditText Body;
    ImageView Goback;
    ImageView Edit;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_post);
        Title = findViewById(R.id.et_v_editpost_title);
        Body = findViewById(R.id.et_v_editpost_body);
        Goback = findViewById(R.id.btn_v_editpost_goback);
        Edit = findViewById(R.id.btn_v_editpost_edit);
        dbhelper = new DatabaseHelper(this);
        fillinginfo();
        onclicklinster();

    }
    public void fillinginfo()
    {
        Title.setText(Post_info.getTitle());
        Body.setText(Post_info.getBody());
    }

    public void onclicklinster()
    {
        Goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Edit_Post.this, Soical_Page_Info.class));
            }
        });
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Title.getText().toString().isEmpty() && !Body.getText().toString().isEmpty())
                {
                    Editingpage();
                    startActivity(new Intent(Edit_Post.this, Soical_Page_Info.class));
                }

            }
        });
    }
    public void Editingpage()
    {
    dbhelper.updatingpost(Title.getText().toString(), Body.getText().toString());
    }


}