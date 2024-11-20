package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class History extends AppCompatActivity {

    ListView lv_j_history_historylist;
    Button btn_j_history_tempgoback;
    Button btn_j_history_search;
    History_cell adapter;
    DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);
        lv_j_history_historylist = findViewById(R.id.lv_v_history_historylist);
        btn_j_history_tempgoback = findViewById(R.id.btn_v_history_tempbtn);
        btn_j_history_search = findViewById(R.id.btn_v_history_search);
        dbhelper = new DatabaseHelper(this);
        setuphistoryview();
        onclicklinster();
    }
    public void onclicklinster()
    {
        btn_j_history_tempgoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(History.this, User_Page.class));
            }
        });
    }
    public void setuphistoryview()
    {
        adapter = new History_cell(this, dbhelper);
        lv_j_history_historylist.setAdapter(adapter);
    }


}