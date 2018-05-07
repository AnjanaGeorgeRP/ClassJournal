package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvGrades;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Module module = (Module) intent.getSerializableExtra("module");
        getSupportActionBar().setTitle("Info for " + module.getModuleCode());
        getSupportActionBar().setTitle("Info for " + module.getModuleCode());

        lvGrades = (ListView) findViewById(R.id.lvGrades);

        dailyCA = new ArrayList<DailyCA>();
        dailyCA.add(new DailyCA("B", module.getModuleCode(), 1));

        aa = new DailyCAArrayAdapter(this, R.layout.row, dailyCA);
        lvGrades.setAdapter(aa);
    }
}
