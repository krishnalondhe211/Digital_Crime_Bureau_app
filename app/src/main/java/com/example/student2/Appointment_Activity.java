package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Appointment_Activity extends AppCompatActivity  {
    EditText fullname,gender,date,time,reason;
    Spinner district,station;
    Button submit;
    String stationarray[]=null;
    String districtarray[]=null;
    public String district1,station1;
    DatabaseReference DatabaseLogin;

    public static Intent makeIntent(Usermenu usermenu) {
        return new Intent(usermenu,Appointment_Activity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_);
        fullname=(EditText) findViewById(R.id.fullname);
        gender=(EditText)findViewById(R.id.gender);
        date=(EditText)findViewById(R.id.date);
        time=(EditText)findViewById(R.id.time);
        reason=(EditText)findViewById(R.id.reason);
        submit=(Button) findViewById(R.id.submit_appointment);


        district=(Spinner)findViewById(R.id.district_spinner);
        station=(Spinner)findViewById(R.id.policestation_spinner);
        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    stationarray=new String[]{"Select"};
                }
                if(i==1)
                {
                    stationarray=new String[]{"Select","Ausa Police Station","Latur Station","Nilaga Station","Murud Station"};
                }
                if(i==2)
                {
                    stationarray=new String[]{"Select","Satara Station","Karad Police Station","Saidapur Police Station"};
                }
                if(i==3)
                {
                    stationarray=new String[]{"Select","Andheri Station","Central East Station","India Gate Station","Taj Hotel Station","Navi Mumbai Station","IITB Station"};
                }
                if(i==4)
                {
                    stationarray=new String[]{"Select","Swargate Station","Coep Station","central Pune Station"};
                }
                ArrayAdapter<String> adt=new ArrayAdapter<String>(Appointment_Activity.this,android.R.layout.simple_list_item_1,stationarray);
                station.setAdapter(adt);
                district1=district.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                station1=station.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String fullname1,gender1,date1,time1,reason1,district_name,station_name;
               fullname1=fullname.getText().toString().trim();
               gender1=gender.getText().toString().trim();
               date1=date.getText().toString().trim();
               time1=time.getText().toString().trim();
               reason1=reason.getText().toString().trim();
               district_name=district1;
               station_name=station1;
               if(fullname1.isEmpty()){
                   fullname.setError("FullName Required");
                   fullname.requestFocus();
               }
               else if(gender1.isEmpty()){
                   gender.setError("Gender is Reuired");
                   gender.requestFocus();
               }
               else if(date1.isEmpty()){
                   date.setError("Date is Required");
                   date.requestFocus();
               }
               else if(time1.isEmpty()){
                   time.setError("Time is Required");
                   time.requestFocus();
               }
               else if(reason1.isEmpty()){
                   reason.setError("Reason Is Required");
                   reason.requestFocus();
               }

               else if(!fullname1.isEmpty() && !gender1.isEmpty() && !date1.isEmpty() && !time1.isEmpty() && !reason1.isEmpty()){
                   DatabaseLogin = FirebaseDatabase.getInstance().getReference("appointment_application").child(station_name);


                   Appointment_DB appointment=new Appointment_DB(fullname1,gender1,date1,time1,reason1,district_name,station_name);

                   DatabaseLogin.child(fullname1).setValue(appointment);
                   Toast.makeText(Appointment_Activity.this,"Successfully Applyed for Appointment",Toast.LENGTH_SHORT).show();
                   finish();
               }
            }
        });
    }


}
