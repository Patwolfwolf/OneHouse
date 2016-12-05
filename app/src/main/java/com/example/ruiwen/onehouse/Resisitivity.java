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

public class Resisitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resisitivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        descText();
        clickButton();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void descText(){
        TextView desc = (TextView) findViewById(R.id.descText);
        Electricity elec = new Electricity();
        desc.setText(elec.resistivity());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText resistivity = (EditText) findViewById(R.id.resistivity);;
        final EditText resistance = (EditText) findViewById(R.id.Resistance);
        final EditText cs = (EditText) findViewById(R.id.cs);
        final EditText length = (EditText) findViewById(R.id.length);
        final Electricity elec = new Electricity();
        calBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(resistivity.length() == 0 && resistance.length() != 0 && cs.length() != 0 && length.length() != 0){
                    resistivity.setText(valueOf(elec.getResistivity(valueOf(resistance.getText().toString()), valueOf(cs.getText().toString()), valueOf(length.getText().toString()))).toString());
                }
                if(resistance.length() == 0 && resistivity.length() != 0 && cs.length() != 0 && length.length() != 0){
                    resistance.setText(valueOf(elec.getResistance(valueOf(resistivity.getText().toString()), valueOf(cs.getText().toString()), valueOf(length.getText().toString()))).toString());
                }
                if(cs.length() == 0 && resistance.length() != 0 && resistivity.length() != 0 && length.length() != 0){
                    cs.setText(valueOf(elec.getArea(valueOf(resistivity.getText().toString()), valueOf(resistance.getText().toString()), valueOf(length.getText().toString()))).toString());
                }
                if(length.length() == 0 && resistance.length() != 0 && cs.length() != 0 && resistivity.length() != 0){
                    length.setText(valueOf(elec.getLength(valueOf(resistivity.getText().toString()), valueOf(resistance.getText().toString()), valueOf(cs.getText().toString()))).toString());
                }
            }

        });
    }
}
