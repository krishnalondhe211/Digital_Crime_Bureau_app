package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressbar;
    EditText email;
    EditText password;
    Button login,register,admin;
    TextView forget_password;
   //DatabaseReference DatabaseLogin;
    private FirebaseAuth mAuth;
    private long backpressedtime;
    private Toast backToast;
    @Override
    public void onBackPressed()
    {
        if(backpressedtime+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(this,"Press back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backpressedtime=System.currentTimeMillis();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressbar=(ProgressBar)findViewById(R.id.progressbar) ;
        progressbar.setVisibility(View.INVISIBLE);
        //DatabaseLogin = FirebaseDatabase.getInstance().getReference("login");
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        admin=(Button)findViewById(R.id.adminbutton);
        forget_password=(TextView)findViewById(R.id.forget_password);

        if(!isConnected()){
           new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Internet Connection Alert").setMessage("Please Check your internet connection").setPositiveButton("Close", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   finish();
               }
           }).show();
        }


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent admin=new Intent(MainActivity.this,Admin_LoginActivity.class);
                startActivity(admin);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view ) {
                login_dbconnect();
                

            }
            public void login_dbconnect()
            {

                final String email1 = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(email1.isEmpty())
                {
                    email.setError("Enter Email");
                    email.requestFocus();
                }
                else if(pass.isEmpty()){
                password.setError("Enter Password");
                password.requestFocus();}
                else if(pass.length()<6){
                    password.setError("Password length must be greater than 6 digits");
                    password.requestFocus();}
                else if(!email1.isEmpty() && !pass.isEmpty()){

                    progressbar.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(email1,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                // Log.d(TAG, "signInWithEmail:success");
                                // FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(MainActivity.this, "Successfully Logged IN", Toast.LENGTH_SHORT).show();
                                Intent i =Usermenu.makeIntent(MainActivity.this);
                                progressbar.setVisibility(View.GONE);
                                startActivity(i);
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this, "Connection Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forget_pass=Forget_passwordActivity.makeIntent(MainActivity.this);
                startActivity(forget_pass);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                register_activity();


            }




        });


    }
    public void register_activity()
    {
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
    private boolean isConnected(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo !=null && networkInfo.isConnected();
    }
}
