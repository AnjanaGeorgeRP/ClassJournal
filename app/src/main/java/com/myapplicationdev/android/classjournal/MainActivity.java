package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ModuleAdapter maModule;
    ArrayList<Module> alModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alModule = new ArrayList<>();
        lvModule = findViewById(R.id.listViewModule);
        maModule = new ModuleAdapter(this, R.layout.main_row, alModule);
        lvModule.setAdapter(maModule);

        alModule.add(new Module("Web Service", "C302", "http://rp.edu.sg"));
        alModule.add(new Module("Android Programming II", "C347", "http://rp.edu.sg"));
        maModule.notifyDataSetChanged();

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("module", alModule.get(pos));
                startActivity(intent);
            }
        });
    }
}
