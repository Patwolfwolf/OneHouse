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

public class energyHG extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy_hg);
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
        desc.setText(mac.energy2());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button13);
        final EditText energy = (EditText) findViewById(R.id.energy);
        final EditText mass = (EditText) findViewById(R.id.mass);
        final EditText height = (EditText) findViewById(R.id.height);
        final EditText gravitation = (EditText) findViewById(R.id.gravitation);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(energy.length() == 0 && mass.length() != 0 && height.length() != 0 && gravitation.length() != 0){
                    energy.setText(valueOf(mac.getEnergyOfPotential(valueOf(mass.getText().toString()), valueOf(gravitation.getText().toString().toString()), valueOf(height.getText().toString()))).toString());
                }
                if(energy.length() != 0 && mass.length() == 0 && height.length() != 0 && gravitation.length() != 0){
                    mass.setText(valueOf(mac.getMass(valueOf(energy.getText().toString()), valueOf(height.getText().toString().toString()), valueOf(gravitation.getText().toString()))).toString());
                }
                if(energy.length() != 0 && mass.length() != 0 && height.length() == 0 && gravitation.length() != 0){
                    height.setText(valueOf(mac.getChangeHeight(valueOf(energy.getText().toString()), valueOf(mass.getText().toString().toString()), valueOf(gravitation.getText().toString()))).toString());
                }
                if(energy.length() != 0 && mass.length() != 0 && height.length() != 0 && gravitation.length() == 0){
                    gravitation.setText(valueOf(mac.getGravitaion(valueOf(energy.getText().toString()), valueOf(mass.getText().toString().toString()), valueOf(height.getText().toString()))).toString());
                }
            }
        });
    }

}
