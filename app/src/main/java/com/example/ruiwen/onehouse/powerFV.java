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

public class powerFV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_fv);
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
        desc.setText(mac.power());
    }


    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button14);
        final EditText power = (EditText) findViewById(R.id.power);;
        final EditText force = (EditText) findViewById(R.id.force);
        final EditText velocity = (EditText) findViewById(R.id.velocity);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(power.length() == 0 && force.length() != 0 && velocity.length() != 0){
                    power.setText(valueOf(mac.getPower(valueOf(force.getText().toString()), valueOf(velocity.getText().toString()))).toString());
                }
                if(power.length() != 0 && force.length() == 0 && velocity.length() != 0){
                    force.setText(valueOf(mac. getForce3(valueOf(power.getText().toString()), valueOf(velocity.getText().toString()))).toString());
                }
                if(power.length() != 0 && force.length() != 0 && velocity.length() == 0){
                    velocity.setText(valueOf(mac.getVelocity3(valueOf(power.getText().toString()), valueOf(force.getText().toString()))).toString());
                }
            }
        });
    }

}
