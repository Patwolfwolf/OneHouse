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

public class Power extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
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
        Electricity elec = new Electricity();
        desc.setText(elec.power());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText power = (EditText) findViewById(R.id.Power);;
        final EditText voltage = (EditText) findViewById(R.id.Voltage);
        final EditText current = (EditText) findViewById(R.id.Current);
        final Electricity elec = new Electricity();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(power.length() == 0 && voltage.length() != 0 && current.length() != 0){
                    power.setText(valueOf(elec.getPower(valueOf(voltage.getText().toString()), valueOf(current.getText().toString()))).toString());
                }
                if(voltage.length() == 0 && power.length() != 0 && current.length() != 0){
                    voltage.setText(valueOf(elec.getVoltage3(valueOf(power.getText().toString()), valueOf(current.getText().toString()))).toString());
                }
                if(current.length() == 0 && power.length() != 0 && voltage.length() != 0){
                    current.setText(valueOf(elec.getCurrent3(valueOf(power.getText().toString()), valueOf(voltage.getText().toString()))).toString());
                }
            }

        });
    }
}
