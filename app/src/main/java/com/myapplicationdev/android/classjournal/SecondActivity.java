package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        Intent intent = getIntent();
//        Module module = (Module) intent.getSerializableExtra("module");
//        Toast.makeText(getApplicationContext(), module.getModuleCode(), Toast.LENGTH_LONG).show();
    }
}
