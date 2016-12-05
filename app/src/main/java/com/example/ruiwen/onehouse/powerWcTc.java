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

public class powerWcTc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_wc_tc);
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
        desc.setText(mac.power2());
    }


    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button15);
        final EditText power = (EditText) findViewById(R.id.power);;
        final EditText time = (EditText) findViewById(R.id.time);
        final EditText work = (EditText) findViewById(R.id.work);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(power.length() == 0 && time.length() != 0 && work.length() != 0){
                    power.setText(valueOf(mac.getPower1(valueOf(work.getText().toString()), valueOf(time.getText().toString()))).toString());
                }
                if(power.length() != 0 && time.length() == 0 && work.length() != 0){
                    time.setText(valueOf(mac.getChangeWork(valueOf(power.getText().toString()), valueOf(work.getText().toString()))).toString());
                }
                if(power.length() != 0 && time.length() != 0 && work.length() == 0){
                    work.setText(valueOf(mac.getChangeTime3(valueOf(power.getText().toString()), valueOf(time.getText().toString()))).toString());
                }
            }
        });
    }

}
