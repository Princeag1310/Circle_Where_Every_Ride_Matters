package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class aboutUs extends AppCompatActivity {
    TextView aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        aboutus=(TextView) findViewById(R.id.aboutus);
        aboutus.setMovementMethod(new ScrollingMovementMethod());
    }
}