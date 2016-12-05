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

import static java.lang.Double.valueOf;

public class distanceIVVT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_ivvt);
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
        desc.setText(mac.distance2());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button7);
        final EditText distance = (EditText) findViewById(R.id.distance);;
        final EditText initialVelocity = (EditText) findViewById(R.id.initialVelocity);
        final EditText velocity = (EditText) findViewById(R.id.velocity);
        final EditText time = (EditText) findViewById(R.id.time);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(distance.length() == 0 && initialVelocity.length() != 0 && velocity.length() != 0 && time.length() != 0){
                    distance.setText(valueOf(mac.getDistance(valueOf(initialVelocity.getText().toString()), valueOf(velocity.getText().toString().toString()), valueOf(time.getText().toString()))).toString());
                }
                if(distance.length() != 0 && initialVelocity.length() == 0 && velocity.length() != 0 && time.length() != 0){
                    initialVelocity.setText(valueOf(mac.getInitalVelocity(valueOf(distance.getText().toString()), valueOf(velocity.getText().toString().toString()), valueOf(time.getText().toString()))).toString());
                }
                if(distance.length() != 0 && initialVelocity.length() != 0 && velocity.length() == 0 && time.length() != 0){
                    velocity.setText(valueOf(mac.getVelocity2(valueOf(distance.getText().toString()), valueOf(initialVelocity.getText().toString().toString()), valueOf(time.getText().toString()))).toString());
                }
                if(distance.length() != 0 && initialVelocity.length() != 0 && velocity.length() != 0 && time.length() == 0){
                    time.setText(valueOf(mac.getTime2(valueOf(distance.getText().toString()), valueOf(initialVelocity.getText().toString().toString()), valueOf(velocity.getText().toString()))).toString());
                }
            }
        });
    }

}
