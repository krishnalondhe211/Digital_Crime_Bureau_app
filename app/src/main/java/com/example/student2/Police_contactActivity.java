package com.example.student2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

public class Police_contactActivity extends AppCompatActivity {


    ListView list;
    MyListAdapter adapter;

    String[] maintitle = {
            "Karad", "Satara", "Pune", "Mumbai", "Solapur", "Sangli", "Kolhapur", "Latur",
            "Wardha", "Aurangabad", "Ahemadnagar", "Nashik", "Amravati", "Nagpur", "Nanded",

    };

   /* String[] subtitle ={
           "02164222233","02162230580","02026122880","02222926006","02172744621","02332373033","02312653960",
            "02382243633","07152232501","09112421294","02423255133","02532305242","07841075383",
            "07122566845","02462234504",
    };


    */

    Integer[] imgid = {
            R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp,
            R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp, R.drawable.ic_call_black_24dp,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_contact);


        adapter = new MyListAdapter(this, maintitle, imgid);
        list = (ListView) findViewById(R.id.list1);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if (position == 0) {
                    //code specific to first list item
                    //Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02164222233"));//change the number
                    startActivity(callIntent);
                } else if (position == 1) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02162230580"));//change the number
                    startActivity(callIntent);
                } else if (position == 2) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02026122880"));//change the number
                    startActivity(callIntent);
                } else if (position == 3) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02222926006"));//change the number
                    startActivity(callIntent);
                } else if (position == 4) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02172744621"));//change the number
                    startActivity(callIntent);
                } else if (position == 5) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02332373033"));//change the number
                    startActivity(callIntent);
                } else if (position == 6) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02312653960"));//change the number
                    startActivity(callIntent);
                } else if (position == 7) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02382243633"));//change the number
                    startActivity(callIntent);
                } else if (position == 8) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:07152232501"));//change the number
                    startActivity(callIntent);
                } else if (position == 9) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:09112421294"));//change the number
                    startActivity(callIntent);
                } else if (position == 10) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02423255133"));//change the number
                    startActivity(callIntent);
                } else if (position == 11) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02532305242"));//change the number
                    startActivity(callIntent);
                } else if (position == 12) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:07841075383"));//change the number
                    startActivity(callIntent);
                } else if (position == 13) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:07122566845"));//change the number
                    startActivity(callIntent);
                } else if (position == 14) {

                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:02462234504"));//change the number
                    startActivity(callIntent);
                }


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menusearch, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
             /*   if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }*/
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}