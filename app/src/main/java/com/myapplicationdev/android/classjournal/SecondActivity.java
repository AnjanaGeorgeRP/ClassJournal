package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvGrades;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCA;
    Button btnInfo, btnAdd, btnEmail;
    int requestCodeForInfo = 1;
    int requestCodeForAdd = 2;
    int requestCodeForEmail = 3;

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

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, AddDataActivity.class);
                startActivityForResult(i, requestCodeForAdd);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity

                // If it is activity started by clicking 				//  Superman, create corresponding String
                if(requestCode == requestCodeForInfo){

                }
                // If 2nd activity started by clicking
                //  Batman, create a corresponding String
                if(requestCode == requestCodeForAdd){

                }

                if(requestCode == requestCodeForEmail){

                }
            }
        }
    }

}
