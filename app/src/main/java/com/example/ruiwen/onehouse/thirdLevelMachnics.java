package com.example.ruiwen.onehouse;

import android.content.Intent;
import android.net.Uri;
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

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class thirdLevelMachnics extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_level_machnics);
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void mainList(){
        String[] mainList = {"Moment by force and distance", "Velocity by changed time and changed distance",
                "Velocity by initial velocity, acceleration and time", "velocity's square by initial velocity's square, acceleration and time ",
                "distance by initial velocity, acceleration and time", "distance by initial velocity, velocity and time",
                "acceleration by changed velocity and changed time", "force by mass and acceleration",
                "work by force, distance and theta", "energy of Kinetic by mass and velocity",
                "energy of Potential by mass, highet changed and gravitation", "power by force and velocity",
               2 "power by changed work and changed time", "efficient by output and input"};
        ArrayAdapter<String> list = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,mainList);
        ListView list1 = (ListView) findViewById(R.id.list01);
        list1.setAdapter(list);
    }

    public void clickmainList(){
        ListView list1 = (ListView) findViewById(R.id.list01);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message = "Formula for " + textView.getText().toString();
                Toast.makeText(thirdLevelMachnics.this, message, Toast.LENGTH_SHORT).show();
                if (position == 0){
                    Intent i = new Intent(thirdLevelMachnics.this, momentFD.class);
                    startActivity(i);
                }
                if (position == 1){
                    Intent i = new Intent(thirdLevelMachnics.this, velocityDcTc.class);
                    startActivity(i);
                }
                if (position == 2){
                    Intent i = new Intent(thirdLevelMachnics.this, velocityIVAT.class);
                    startActivity(i);
                }
                if (position == 3){
                    Intent i = new Intent(thirdLevelMachnics.this, velocitySquare.class);
                    startActivity(i);
                }
                if (position == 4){
                    Intent i = new Intent(thirdLevelMachnics.this, distanceIVAT.class);
                    startActivity(i);
                }
                if (position == 5){
                    Intent i = new Intent(thirdLevelMachnics.this, distanceIVVT.class);
                    startActivity(i);
                }
                if (position == 6){
                    Intent i = new Intent(thirdLevelMachnics.this, accelerationVcTc.class);
                    startActivity(i);
                }
                if (position == 7){
                    Intent i = new Intent(thirdLevelMachnics.this, forceMA.class);
                    startActivity(i);
                }
                if (position == 8){
                    Intent i = new Intent(thirdLevelMachnics.this, workFDC.class);
                    startActivity(i);
                }
                if (position == 9){
                    Intent i = new Intent(thirdLevelMachnics.this, energyMV.class);
                    startActivity(i);
                }
                if (position == 10){
                    Intent i = new Intent(thirdLevelMachnics.this, energyHG.class);
                    startActivity(i);
                }
                if (position == 11){
                    Intent i = new Intent(thirdLevelMachnics.this, powerFV.class);
                    startActivity(i);
                }
                if (position == 12){
                    Intent i = new Intent(thirdLevelMachnics.this, powerWcTc.class);
                    startActivity(i);
                }
                if (position == 13){
                    Intent i = new Intent(thirdLevelMachnics.this, efficientUopIp.class);
                    startActivity(i);
                }
            }
        });
    }

}
