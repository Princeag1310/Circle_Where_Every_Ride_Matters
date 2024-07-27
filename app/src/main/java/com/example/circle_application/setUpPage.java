package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class setUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_page);

        Button backButton2 = (Button) findViewById(R.id.backButton2);
        Button register = (Button) findViewById(R.id.register);
        EditText email = (EditText)  findViewById(R.id.email);
        EditText fullName = (EditText) findViewById(R.id.fullName);
        TextView nameCondition = (TextView) findViewById(R.id.nameCondition);
        TextView emailCondition = (TextView) findViewById(R.id.emailCondition);



        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(setUpPage.this, welcomeScreen.class);
                startActivity(back);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = fullName.getText().toString();
                String emailid = email.getText().toString();
                if(fullname.isEmpty()&&emailid.isEmpty()){
                    nameCondition.setText("Please enter your Name");
                    emailCondition.setText("Please enter your Email");
                }
                else if(fullname.isEmpty()){
                    nameCondition.setText("Please enter your Name");
                    emailCondition.setText("");
                } else if (emailid.isEmpty()) {
                    nameCondition.setText("");
                    emailCondition.setText("Please enter your Email");
                }
                else if(!(emailid.contains("@gmail.com")||emailid.contains("@reddifmail.com")||emailid.contains("@hotmail.com"))){
                    emailCondition.setText("Invalid Email !!");
                    nameCondition.setText("");

                }
                else if(fullname.contains("1")||fullname.contains("2")||fullname.contains("3")||fullname.contains("4")||fullname.contains("5")||fullname.contains("6")||fullname.contains("7")||fullname.contains("8")||fullname.contains("9")||fullname.contains("0")){
                    nameCondition.setText("Invalid Name !!");
                    emailCondition.setText("");
                }
                 else{
                     Intent emailIntent = new Intent(setUpPage.this,emailOtp.class);
                     emailIntent.putExtra("emailids",emailid);
                     startActivity(emailIntent);

                }
            }
        });
    }
}