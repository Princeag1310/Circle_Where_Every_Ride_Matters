package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.CompoundButton;


public class driverConvinience extends AppCompatActivity {
    TextView tv1;
    Button b2nxt ,b2back;
    CheckBox cb1 , cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_convinience);
        tv1 = findViewById(R.id.tv1);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        b2nxt=findViewById(R.id.b2nxt);
        b2back=findViewById(R.id.b2back);
        Intent intent = getIntent();
        b2nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(driverConvinience.this  , driverCarDetails.class);
                startActivity(intent1);
                    }
                });

        Intent intent8  = getIntent();
        b2back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(driverConvinience.this , driverLogin.class);
                startActivity(intent7);
            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                            cb2.setChecked(false);
                        }
                b2nxt.setEnabled(isChecked);
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    cb1.setChecked(false);
                }
                b2nxt.setEnabled(isChecked);
            }
        });
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("checkbox1", cb1.isChecked());
        editor.putBoolean("checkbox2", cb2.isChecked());
        editor.apply();
    }
}