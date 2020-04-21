package com.example.student2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Complaint_registerActivity extends AppCompatActivity {
    EditText date1,time1,suspect_name1,suspect_gender1,suspect_age1,suspect_add1,suspect_info1;
    Spinner district,station,crime;
    String stationarray[]=null;
    String districtarray[]=null;
    public String crime1,district1,station1;
    Button submit;
    DatabaseReference DatabaseComplaint;

    public static Intent makeIntent(Context context) {
        return new Intent(context,Complaint_registerActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_register);
        date1=(EditText)findViewById(R.id.date);
        time1=(EditText)findViewById(R.id.time);
       suspect_name1=(EditText)findViewById(R.id.name);
       suspect_gender1=(EditText)findViewById(R.id.gender);
       suspect_age1=(EditText)findViewById(R.id.age);
       suspect_add1=(EditText)findViewById(R.id.address);
       suspect_info1=(EditText)findViewById(R.id.more_info);

       submit=(Button)findViewById(R.id.submit_complaint);

        crime=(Spinner)findViewById(R.id.crime_spinner1);
        district=(Spinner)findViewById(R.id.district_spinner1);
        station=(Spinner)findViewById(R.id.policestation_spinner1);

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
                    ArrayAdapter<String> adt=new ArrayAdapter<String>(Complaint_registerActivity.this,android.R.layout.simple_list_item_1,stationarray);
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



        crime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                crime1=crime.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date,time,crime_a,district_a,station_a,suspect_name,suspect_gender,suspect_age,suspect_address,suspect_info;
                date=date1.getText().toString().trim();
                time=time1.getText().toString().trim();
                suspect_name=suspect_name1.getText().toString().trim();
                suspect_gender=suspect_gender1.getText().toString().trim();
                suspect_age=suspect_age1.getText().toString().trim();
                suspect_address=suspect_add1.getText().toString().trim();
                suspect_info=suspect_info1.getText().toString().trim();
                district_a=district1;
                crime_a=crime1;
                station_a=station1;
                if(date.isEmpty()){
                    date1.setError("Enter Date");
                    date1.requestFocus();
                }
                else if(time.isEmpty()){
                    time1.setError("Enter time");
                    time1.requestFocus();

                }
                else if(suspect_name.isEmpty()){
                    suspect_name1.setError("Enter suspect name");
                    suspect_name1.requestFocus();
                }
                else if(suspect_gender.isEmpty()){
                    suspect_gender1.setError("Enter suspect gender");
                    suspect_gender1.requestFocus();

                }
                else if(suspect_age.isEmpty()){
                    suspect_age1.setError("Enter suspect age");
                    suspect_age1.requestFocus();

                }
                else if(suspect_address.isEmpty()){
                    suspect_add1.setError("Enter Suspect address");
                    suspect_add1.requestFocus();

                }
                else if(suspect_info.isEmpty()){
                       suspect_info1.setError("Enter suspect info");
                       suspect_info1.requestFocus();
                }
                else if(!date.isEmpty() && !time.isEmpty() && !suspect_name.isEmpty()  &&  !suspect_gender.isEmpty()  &&  !suspect_age.isEmpty()  &&  !suspect_address.isEmpty() && !suspect_info.isEmpty()) {

                    DatabaseComplaint = FirebaseDatabase.getInstance().getReference("User_Complaints").child(station_a);

                    Complaint_DB complaint_db=new Complaint_DB(crime_a,district_a,station_a,date,time,suspect_name,suspect_gender,suspect_age,suspect_address,suspect_info);
                  DatabaseComplaint.child(crime_a).setValue(complaint_db);
                    Toast.makeText(Complaint_registerActivity.this,"Complaint Sucessfully Registered",Toast.LENGTH_SHORT).show();
                    finish();

                }


            }
        });





    }


}
