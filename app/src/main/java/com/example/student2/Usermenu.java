package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Usermenu extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView text;

    Button complaints;
    Button appointments;
    Button search;
    Button noc;
    Button contacts1;
    ImageView usericon;
    DatabaseReference mRef;
    public String email,email_copy,name;

    String url_female="https://firebasestorage.googleapis.com/v0/b/student2-be07f.appspot.com/o/girl.png?alt=media&token=70f6f820-fb3a-4b23-8e95-c787826d8607";
    String url_male="https://firebasestorage.googleapis.com/v0/b/student2-be07f.appspot.com/o/man.png?alt=media&token=756aa887-f3e5-46d0-9c52-383a7d67a46a";

    public String gender;
    public static Intent makeIntent(MainActivity mainActivity) {
        return new Intent(mainActivity,Usermenu.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        progressBar1.setVisibility(View.INVISIBLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermenu);
        mAuth = FirebaseAuth.getInstance();
        text=(TextView)findViewById(R.id.text1);
        complaints=(Button)findViewById(R.id.complaint);
        appointments=(Button)findViewById(R.id.appointment);
        search=(Button)findViewById(R.id.search);
        noc=(Button)findViewById(R.id.noc);
        usericon=(ImageView)findViewById(R.id.usericon);
        contacts1=(Button)findViewById(R.id.contacts);

        //TextView textElement = (TextView) findViewById(R.id.set_text);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
           // String name = user.getDisplayName();
            email = user.getEmail();
            email_copy=email.replace(".","");
            email_copy=email_copy.replace("@","");
            mRef=FirebaseDatabase.getInstance().getReference().child("registered_user").child(email_copy);


            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    gender = dataSnapshot.child("gender").getValue().toString();
                    name = dataSnapshot.child("name").getValue().toString();

                    text.setText("Welcome\n"+name+"\n"+email);

//                    Toast.makeText(Usermenu.this, "Rutu "+g, Toast.LENGTH_SHORT).show();
//                    info=new Intent(Usermenu.this,Usermenu.class);
//                    info.putExtra("gen",gender);
                    if(gender.equals("female"))
                    {

                        Picasso.with(Usermenu.this).load(url_female).into(usericon);

                    }
                    else{
                        Picasso.with(Usermenu.this).load(url_male).into(usericon);

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                    Toast.makeText(Usermenu.this, "DB Conncetion failed", Toast.LENGTH_SHORT).show();
                }
            });

             // String va=getIntent().getStringExtra("gen");









            //leave this line to assign a specific text


            // Check if user's email is verified
            //boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
        }
        complaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=Complaint_registerActivity.makeIntent(Usermenu.this);
                startActivity(intent1);
            }
        });
        noc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(Usermenu.this,Noc_applicationActivity.class);
                startActivity(intent2);
            }
        });
        appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=Appointment_Activity.makeIntent(Usermenu.this);
                startActivity(intent3);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent map=new Intent(Usermenu.this,map_activity.class);
            startActivity(map);
            }
        });
        contacts1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact_p=new Intent(Usermenu.this,Police_contactActivity.class);
                startActivity(contact_p);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_userlogin, menu);


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



        }
        return true;
    }



}
