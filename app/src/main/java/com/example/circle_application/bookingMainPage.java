package com.example.circle_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bookingMainPage extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_main_page);
        bnView = (BottomNavigationView) findViewById(R.id.bnView);

        bnView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id==R.id.home){
                    loadFragment(new homeFragment(),true);
                }
                else if (id == R.id.car){
                    loadFragment(new carFragment(),false);
                }
                else if (id == R.id.bike){
                    loadFragment(new bikeFragment(),false);
                }
                else{

                }

                return true;
            }
        });
        bnView.setSelectedItemId(R.id.home);

    }
    public void loadFragment(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag){
            ft.add(R.id.mainFrame,fragment);
        }
        else{
            ft.replace(R.id.mainFrame,fragment);
        }
        ft.commit();
    }
}