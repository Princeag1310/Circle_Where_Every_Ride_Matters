package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class driverPastExperience extends AppCompatActivity {

    TextView tvpast , tv100, tv101 , tv102 , tv103 ,tv104;
    EditText et100 , et101 , et102 ,et103 , et104 , et105;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_past_experience);

        tvpast=findViewById(R.id.tvpast);
        tv100=findViewById(R.id.tv100);
        tv101=findViewById(R.id.tv101);
        tv102=findViewById(R.id.tv102);
        tv103=findViewById(R.id.tv103);
        tv104=findViewById(R.id.tv105);
        et100=findViewById(R.id.et100);
        et101=findViewById(R.id.et101);
        et102=findViewById(R.id.et102);
        et103=findViewById(R.id.et103);
        et104=findViewById(R.id.et104);
        Intent intent4 = getIntent();
        Intent intent5 = new Intent(driverPastExperience.this , driverPastExperience2.class);
        startActivity(intent5);
        Intent intent10 = new Intent(driverPastExperience.this  , driverAccountDetails.class);
        Intent intent11 = getIntent();

    }
}