package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class termsandconditions1 extends AppCompatActivity {
    TextView conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termsandconditions1);

        conditions = (TextView) findViewById(R.id.conditions);
        conditions.setMovementMethod(new ScrollingMovementMethod());

    }
}