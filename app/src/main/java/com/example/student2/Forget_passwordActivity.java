package com.example.student2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Forget_passwordActivity extends AppCompatActivity {
    FirebaseAuth fAuth;
    EditText text1;
    Button send_link;
    ProgressBar progressBar;

    public static Intent makeIntent(Context context) {
        return new Intent(context,Forget_passwordActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        text1=(EditText)findViewById(R.id.email_link);
        send_link=(Button)findViewById(R.id.send_link);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);


        fAuth = FirebaseAuth.getInstance();

        send_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String email=text1.getText().toString().trim();
                if(!email.isEmpty()) {
                    fAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Forget_passwordActivity.this, "Password reset Link send to your mail", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }
                    });


                }
                else {
                    Toast.makeText(Forget_passwordActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
