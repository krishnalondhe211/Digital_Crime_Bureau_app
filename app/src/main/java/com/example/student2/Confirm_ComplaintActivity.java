package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm_ComplaintActivity extends AppCompatActivity {
    String sus_info;
    TextView confirm_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__complaint);
        confirm_info=(TextView)findViewById(R.id.confirm_list);


        sus_info=getIntent().getStringExtra("Name");
        confirm_info.setText(sus_info);
    }
}
