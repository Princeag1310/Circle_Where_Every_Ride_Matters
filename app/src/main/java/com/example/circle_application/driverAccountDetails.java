package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class driverAccountDetails extends AppCompatActivity {
    TextView tv11 , tv12 , tv13 ,tv14 ,tv15 ;
    EditText et7 , et8  ,et9 ,et10;
    Button b4nxt , b4back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_account_details);


        Intent intent3 = getIntent();
        tv11 =findViewById(R.id.tv11);
        tv12=findViewById(R.id.tv12);
        tv13=findViewById(R.id.tv13);
        tv14=findViewById(R.id.tv14);
        tv15=findViewById(R.id.tv15);
        et7=findViewById(R.id.et7);
        et8=findViewById(R.id.et8);
        et9=findViewById(R.id.et9);
        et10=findViewById(R.id.et10);
        b4nxt=findViewById(R.id.b4nxt);
        b4back=findViewById(R.id.b4back);
        Intent intent =getIntent();
        Intent intent4 = new Intent(driverAccountDetails.this , driverPastExperience.class);
        startActivity(intent4);

        b4back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(driverAccountDetails.this , driverCarDetails.class);
                startActivity(intent9);
            }
        });
        b4nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s7=et7.getText().toString();
                String s8=et8.getText().toString();
                String s9=et9.getText().toString();
                String s10=et10.getText().toString();
                if(s7.isEmpty() || s8.isEmpty() || s9.isEmpty() || s10.isEmpty()){
                    Toast.makeText(driverAccountDetails.this , "Fill All Information first" , Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(driverAccountDetails.this , "Your Information is Succesfully Submitted!" ,Toast.LENGTH_LONG).show();
                }


            }
        });
        Intent intent10 = getIntent();
    }
}