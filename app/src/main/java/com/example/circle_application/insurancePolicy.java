package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class insurancePolicy extends AppCompatActivity {
    TextView insurancePolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_policy);

        insurancePolicy = (TextView) findViewById(R.id.insurancepolicy);
        insurancePolicy.setMovementMethod(new ScrollingMovementMethod());
    }
}