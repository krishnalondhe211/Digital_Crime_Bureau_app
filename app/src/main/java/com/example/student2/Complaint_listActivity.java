package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

public class Complaint_listActivity extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    ArrayList<String> specific_list = new ArrayList<>();

    Complaint_DB user1;
    String station1,city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);

        user1=new Complaint_DB();
        listView=(ListView)findViewById(R.id.listView);

        station1=getIntent().getStringExtra("station");
        Toast.makeText(this, station1, Toast.LENGTH_SHORT).show();


        mDatabase=FirebaseDatabase.getInstance();

        mRef=mDatabase.getReference("User_Complaints").child(station1);

        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.complaint_list,R.id.complaint_listid,list);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    user1=ds.getValue(Complaint_DB.class);
                    list.add("Crime type :"+user1.getcrime_type().toString()+"\n"+"District :"+user1.getdistrict().toString()+
                            "\n"+"Station area :"+user1.getstation().toString()+"\n"+"Date :"+user1.getdate().toString()+"\n"+
                            "Time :"+user1.gettime().toString()+"\n"+"Suspect name:"+user1.getsuspect_name().toString()+"\n"+
                            "Suspect gender :"+user1.getsuspect_gender().toString()+"\n"+"Suspect age :"+user1.getsuspect_age().toString()+
                            "\n"+"Suspect address :"+user1.getsuspect_address().toString()+"\n"+"Suspect info :"
                            +user1.getsuspect_info().toString()+"\n"+"\n");
                    specific_list.add(user1.getsuspect_name());

                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Complaint_listActivity.this, ""+specific_list.get(i), Toast.LENGTH_SHORT).show();
                Intent confirm=new Intent(Complaint_listActivity.this,Confirm_ComplaintActivity.class);
                confirm.putExtra("Name",list.get(i));
                startActivity(confirm);
            }
        });

//        listView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Complaint_listActivity.this, "Kiss", Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}
