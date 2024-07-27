package com.example.circle_application;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class userFragment extends Fragment {


    public userFragment() {
        // Required empty public constructor
    }

    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        listView = view.findViewById(R.id.listview);
        String[] data = {"Review 1","Review 2","Review 3","Review 4","Review 5","Review 6","Review 7","Review 8"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getContext(), R.layout.activity_history_main2, R.id.textView,data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String toastMessage = "Item no "+ position + " is clicked and its id is "+id;
                Toast.makeText(getContext(),toastMessage,Toast.LENGTH_SHORT).show();
            }
        });



        return view;

    }
}