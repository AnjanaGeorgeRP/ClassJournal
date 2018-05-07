package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btnInfo, btnAdd, btnEmail;
    ListView lvGrades;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        Intent intent = getIntent();
        Module module = (Module) intent.getSerializableExtra("module");
        getSupportActionBar().setTitle("Info for " + module.getModuleCode());
        getSupportActionBar().setTitle("Info for " + module.getModuleCode());
        lvGrades = (ListView) findViewById(R.id.lvGrades);

        dailyCA = new ArrayList<DailyCA>();
        dailyCA.add(new DailyCA("B", module.getModuleCode(), 1));

        aa = new DailyCAArrayAdapter(this, R.layout.row, dailyCA);
        lvGrades.setAdapter(aa);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moduleIntent = new Intent(Intent.ACTION_VIEW);
                moduleIntent.setData(Uri.parse(module.getModuleLink()));
                startActivity(moduleIntent);
            }
        });
    }
}
