package com.example.circle_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class slideBar extends AppCompatActivity {
    BottomNavigationView bnView;
    DrawerLayout drawwer;
    NavigationView slidebar;
    Toolbar threelines;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_bar);

        drawwer = (DrawerLayout) findViewById(R.id.drawwer);
        slidebar = (NavigationView) findViewById(R.id.slidebar);
        threelines = findViewById(R.id.threelines);
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


        setSupportActionBar(threelines);
        toggle = new ActionBarDrawerToggle(this,drawwer,threelines,R.string.OpenDrawer,R.string.CloseDrawer);
        drawwer.addDrawerListener(toggle);
        toggle.syncState();
        slidebar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.history){
                    Intent intentHistory = new Intent(slideBar.this,historyMain.class);
                    startActivity(intentHistory);
                }
                else if(id==R.id.payments){
                }
                else if (id==R.id.insurance) {
                    Intent insuranceIntent = new Intent(slideBar.this,insurancePolicy.class);
                    startActivity(insuranceIntent);
                }
                else if (id==R.id.termsandconditions){
                    Intent terms = new Intent(slideBar.this, termsandconditions1.class);
                    startActivity(terms);
                }
                else {
                    Intent aboutIntent = new Intent(slideBar.this, aboutUs.class);
                    startActivity(aboutIntent);
                }
                drawwer.closeDrawer(GravityCompat.START);
                    return true;
            }
        });
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
        @Override
        public void onBackPressed(){
        if(drawwer.isDrawerOpen(GravityCompat.START)){
            drawwer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
        }
    }
