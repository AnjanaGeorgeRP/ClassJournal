package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button  btnInfo, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        Intent intent = getIntent();
        final Module module = (Module) intent.getSerializableExtra("module");
        getSupportActionBar().setTitle("Info for " + module.getModuleCode());
        getSupportActionBar().setTitle("Info for " + module.getModuleCode());

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
