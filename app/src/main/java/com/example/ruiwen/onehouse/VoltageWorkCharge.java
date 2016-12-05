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

public class VoltageWorkCharge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voltage_work_charge);
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
        desc.setText(elec.Voltage());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText voltage = (EditText) findViewById(R.id.Voltage);;
        final EditText work = (EditText) findViewById(R.id.Work);
        final EditText charge = (EditText) findViewById(R.id.Charge);
        final Electricity elec = new Electricity();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(voltage.length() == 0 && work.length() != 0 && charge.length() != 0){
                    voltage.setText(valueOf(elec.getCurrent(valueOf(work.getText().toString()), valueOf(charge.getText().toString()))).toString());
                }
                if(work.length() == 0 && voltage.length() != 0 && charge.length() != 0){
                    work.setText(valueOf(elec.getChangeCharge(valueOf(voltage.getText().toString()), valueOf(charge.getText().toString()))).toString());
                }
                if(charge.length() == 0 && voltage.length() != 0 && work.length() != 0){
                    charge.setText(valueOf(elec.getChangeTime(valueOf(voltage.getText().toString()), valueOf(work.getText().toString()))).toString());
                }
            }

        });
    }
}
