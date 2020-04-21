package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirm_AppointmentActivity extends AppCompatActivity {
    String appointment_info;
    TextView confirm_info;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__appointment);

        confirm_info=(TextView)findViewById(R.id.confirm_list);
        confirm=(Button)findViewById(R.id.confirm_buttonid);


        appointment_info=getIntent().getStringExtra("Name");
        confirm_info.setText(appointment_info);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipients="londhekrishna570@gmail.com";
                String[] recipientslist=recipients.split(",");
                String message="Hi Krishna Londhe\nyour Appoitment is confirmed";
                String subject="Appointment Confirmation";
                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, recipientslist);
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email,"choose an email client"));
            }
        });

    }
}
