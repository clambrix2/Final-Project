package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewUser extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText secondpassword;
    ImageView goback;
    ImageView create;
    DatabaseHelper dbhelper;
    boolean isabletocreate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_user);
        username = findViewById(R.id.et_v_newuser_username);
        password = findViewById(R.id.et_v_newuser_password);
        secondpassword = findViewById(R.id.et_v_newuser_confrim);
        goback = findViewById(R.id.btn_v_newuser_goback);
        create = findViewById(R.id.btn_v_newuser_create);
        dbhelper = new DatabaseHelper(this);
        onclicklinster();

    }


    public void onclicklinster()
    {

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Going", "Back");
                startActivity(new Intent(NewUser.this, Login.class));
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(password.getText().toString().equals(secondpassword.getText().toString()))
            {
                if(username.getText().toString().length() <= 15 && password.getText().toString().length() <= 15 && secondpassword.getText().toString().length() <= 15 ) {
                    Log.d("Creating", "User");
                    dbhelper.createuser(username.getText().toString(), password.getText().toString());
                    startActivity(new Intent(NewUser.this, Login.class));
                }

            }
            }
        });
    }

}