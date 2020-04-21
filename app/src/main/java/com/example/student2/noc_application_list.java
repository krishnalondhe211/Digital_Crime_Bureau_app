package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class noc_application_list extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Noc_applicationDB user2;
    String station1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);

        user2=new Noc_applicationDB();
        listView=(ListView)findViewById(R.id.listView);

        station1=getIntent().getStringExtra("station");

        Toast.makeText(this, station1, Toast.LENGTH_SHORT).show();


        mDatabase=FirebaseDatabase.getInstance();

        mRef=mDatabase.getReference("Noc_Applications").child(station1);

        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.complaint_list,R.id.complaint_listid,list);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    user2=ds.getValue(Noc_applicationDB.class);
                    list.add("Full Name:"+user2.getFullname().toString()+"\n"+"Present Address :"+user2.getPresent_address().toString()+"\n"+"Permanant Address:"+user2.getHome_address().toString()+"\n"+"Father :"+user2.getFather().toString()+"\n"+"Mother :"+user2.getMother().toString()+"\n"+"Life Partner:"+user2.getLife_partner().toString()+"\n"+"DOB :"+user2.getDob().toString()+"\n"+"Age :"+user2.getAge().toString()+"\n"+"Birth Place :"+user2.getDob_place().toString()+"\n"+"Education :"+user2.getEducation().toString()+"\n"+"Arrested :"+user2.getArressted().toString());

                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
