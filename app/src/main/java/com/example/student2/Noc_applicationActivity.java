package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Noc_applicationActivity extends AppCompatActivity {
    Button submit;
    DatabaseReference database_noc;
    EditText fullname,present_address,home_address,father,mother,life_partner,dob,age,dob_place,education,arressted,politics,present_work,date,station;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_noc_application);

                    fullname=(EditText)findViewById(R.id.name);
                    present_address=(EditText)findViewById(R.id.address1);
                    home_address=(EditText)findViewById(R.id.address2);
                    father=(EditText)findViewById(R.id.name2);
                    mother=(EditText)findViewById(R.id.name3);
                    life_partner=(EditText)findViewById(R.id.name4);
                    dob=(EditText)findViewById(R.id.dob1);
                   age =(EditText)findViewById(R.id.age);
                   dob_place=(EditText)findViewById(R.id.birthplace);
                   education=(EditText)findViewById(R.id.education);
                   arressted=(EditText)findViewById(R.id.question1);
                   politics=(EditText)findViewById(R.id.question2);
                   present_work=(EditText)findViewById(R.id.occupation);
                   date=(EditText)findViewById(R.id.date);
                   submit=(Button)findViewById(R.id.submit);
                   station=(EditText)findViewById(R.id.station);

                   submit.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           String name=fullname.getText().toString().trim();
                           String p_address=present_address.getText().toString().trim();
                           String h_adddress=home_address.getText().toString().trim();
                           String father1=father.getText().toString().trim();
                           String mother1=mother.getText().toString().trim();
                           String partner=life_partner.getText().toString().trim();
                           String dob1=dob.getText().toString().trim();
                           String age1=age.getText().toString().trim();
                           String dob_place1=dob_place.getText().toString().trim();
                           String education1=education.getText().toString().trim();
                           String arrested1=arressted.getText().toString().trim();
                           String politics1=politics.getText().toString().trim();
                           String present_work1=present_work.getText().toString().trim();
                           String date1=date.getText().toString().trim();
                           String station1=station.getText().toString().trim();


                           database_noc= FirebaseDatabase.getInstance().getReference("Noc_Applications").child(station1);

                           Noc_applicationDB db=new Noc_applicationDB(name,p_address,h_adddress,father1,mother1,partner,dob1,age1,dob_place1,education1,arrested1,politics1,present_work1,date1,station1);

                           database_noc.child(name).setValue(db);
                           Toast.makeText(Noc_applicationActivity.this, "Successfully applyed for NOC Certificate", Toast.LENGTH_SHORT).show();






                       }
                   });



    }
}
