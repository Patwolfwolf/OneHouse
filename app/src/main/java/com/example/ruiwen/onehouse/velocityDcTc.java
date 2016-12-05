package com.example.ruiwen.onehouse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.*;


public class velocityDcTc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocity_dc_tc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        descText();
        clickButton();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void descText(){
        TextView desc = (TextView) findViewById(R.id.descText);
        Mechanics mac = new Mechanics();
        desc.setText(mac.velocity());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button10);
        final EditText Velocity = (EditText) findViewById(R.id.velocity);
        final EditText TimeChanged = (EditText) findViewById(R.id.TimeChanged);
        final EditText DistanceChanged = (EditText) findViewById(R.id.DistanceChanged);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Velocity.length() == 0 && TimeChanged.length() != 0 && DistanceChanged.length() != 0){
                    Velocity.setText(valueOf(mac.getVeloctiy(valueOf(DistanceChanged.getText().toString()), valueOf(TimeChanged.getText().toString()))).toString());
                }
                if(Velocity.length() != 0 && TimeChanged.length() == 0 && DistanceChanged.length() != 0){
                    TimeChanged.setText(valueOf(mac.getChangeTime(valueOf(Velocity.getText().toString()), valueOf(DistanceChanged.getText().toString()))).toString());
                }
                if(Velocity.length() != 0 && TimeChanged.length() != 0 && DistanceChanged.length() == 0){
                    DistanceChanged.setText(valueOf(mac.getChangeDistance(valueOf(Velocity.getText().toString()), valueOf(TimeChanged.getText().toString()))).toString());
                }
            }
        });
    }

}
