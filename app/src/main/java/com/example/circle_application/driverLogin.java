package com.example.circle_application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class driverLogin extends AppCompatActivity {
    private final int gallery_req_code =1000;
    private final int gallery2_req_code = 2000;
    ImageView img1 , img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);




        EditText et1;
        TextView tv1 , tv2 , tv3 , tv4 ;
        Button button1 ,  button2 , b1nxt;
                et1 = findViewById(R.id.et1);
                tv1 = findViewById(R.id.tv1);
                tv2 = findViewById(R.id.tv2);
                tv3 = findViewById(R.id.tv3);
                tv4 = findViewById(R.id.tv4);
                b1nxt = findViewById(R.id.b1nxt);
                img1 = findViewById(R.id.dlicense);
                img2 = findViewById(R.id.aadhar);
                button1 = findViewById(R.id.button1);
                button2 = findViewById(R.id.button2);
                String s = et1.getText().toString();
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent igallery = new Intent(Intent.ACTION_PICK);
                        igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(igallery ,gallery_req_code );
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent igallery2 = new Intent(Intent.ACTION_PICK);
                        igallery2.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(igallery2 ,gallery2_req_code );
                    }
                });
                b1nxt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String s = et1.getText().toString();
                        if (s.isEmpty()) {

                            Toast.makeText(driverLogin.this , "Please Enter some detail", Toast.LENGTH_LONG).show();
                            return;
                        } else {
                            Intent intent1 = new Intent(driverLogin.this, driverConvinience.class);
                            startActivity(intent1);

                        }
                    }
                });
                Intent intent7= getIntent();
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (resultCode==RESULT_OK){
                    if(requestCode == gallery_req_code){
                        img1.setImageURI(data.getData());
                    }
                    else if(requestCode== gallery2_req_code){
                        img2.setImageURI(data.getData());
                    }

                }

            }
        }