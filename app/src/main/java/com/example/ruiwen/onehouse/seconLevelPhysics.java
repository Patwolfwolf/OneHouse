package com.example.ruiwen.onehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class seconLevelPhysics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon_level_physics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainList();
        clickmainList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//aa
    public void mainList(){
        String[] mainList = {"Electricity ","Mechanic"};
        ArrayAdapter<String> list = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,mainList);
        ListView list1 = (ListView) findViewById(R.id.sclist);
        list1.setAdapter(list);
    }

    public void clickmainList(){
        ListView list1 = (ListView) findViewById(R.id.sclist);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message = "You clicked "+ textView.getText().toString();
                Toast.makeText(seconLevelPhysics.this, message, Toast.LENGTH_SHORT).show();
                if (position == 0){
                    Intent i = new Intent(seconLevelPhysics.this, thirdLevelElectricity.class);
                    startActivity(i);
                }
                if (position == 1){
                    Intent i = new Intent(seconLevelPhysics.this, thirdLevelMachnics.class);
                    startActivity(i);
                }
            }
        });
    }
}
