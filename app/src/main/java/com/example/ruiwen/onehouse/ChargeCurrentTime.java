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

public class ChargeCurrentTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_current_time);
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
        desc.setText(elec.Current());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText current = (EditText) findViewById(R.id.Current);;
        final EditText charge = (EditText) findViewById(R.id.Charge);
        final EditText time = (EditText) findViewById(R.id.Time);
        final Electricity elec = new Electricity();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current.length() == 0 && charge.length() != 0 && time.length() != 0){
                    current.setText(valueOf(elec.getCurrent(valueOf(time.getText().toString()), valueOf(charge.getText().toString()))).toString());
                }
                if(charge.length() == 0 && current.length() != 0 && time.length() != 0){
                    charge.setText(valueOf(elec.getChangeCharge(valueOf(current.getText().toString()), valueOf(time.getText().toString()))).toString());
                }
                if(time.length() == 0 && current.length() != 0 && charge.length() != 0){
                    time.setText(valueOf(elec.getChangeTime(valueOf(current.getText().toString()), valueOf(charge.getText().toString()))).toString());
                }
            }

        });
    }
}
