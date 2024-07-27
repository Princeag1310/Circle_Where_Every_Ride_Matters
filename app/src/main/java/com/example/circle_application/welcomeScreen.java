package com.example.circle_application;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.READ_CALL_LOG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class welcomeScreen extends AppCompatActivity {
    private static final int REQ_CODE = 200;
    Button request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        request = (Button) findViewById(R.id.request);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPer()){
                    Toast.makeText(welcomeScreen.this,"Permission Granted",Toast.LENGTH_SHORT).show();
                    Intent setup = new Intent(welcomeScreen.this, setUpPage.class);
                    startActivity(setup);
                }
                else{
                    ActivityCompat.requestPermissions(welcomeScreen.this, new String[] {ACCESS_FINE_LOCATION,CALL_PHONE,READ_CALL_LOG,ACCESS_COARSE_LOCATION},REQ_CODE);
                }

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==REQ_CODE){
            if(grantResults.length>0){
                int loc1 = grantResults[0];
                int call1 = grantResults[1];
                int call2 = grantResults[2];
                int loc2 = grantResults[3];
                boolean checkLoc1 = loc1 == PackageManager.PERMISSION_GRANTED;
                boolean checkCall1 = call1 == PackageManager.PERMISSION_GRANTED;
                boolean checkCall2 = call2 == PackageManager.PERMISSION_GRANTED;
                boolean checkLoc2 = loc2 == PackageManager.PERMISSION_GRANTED;

                if(checkLoc1 && checkCall1 && checkCall2 && checkLoc2){
                    Toast.makeText(welcomeScreen.this,"Permission Granted",Toast.LENGTH_SHORT).show();
                    Intent setup = new Intent(welcomeScreen.this, setUpPage.class);
                    startActivity(setup);
                }
                else{
                    Toast.makeText(welcomeScreen.this,"Permission Denied",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public boolean checkPer(){

        int result1 = ActivityCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION);
        int result4 = ActivityCompat.checkSelfPermission(this,ACCESS_COARSE_LOCATION);
        int result2 = ActivityCompat.checkSelfPermission(this,CALL_PHONE);
        int result3 = ActivityCompat.checkSelfPermission(this,READ_CALL_LOG);
        return result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED && result3 == PackageManager.PERMISSION_GRANTED && result4 == PackageManager.PERMISSION_GRANTED;
    }
}