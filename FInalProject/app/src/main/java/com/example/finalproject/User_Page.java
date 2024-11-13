package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User_Page extends AppCompatActivity {
    Button btn_j_users_bm;
    Button btn_j_users_his;
    Button btn_j_users_changepass;
    Button btn_j_users_Delete;
    TextView tv_j_users_Username;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_page);
        btn_j_users_bm = findViewById(R.id.btn_v_users_bm);
        btn_j_users_his = findViewById(R.id.btn_v_users_his);
        btn_j_users_changepass = findViewById(R.id.btn_v_users_changepass);
        btn_j_users_Delete = findViewById(R.id.btn_v_users_Delete);
        tv_j_users_Username = findViewById(R.id.tv_v_usersinfo_Usersname);
        dbhelper = new DatabaseHelper(this);

        fillinfo(LoginUser.getloginuser().getUserid());
        onclick(LoginUser.getloginuser().getUserid());


    }
    private void fillinfo(int id)
    {
        tv_j_users_Username.setText(dbhelper.getusername(id));
    }
    private void onclick(int id)
    {
        btn_j_users_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(User_Page.this, Login.class));
            }
        });
        btn_j_users_bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(User_Page.this, Bookmarkpaged.class);
                startActivity(info);
            }
        });
    }
}