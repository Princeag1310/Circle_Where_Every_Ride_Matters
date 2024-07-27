package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseDriverOrConsumer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_driver_or_consumer);

        Button driver = (Button) findViewById(R.id.driver);
        Button consumer = (Button) findViewById(R.id.consumer);

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent driver1 = new Intent(chooseDriverOrConsumer.this,driverLogin.class);
                startActivity(driver1);
                finish();

            }
        });
        consumer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent permission = new Intent(chooseDriverOrConsumer.this, welcomeScreen.class);
                startActivity(permission);
                finish();
            }
        });
    }
}