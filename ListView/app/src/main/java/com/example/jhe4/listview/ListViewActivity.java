package com.example.jhe4.listview;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    ListView myLV;
    ArrayAdapter<String> myAdapter;

    String [] android_versions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myLV = (ListView)findViewById(R.id.myListView);

        android_versions = getResources().getStringArray(R.array.android_versions);

        myAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, android_versions);
        myLV.setAdapter(myAdapter);

        myLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)view;
                Toast.makeText(getApplicationContext(), tv.getText() , Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), parent.getItemIdAtPosition(position)+"" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
