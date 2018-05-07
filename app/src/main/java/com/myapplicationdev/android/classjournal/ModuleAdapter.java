package com.myapplicationdev.android.classjournal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ModuleAdapter extends ArrayAdapter{
    Context parent_context;
    int layout_id;
    ArrayList<Module> moduleList;

    public ModuleAdapter(Context context,
                         int resource,
                         ArrayList<Module> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        moduleList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        if(rowView == null){
            LayoutInflater inflater = (LayoutInflater)
                    parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(layout_id, parent, false);
        }else{
            rowView = convertView;
        }

        TextView tvCode = rowView.findViewById(R.id.textViewCode);
        TextView tvModule = rowView.findViewById(R.id.textViewModule);

        tvCode.setText(moduleList.get(position).getModuleCode());
        tvModule.setText(moduleList.get(position).getModule());

        return rowView;
    }
}
