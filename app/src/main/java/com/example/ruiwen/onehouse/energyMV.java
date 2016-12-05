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

public class energyMV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy_mv);
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
        desc.setText(mac.energy());
    }


    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button12);
        final EditText energy = (EditText) findViewById(R.id.energy);
        final EditText mass = (EditText) findViewById(R.id.mass);
        final EditText velocity = (EditText) findViewById(R.id.velocity);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(energy.length() == 0 && mass.length() != 0 && velocity.length() != 0){
                    energy.setText(valueOf(mac.getEnergyOfKinetic(valueOf(mass.getText().toString()), valueOf(velocity.getText().toString()))).toString());
                }
                if(energy.length() != 0 && mass.length() == 0 && velocity.length() != 0){
                    mass.setText(valueOf(mac.getMass2(valueOf(energy.getText().toString()), valueOf(velocity.getText().toString()))).toString());
                }
                if(energy.length() != 0 && mass.length() != 0 && velocity.length() == 0){
                    velocity.setText(valueOf(mac.getVelocity(valueOf(energy.getText().toString()), valueOf(mass.getText().toString()))).toString());
                }
            }
        });
    }

}
