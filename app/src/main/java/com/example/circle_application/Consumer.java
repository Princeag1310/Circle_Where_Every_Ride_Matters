package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Consumer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer);

        Button backButton = (Button) findViewById(R.id.backButton1);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        EditText mobileNumber = (EditText) findViewById(R.id.mobileNumber);
        TextView numberWarning = (TextView) findViewById(R.id.numberWarning);

        Intent back = new Intent(Consumer.this, MainActivity.class);
        Intent otp = new Intent(Consumer.this, mobileOtp.class);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
                finish();
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = mobileNumber.getText().toString();
                if(mobile.isEmpty()){
                    numberWarning.setText("Enter your mobile number");
                }
                else{
                    otp.putExtra("mobileNum",mobile);
                    startActivity(otp);

                }
            }
        });
    }
}