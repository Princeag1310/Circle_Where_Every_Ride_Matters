package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Intent;
public class driverCarDetails extends AppCompatActivity {

    TextView tv6 , tv7 ,tv8 ,tv9 , tv10;
    EditText et2 , et3 , et4 , et5  , et6;
    Button b3nxt , b3back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_car_details);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        tv9 = findViewById(R.id.tv9);
        tv10 = findViewById(R.id.tv10);
        et2 =findViewById(R.id.et2);
        et3 =findViewById(R.id.et3);
        et4 =findViewById(R.id.et4);
        et5 =findViewById(R.id.et5);
        et6 =findViewById(R.id.et6);
        b3nxt =findViewById(R.id.b3nxt);
        b3back=findViewById(R.id.b3back);
        Intent intent = getIntent();
        b3nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent2  =getIntent();
                b3nxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s1 = et2.getText().toString();
                        String s2 = et3.getText().toString();
                        String s3 = et4.getText().toString();
                        String s4 = et5.getText().toString();
                        String s5 = et6.getText().toString();
                        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()) {
                            Toast.makeText(driverCarDetails.this, "Fill All Information First", Toast.LENGTH_LONG).show();
                        } else {
                            Intent intent3 = new Intent(driverCarDetails.this, driverAccountDetails.class);
                            startActivity(intent3);
                        }
                    }
                });
            }
        });
        Intent intent9  = getIntent();
        b3back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent8 = new Intent(driverCarDetails.this, driverConvinience.class);
                startActivity(intent8);

            }
        });
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean checkbox1Checked = preferences.getBoolean("checkbox1", false);
        boolean checkbox2Checked = preferences.getBoolean("checkbox2", false);


    }
}