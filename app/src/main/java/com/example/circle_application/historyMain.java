package com.example.circle_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;

public class historyMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_main);

        String[] data = {"Transaction 1","Transaction 2","Transaction 3","Transaction 4","Transaction 5","Transaction 6","Transaction 7","Transaction 8"};
        ListView listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(historyMain.this, historyMain2.class);
                startActivity(intent);
                //String toastMessage = "Item no "+ position + " is clicked and its id is "+id;
                //Toast.makeText(MainActivity.this,toastMessage,Toast.LENGTH_SHORT).show();

            }
        });
    }
}