package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Admin_LoginActivity extends AppCompatActivity {
    EditText admin_email,admin_password,passkey;
    Button login;
    FirebaseAuth mAuth1;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);
        mAuth1= FirebaseAuth.getInstance();
        admin_email=(EditText)findViewById(R.id.adminemail);
        admin_password=(EditText)findViewById(R.id.adminpassword);
        passkey=(EditText)findViewById(R.id.key);
        login=(Button)findViewById(R.id.adminlogin);
        progressBar=(ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.INVISIBLE);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    final String email=admin_email.getText().toString().trim();
                    String password=admin_password.getText().toString().trim();
                    String passkey1=passkey.getText().toString().trim();
                    if(email.isEmpty())
                    {
                        admin_email.setError("Enter Email");
                        admin_email.requestFocus();
                    }
                    else if(password.isEmpty())
                    {
                        admin_password.setError("Enter Password");
                        admin_password.requestFocus();
                    }
//                    else if(passkey1.isEmpty())
//                    {
//                        passkey.setError("Enter Passkey");
//                        passkey.requestFocus();
//                    }
                    else if(password.length()<6)
                    {
                        admin_password.setError("Password length must be grater than 6");
                        admin_password.requestFocus();
                    }
//                    else if(passkey1.length()<4)
//                    {
//                        passkey.setError("Passkey length must be grater than 4");
//                        passkey.requestFocus();
//                    }
//                    else if(!passkey1.equals("2121")){
//                        passkey.setError("Enter Valid Passkey/If don't have passkey contact on helpline no");
//                        passkey.requestFocus();
//
//                    }
                    else if(!email.isEmpty() && !password.isEmpty()) {
                        mAuth1.signInWithEmailAndPassword(email,password).addOnCompleteListener(Admin_LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                               progressBar.setVisibility(View.VISIBLE);
                                if(task.isSuccessful()){
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(Admin_LoginActivity.this,"Successfully logged in",Toast.LENGTH_SHORT).show();
                                    Intent login = Admin_menuActivity.makeIntent(Admin_LoginActivity.this);
                                    startActivity(login);
                                }
                                else{
                                    Toast.makeText(Admin_LoginActivity.this,"Authentification Failed",Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


                    }
                    else
                    {
                        Toast.makeText(Admin_LoginActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                }


            });
        }


    }

