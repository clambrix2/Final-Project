package com.example.finalproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText et_j_login_username;
    EditText et_j_login_password;
    Button btn_j_login_login;
    //testing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        et_j_login_username = findViewById(R.id.et_v_login_username);
        et_j_login_password = findViewById(R.id.et_v_login_password);
        btn_j_login_login = findViewById(R.id.btn_v_login_login);

    }
}