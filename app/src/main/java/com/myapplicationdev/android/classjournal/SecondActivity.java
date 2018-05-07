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

    ListView lvGrades;
    ArrayAdapter aa;
    ArrayList<DailyCA> dailyCA;
    Button btnInfo, btnAdd, btnEmail;
    int requestCodeForInfo = 1;
    int requestCodeForAdd = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        final Module module = (Module) intent.getSerializableExtra("module");
        String moduleName = module.getModule();
        final String moduleCode = module.getModuleCode();
        String moduleLink = module.getModuleLink();

        getSupportActionBar().setTitle("Info for " + moduleCode);

        lvGrades = (ListView) findViewById(R.id.lvGrades);

        dailyCA = new ArrayList<DailyCA>();
        dailyCA.add(new DailyCA("B", module.getModuleCode(), 1));

        aa = new DailyCAArrayAdapter(this, R.layout.row, dailyCA);
        lvGrades.setAdapter(aa);

        btnInfo = (Button) findViewById(R.id.buttonInfo);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnEmail = (Button) findViewById(R.id.buttonEmail);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moduleIntent = new Intent(Intent.ACTION_VIEW);
                moduleIntent.setData(Uri.parse(module.getModuleLink()));
                startActivity(moduleIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, AddDataActivity.class);
                int weekNumber = dailyCA.size()+ 1;
                DailyCA dailyAdd = new DailyCA("F",moduleCode,weekNumber);
                i.putExtra("week", dailyAdd);
                startActivityForResult(i, requestCodeForAdd);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Hi faci,\nI am... \nPlease see my remarks so far, thank you!\n\n\n";
                for(int i=0;i<dailyCA.size();i++){
                    DailyCA dailyInfo = dailyCA.get(i);
                    text += "Week " + (i+1)+": DG:"+ dailyInfo.getDgGrade()+"\n";
                }
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT, text );
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client : "));
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
                // If 2nd activity started by clicking
                //  Batman, create a corresponding String
                if(requestCode == requestCodeForAdd){
                        DailyCA daily = (DailyCA) data.getSerializableExtra("newWeek");
                        dailyCA.add(daily);
                        aa.notifyDataSetChanged();
                }

            }
        }
    }

}
