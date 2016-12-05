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

public class EMF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emf);
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
        desc.setText(elec.EMF());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText emf = (EditText) findViewById(R.id.EMF);;
        final EditText energy = (EditText) findViewById(R.id.Energy);
        final EditText charge = (EditText) findViewById(R.id.Charge);
        final Electricity elec = new Electricity();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emf.length() == 0 && energy.length() != 0 && charge.length() != 0){
                    emf.setText(valueOf(elec.getEMF(valueOf(energy.getText().toString()), valueOf(charge.getText().toString()))).toString());
                }
                if(energy.length() == 0 && emf.length() != 0 && charge.length() != 0){
                    energy.setText(valueOf(elec.getEnergy(valueOf(emf.getText().toString()), valueOf(charge.getText().toString()))).toString());
                }
                if(charge.length() == 0 && emf.length() != 0 && energy.length() != 0){
                    charge.setText(valueOf(elec.getCharge2(valueOf(emf.getText().toString()), valueOf(energy.getText().toString()))).toString());
                }
            }

        });
    }
}
