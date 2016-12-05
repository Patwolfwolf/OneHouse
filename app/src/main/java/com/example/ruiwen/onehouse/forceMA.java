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

public class forceMA extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_m);
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
        desc.setText(mac.force());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button9);
        final EditText force = (EditText) findViewById(R.id.force);
        final EditText mass = (EditText) findViewById(R.id.mass);
        final EditText acceleration = (EditText) findViewById(R.id.acceleration);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(force.length() == 0 && mass.length() != 0 && acceleration.length() != 0){
                    force.setText(valueOf(mac.getForce2(valueOf(mass.getText().toString()), valueOf(acceleration.getText().toString()))).toString());
                }
                if(force.length() != 0 && mass.length() == 0 && acceleration.length() != 0){
                    mass.setText(valueOf(mac.getMass(valueOf(force.getText().toString()), valueOf(acceleration.getText().toString()))).toString());
                }
                if(force.length() != 0 && mass.length() != 0 && acceleration.length() == 0){
                    acceleration.setText(valueOf(mac.getAcceleration3(valueOf(force.getText().toString()), valueOf(mass.getText().toString()))).toString());
                }
            }
        });
    }


}
