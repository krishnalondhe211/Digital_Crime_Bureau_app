package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Admin_SettingActivity extends AppCompatActivity {
    Button station;
    EditText station_get;
    String email1;
    DatabaseReference mref;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__setting);
        station=(Button)findViewById(R.id.station_update);
        station_get=(EditText)findViewById(R.id.stationname);

        email1 = getIntent().getStringExtra("email");

        mref= FirebaseDatabase.getInstance().getReference().child("admin");
        station.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stationa=station_get.getText().toString();
                HashMap hashMap=new HashMap();
                hashMap.put("station",stationa);
                mref.child(email1).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(Admin_SettingActivity.this, "Data updated successfully", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
