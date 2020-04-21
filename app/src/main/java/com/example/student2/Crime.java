package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Crime extends AppCompatActivity{



    ListView list;
    MyCrimeAdapter adapter;
    String[] maintitle ={
            "Kasab","chota rajan",
    };

    String[] subtitle ={
            "male","female"
    };


    /*

     Integer[] imgid={
             R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,
             R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,
             R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,
             R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,
             R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,R.drawable.ic_call_black_24dp,



     };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);



        list.setAdapter(adapter);


      /*  list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    //Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02164222233"));//change the number
                    startActivity(callIntent);
                }

                else if(position == 1) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02162230580"));//change the number
                    startActivity(callIntent); }

                else if(position == 2) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02026122880"));//change the number
                    startActivity(callIntent); }

                else if(position == 3) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02222926006"));//change the number
                    startActivity(callIntent); }

                else if(position == 4) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02172744621"));//change the number
                    startActivity(callIntent); }




                else if(position == 5) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:02332373033"));//change the number
                startActivity(callIntent); }

                else if(position == 6) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:02312653960"));//change the number
                startActivity(callIntent); }

                else if(position == 7) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:02382243633"));//change the number
                startActivity(callIntent); }

                else if(position == 8) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:07152232501"));//change the number
                    startActivity(callIntent); }

                  else if(position == 9) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:09112421294"));//change the number
                startActivity(callIntent); }

                else if(position == 10) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:02423255133"));//change the number
                startActivity(callIntent); }

                else if(position == 11) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:02532305242"));//change the number
                startActivity(callIntent); }

               else if(position == 12) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:07841075383"));//change the number
                startActivity(callIntent); }

                else if(position == 13) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:07122566845"));//change the number
                    startActivity(callIntent); }

                else if(position == 14) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02462234504"));//change the number
                    startActivity(callIntent); }


            }
        });*/
    }



}

