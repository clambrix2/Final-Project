package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText et_j_login_username;
    EditText et_j_login_password;
    TextView tv_j_login_error;
    Button btn_j_login_login;
    ImageView newUser;
    DatabaseHelper dbhelper;
    //testing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        dbhelper = new DatabaseHelper(this);
        dbhelper.initables();
        et_j_login_username = findViewById(R.id.et_v_login_username);
        et_j_login_password = findViewById(R.id.et_v_login_password);
        btn_j_login_login = findViewById(R.id.btn_v_login_login);
        tv_j_login_error = findViewById(R.id.tv_v_login_error);
        tv_j_login_error.setVisibility(View.INVISIBLE);
        newUser = findViewById(R.id.Btn_v_login_newuser);
        onclicklinster();

    }
    public void onclicklinster()
    {
        btn_j_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = dbhelper.checkinguser(et_j_login_username.getText().toString(), et_j_login_password.getText().toString());
                if(user != null)
                {
                    Intent passover = new Intent(Login.this, User_Page.class);
                    startActivity(passover);
                }

            }
        });
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(Login.this, NewUser.class));
            }
        });
    }
}