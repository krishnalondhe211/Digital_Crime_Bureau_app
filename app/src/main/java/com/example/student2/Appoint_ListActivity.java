package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.student2.R.id.appointment;

public class Appoint_ListActivity extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    //ArrayAdapter<Button> adapter1;
    Appointment_DB user;
    Button confirm;
    String station1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint__list);

        user=new Appointment_DB();
        listView=(ListView)findViewById(R.id.listView);

        station1=getIntent().getStringExtra("station");

        Toast.makeText(this, station1, Toast.LENGTH_SHORT).show();

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference("appointment_application").child(station1);

        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.appointment_list, appointment,list);


        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    user=ds.getValue(Appointment_DB.class);
                    list.add("Name :"+user.getFullname().toString()+"\n"+"Gender :"+user.getGender().toString()+"\n"+"Date :"+user.getDate().toString()+"\n"+"Time :"+user.getTime().toString()+"\n"+"Reason :"+user.getReason().toString());

                }
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Complaint_listActivity.this, ""+specific_list.get(i), Toast.LENGTH_SHORT).show();
                Intent confirm=new Intent(Appoint_ListActivity.this,Confirm_AppointmentActivity.class);
                confirm.putExtra("Name",list.get(i));
                startActivity(confirm);
            }
        });

    }
}
