package com.example.student2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyCrimeAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
//private final Integer[] imgid;

    public MyCrimeAdapter(Activity context, String[] maintitle, String[] subtitle) {
        super(context, R.layout.criminals_list, maintitle);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
        //this.imgid=imgid;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.criminals_list, null, true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.icon);

        titleText.setText(maintitle[position]);
        //imageView.setImageResource(imgid[position]);
        subtitleText.setText(subtitle[position]);

        return rowView;

    }

    ;
}

