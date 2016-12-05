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

import java.sql.Time;

import static java.lang.Double.valueOf;

public class accelerationVcTc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleration_vc_tc);
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
        desc.setText(mac.velocity4());
    }


    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button6);
        final EditText acceleration = (EditText) findViewById(R.id.acceleration);;
        final EditText TimeChanged = (EditText) findViewById(R.id.timeChanged);
        final EditText VelocityChanged = (EditText) findViewById(R.id.velocityChanged);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(acceleration.length() == 0 && TimeChanged.length() != 0 && VelocityChanged.length() != 0){
                    acceleration.setText(valueOf(mac.getAcceleration(valueOf(VelocityChanged.getText().toString()), valueOf(TimeChanged.getText().toString()))).toString());
                }
                if(acceleration.length() != 0 && TimeChanged.length() == 0 && VelocityChanged.length() != 0){
                    TimeChanged.setText(valueOf(mac.getChangeTime2(valueOf(acceleration.getText().toString()), valueOf(VelocityChanged.getText().toString()))).toString());
                }
                if(acceleration.length() != 0 && TimeChanged.length() != 0 && VelocityChanged.length() == 0){
                    VelocityChanged.setText(valueOf(mac.getChangeVelocity(valueOf(acceleration.getText().toString()), valueOf(TimeChanged.getText().toString()))).toString());
                }
            }
        });
    }

}
