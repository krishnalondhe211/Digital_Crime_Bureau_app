package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Admin_menuActivity extends AppCompatActivity {
    Button appointment_requests,complaint_list,add_criminals,criminal_search1,law1,noc_applications;
    private FirebaseAuth mAuth;
    TextView police_info;
    String email,email_copy,name,post,station;
    DatabaseReference mref;


    public static Intent makeIntent(Context context){
        return new Intent(context,Admin_menuActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        appointment_requests=(Button)findViewById(R.id.appointment_request);
        complaint_list=(Button)findViewById(R.id.complaint_listbutton);
        police_info=(TextView)findViewById(R.id.police_info);
        criminal_search1=(Button)findViewById(R.id.criminal);
        add_criminals=(Button)findViewById(R.id.criminal_search_);
        noc_applications=(Button)findViewById(R.id.noc_app);
        law1=(Button)findViewById(R.id.law);


        mAuth= FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        email=user.getEmail();
        email_copy=email.replace(".","");
        email_copy=email_copy.replace("@","");


        mref=FirebaseDatabase.getInstance().getReference().child("admin").child(email_copy);
        mref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                name=dataSnapshot.child("name").getValue().toString();
                post=dataSnapshot.child("post").getValue().toString();
                station=dataSnapshot.child("station").getValue().toString();


                appointment_requests.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent appoint=new Intent(Admin_menuActivity.this,Appoint_ListActivity.class);
                        appoint.putExtra("station",station);
                        startActivity(appoint);

                    }
                });
                complaint_list.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent complaint1=new Intent(Admin_menuActivity.this,Complaint_listActivity.class);
                        complaint1.putExtra("station",station);
                        startActivity(complaint1);
                    }
                });

                criminal_search1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent criminals=new Intent(Admin_menuActivity.this,Criminals_Record_Activity.class);
                        startActivity(criminals);
                    }
                });
                add_criminals.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent search_criminals=new Intent(Admin_menuActivity.this,Search_CriminalActivity.class);
                        search_criminals.putExtra("station",station);
                        startActivity(search_criminals);

                    }
                });
                law1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent law=new Intent(Admin_menuActivity.this,Laws_Activity.class);
                        startActivity(law);


                    }
                });
                noc_applications.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent noc=new Intent(Admin_menuActivity.this,noc_application_list.class);
                        noc.putExtra("station",station);
                        startActivity(noc);
                    }
                });



                police_info.setText(name+"\n"+post+"\n"+station);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });













    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_complaint_register, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id==R.id.menu_logout)
        {
            finish();
            Toast.makeText(this,"Logged Out",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.menu_settings)
        {
            Intent setting1=new Intent(this,Admin_SettingActivity.class);
            setting1.putExtra("email",email_copy);
            startActivity(setting1);

        }
        return true;
    }

}
