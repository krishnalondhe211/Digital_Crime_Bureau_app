package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Criminals_Record_Activity extends AppCompatActivity {
    EditText fullname,gender,age,mobileno,address,alternateAddress,pastrecord;
    Spinner district,station;
    Button submit;
    String stationarray[]=null;
    String districtarray[]=null;
    public String district1,station1;
    DatabaseReference Crimninals_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminals__record_);
        fullname=(EditText) findViewById(R.id.t1);
        gender=(EditText)findViewById(R.id.t2);
        age=(EditText)findViewById(R.id.t3);
        mobileno=(EditText)findViewById(R.id.t4);
        address=(EditText)findViewById(R.id.t5);
        alternateAddress=(EditText)findViewById(R.id.t6);
        pastrecord=(EditText)findViewById(R.id.t7);
        submit=(Button) findViewById(R.id.AddCriminal);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname1,gender1,age1,mobileno1,address1,alternateaddress1,pastrecord1;
                fullname1=fullname.getText().toString().trim();
                gender1=gender.getText().toString().trim();
                age1=age.getText().toString().trim();
                mobileno1=mobileno.getText().toString().trim();
                address1=address.getText().toString().trim();
                alternateaddress1=alternateAddress.getText().toString().trim();
                pastrecord1=pastrecord.getText().toString().trim();


        if(fullname1.isEmpty()){
            fullname.setError("FullName Required");
            fullname.requestFocus();
        }
        else if(gender1.isEmpty()){
            gender.setError("Gender is Reuired");
            gender.requestFocus();
        }
        else if(age1.isEmpty()){
            age.setError("Age is Required");
            age.requestFocus();
        }
        else if(mobileno1.isEmpty()){
            mobileno.setError("Mobile No is Required");
            mobileno.requestFocus();
        }
        else if(address1.isEmpty()){
            address.setError("Address Is Required");
            address.requestFocus();
        }
        else if(alternateaddress1.isEmpty()){
            alternateAddress.setError(" Alternate Address Is Required");
            alternateAddress.requestFocus();
        }
        else if(pastrecord1.isEmpty()){
            pastrecord.setError("PastRecord Is Required");
            pastrecord.requestFocus();
        }

        else if(!fullname1.isEmpty() && !gender1.isEmpty() && !age1.isEmpty() && !mobileno1.isEmpty() && !address1.isEmpty() && !alternateaddress1.isEmpty() && !pastrecord1.isEmpty()){
            Crimninals_data = FirebaseDatabase.getInstance().getReference("Criminals_list").child(alternateaddress1);


            Criminals_record_DB criminal1= new Criminals_record_DB(fullname1,gender1,age1,mobileno1,address1,alternateaddress1,pastrecord1);

            Crimninals_data.child(fullname1).setValue(criminal1);
            Toast.makeText(Criminals_Record_Activity.this,"Successfully Added criminal to Criminal record",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
});
    }
}
