package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddDataActivity extends AppCompatActivity {

    TextView tvWeek;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        tvWeek = (TextView) findViewById(R.id.tvWeek);
        Intent i = getIntent();
        DailyCA dailyInfo = (DailyCA) i.getSerializableExtra("week");
        final int weekNumber = dailyInfo.getWeek();
        final String moduleCode = dailyInfo.getModuleCode();
        tvWeek.setText("Week " + weekNumber);



        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.rgGrade);
                int selectedButtonId = rg.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String grade = rb.getText().toString();


                // Create intent & pass in object data
                DailyCA newWeek =  new DailyCA(grade,moduleCode,weekNumber);
                Intent intent = new Intent();
                intent.putExtra("newWeek", newWeek);
                setResult(RESULT_OK, intent);
                finish();


            }
        });

    }
}
