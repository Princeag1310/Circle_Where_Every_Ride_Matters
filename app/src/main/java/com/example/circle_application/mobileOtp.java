package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mobileOtp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_otp);

        Intent intent = getIntent();
        String mobile = "+91"+intent.getStringExtra("mobileNum");


        Button verify = (Button) findViewById(R.id.verify);
        Button  backButton1= (Button) findViewById(R.id.backButton1);
        Button dotButton = (Button) findViewById(R.id.dotButton);
        Button support = (Button) findViewById(R.id.support);

        TextView verifyotp = (TextView) findViewById(R.id.verifyotp);
        TextView enterotp = (TextView) findViewById(R.id.enterotp);
        TextView invalid = (TextView) findViewById(R.id.invalid);
        TextView showMobileNumber = (TextView) findViewById(R.id.showMobileNumber);
        showMobileNumber.setText(mobile);
        EditText enteringOtp = (EditText) findViewById(R.id.enteringOtp);

        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(mobileOtp.this, Consumer.class);
                startActivity(back);
                finish();
            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = enteringOtp.getText().toString();
                if(otp.isEmpty()){
                    enterotp.setText("Please enter the OTP");
                    verifyotp.setText("");
                    invalid.setText("");
                }
                else if(otp.equals("1234")){
                    verifyotp.setText("Verifying your OTP\nPlease wait....");
                    enterotp.setText("");
                    invalid.setText("");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent next = new Intent(mobileOtp.this, chooseDriverOrConsumer.class);
                            startActivity(next);
                            finish();
                        }
                    },3000);
                }
                else{
                    invalid.setText("Invalid OTP!!");
                    enterotp.setText("");
                    verifyotp.setText("");
                }
            }
        });
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                support.setVisibility(View.VISIBLE);
            }
        });
        support.setVisibility(View.GONE);
    }
}