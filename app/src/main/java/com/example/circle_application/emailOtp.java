package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class emailOtp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_otp);

        Intent nextintent = getIntent();
        String email = nextintent.getStringExtra("emailids");


        Button verifying = (Button) findViewById(R.id.verifying);
        Button  backButton4= (Button) findViewById(R.id.backButton4);
        TextView condition = (TextView) findViewById(R.id.condition);
        TextView showEmailId = (TextView) findViewById(R.id.showEmailId);
        showEmailId.setText(email);
        EditText enteringEmailOtp = (EditText) findViewById(R.id.enteringEmailOtp);

        backButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(emailOtp.this, setUpPage.class);
                startActivity(back);
                finish();
            }
        });
        verifying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = enteringEmailOtp.getText().toString();
                if(otp.isEmpty()){
                    condition.setText("Please enter the OTP");
                }
                else if(otp.equals("123456")){
                    condition.setTextColor(Color.parseColor("#3E3D3D"));
                    condition.setText("Verifying your OTP\nPlease wait....");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent next = new Intent(emailOtp.this, feedback.class);
                            startActivity(next);
                            finish();
                        }
                    },3000);
                }
                else{
                    condition.setText("Invalid OTP!!");
                }
            }
        });
    }
}