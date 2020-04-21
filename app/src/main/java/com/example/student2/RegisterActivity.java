package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

     EditText name;
    EditText password;
    EditText email;
    EditText phonenumber;
    EditText cityname;
    Button registration;
    EditText gender;
    public String name1,password1,email1,number,cityname1,gender1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        phonenumber=(EditText)findViewById(R.id.mobileno);
        cityname=(EditText)findViewById(R.id.cityname);
        registration=(Button) findViewById(R.id.registration);
        gender=(EditText) findViewById(R.id.gender);


        registration.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view ) {

                name1 = name.getText().toString().trim();
                password1 = password.getText().toString().trim();
                email1 = email.getText().toString().trim();
                //mobileno1 = phonenumber.getText().toString().trim();
                cityname1 = cityname.getText().toString().trim();
                number = "+91"+phonenumber.getText().toString().trim();
                gender1=gender.getText().toString().trim();

                if(number.isEmpty() || number.length() < 10){
                    phonenumber.setError("Number is required!");
                    phonenumber.requestFocus();
                    return;
                }
                else if(email1.isEmpty()) {
                    email.setError("Enter Email");
                    email.requestFocus();

                }
                else if(password1.isEmpty()){
                    password.setError("Enter Password");
                    password.requestFocus();

                }
                else if(password1.length()<6){
                    password.setError("Enter Password greater than length 6");
                    password.requestFocus();

                }
                else if(name1.isEmpty()){
                    name.setError("Enter Name");
                    name.requestFocus();

                }
                else if(gender1.isEmpty()){
                    gender.setError("Enter Gender");
                    gender.requestFocus();
                }
                else if(cityname1.isEmpty()){
                    cityname.setError("Enter Cityname");
                    cityname.requestFocus();

                }
                else if(!email1.isEmpty() && !password1.isEmpty() && !name1.isEmpty() && !number.isEmpty()&& !cityname1.isEmpty() && !gender1.isEmpty()){

                    Intent intent = new Intent(getApplicationContext(), Verificationotp.class);
                    intent.putExtra("phonenumber", number);
                    intent.putExtra("name", name1);
                    intent.putExtra("password", password1);
                    intent.putExtra("email", email1);
                    intent.putExtra("cityname", cityname1);
                    intent.putExtra("gender",gender1);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Something Went Worng", Toast.LENGTH_SHORT).show();
                }

            }






        });

    }

//    public void register_dbconnect()
//    {
//
//
//        if(name1.isEmpty()){
//            name.setError("Enter Name");
//            name.requestFocus();
//        }
//        else if(password1.isEmpty()){
//            password.setError("Enter Password");
//            password.requestFocus();
//        }
//        else if(email1.isEmpty()){
//            email.setError("Enter Email");
//            email.requestFocus();
//        }
//        else if(number.isEmpty()){
//            phonenumber.setError("Enter MobileNo");
//            phonenumber.requestFocus();
//        }
//        else if(cityname1.isEmpty()){
//            cityname.setError("Enter Cityname");
//            cityname.requestFocus();
//        }
//        else if(!TextUtils.isEmpty(name1)){
//
//
//        }
//        else{
//            Toast.makeText(getApplicationContext(),"You Should Enter the Name",Toast.LENGTH_SHORT).show();
//        }
//    }
}
