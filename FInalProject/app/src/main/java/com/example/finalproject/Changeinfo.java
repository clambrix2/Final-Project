package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Changeinfo extends AppCompatActivity {

    EditText et_j_change_newpassword;
    EditText et_j_change_confirmpassword;
    TextView tv_j_change_error;
    Button btn_j_change_goback;
    Button btn_j_change_edit;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_changeinfo);
        et_j_change_newpassword = findViewById(R.id.et_v_change_newpassword);
        et_j_change_confirmpassword = findViewById(R.id.et_v_change_confirmpassword);
        btn_j_change_goback = findViewById(R.id.btn_v_change_goback);
        btn_j_change_edit = findViewById(R.id.btn_v_change_edit);
        tv_j_change_error = findViewById(R.id.tv_v_change_error);
        tv_j_change_error.setVisibility(View.INVISIBLE);
        dbhelper = new DatabaseHelper(this);

        onclicklinster();

    }

    public void onclicklinster()
    {
        btn_j_change_goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Changeinfo.this, User_Page.class));
            }
        });
        btn_j_change_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_j_change_newpassword.getText().toString().equals(et_j_change_confirmpassword.getText().toString()))
                {
                    tv_j_change_error.setVisibility(View.VISIBLE);
                }
                else
                {
                    dbhelper.updatepassword(et_j_change_newpassword.getText().toString());
                    startActivity(new Intent(Changeinfo.this, User_Page.class));
                }

            }
        });
    }
}