package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Verificationotp extends AppCompatActivity {
    private String verificationID ;
    FirebaseAuth firebaseAuth;
    private EditText otp;
    ProgressBar progressBar;
    DatabaseReference Databaseregister;
    public String phonenumber,name,password,email,email_copy,cityname,gender;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificationotp);

        phonenumber = getIntent().getStringExtra("phonenumber");
        name=getIntent().getStringExtra("name");
        password=getIntent().getStringExtra("password");
        email=getIntent().getStringExtra("email").trim();
        cityname=getIntent().getStringExtra("cityname");
        gender=getIntent().getStringExtra("gender");
        mAuth = FirebaseAuth.getInstance();

        email_copy=email;

        email=email.replace(".", "");
        email=email.replace("@","");
        Databaseregister = FirebaseDatabase.getInstance().getReference("registered_user");





        firebaseAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressBar);

        sendVerificationCode(phonenumber);

        findViewById(R.id.checkotpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                otp = (EditText) findViewById(R.id.checkotpEdittext);
                String code = otp.getText().toString().trim();

                if(code.isEmpty() || code.length() < 6){
                    otp.setError("Enter code....!");
                    otp.requestFocus();
                    return;
                }



                verifyCode(code);
            }
        });

    }
    private void verifyCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID,code);
        signInWithCredential(credential);
    }
    private void signInWithCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                  String id = Databaseregister.push().getKey();

                   RegistrationDB register = new RegistrationDB(email_copy,id,name, password,phonenumber,gender,cityname);


                   Databaseregister.child(email).setValue(register);

                    mAuth.createUserWithEmailAndPassword(email_copy,password).addOnCompleteListener(Verificationotp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                // Log.d(TAG, "createUserWithEmail:success");


                                Toast.makeText(Verificationotp.this, "Added to DB", Toast.LENGTH_SHORT).show();


                            }

                            //FirebaseUser user = mAuth.getCurrentUser();
                            // updateUI(user);
                            else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Verificationotp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                // updateUI(null);
                            }
                        }
                    });



                    Toast.makeText(getApplicationContext(),"User Added",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Verificationotp.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                     startActivity(intent);


                }
                else{
                    Toast.makeText(Verificationotp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void sendVerificationCode(String number){
        progressBar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mCallBack);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationID = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if(code != null){
                //otp.setText(code);
                //verifyCode(code);
                Toast.makeText(Verificationotp.this, ""+code, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Verificationotp.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    };


}
