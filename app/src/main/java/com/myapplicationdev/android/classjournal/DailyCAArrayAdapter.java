package com.myapplicationdev.android.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DailyCAArrayAdapter extends ArrayAdapter<DailyCA>{
    // Create ArrayList of objects
    private ArrayList<DailyCA> objects;
    // To hold the context object
    private Context context;
    // Create the UI objects to hold the UI elements in row layout
    private TextView tvWeek, tvGrade;

    public DailyCAArrayAdapter(Context context, int resource,
                                 ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        // Store the ArrayList of objects passed to this adapter
        this.objects = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    // getView() is called every time for every row
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  Change R.layout.rowxyz if file is rowxyz.xml .
        View rowView = inflater.inflate(R.layout.row, parent,
                false);
        // Get the TextView object
        tvWeek = (TextView)
                rowView.findViewById(R.id.textViewWeek);

        tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);
        // Parameter "pos" is the index of the
        //  row ListView is requesting.
        //  We get back the object at the same index.
        DailyCA object = objects.get(pos);
        // Set the TextView to show the object info
        tvWeek.setText("Week " + object.getWeek());
        tvGrade.setText(object.getDgGrade());
        // Return this row that is being populated.
        return rowView;
    }

}
