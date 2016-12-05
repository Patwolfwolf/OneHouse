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

public class EMF2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emf2);
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
        desc.setText(elec.EMF2());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText emf = (EditText) findViewById(R.id.EMF);;
        final EditText current = (EditText) findViewById(R.id.Current);
        final EditText resistance = (EditText) findViewById(R.id.Resistance);
        final EditText iresistance = (EditText) findViewById(R.id.innerResistance);
        final Electricity elec = new Electricity();
        calBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(emf.length() == 0 && current.length() != 0 && resistance.length() != 0 && iresistance.length() != 0){
                    emf.setText(valueOf(elec.getEMF(valueOf(current.getText().toString()), valueOf(resistance.getText().toString()), valueOf(iresistance.getText().toString()))).toString());
                }
                if(current.length() == 0 && emf.length() != 0 && resistance.length() != 0 && iresistance.length() != 0){
                    current.setText(valueOf(elec.getCurrent3(valueOf(emf.getText().toString()), valueOf(resistance.getText().toString()), valueOf(iresistance.getText().toString()))).toString());
                }
                if(resistance.length() == 0 && current.length() != 0 && emf.length() != 0 && iresistance.length() != 0){
                    resistance.setText(valueOf(elec.getResistence2(valueOf(emf.getText().toString()), valueOf(current.getText().toString()), valueOf(iresistance.getText().toString()))).toString());
                }
                if(iresistance.length() == 0 && current.length() != 0 && resistance.length() != 0 && emf.length() != 0){
                    iresistance.setText(valueOf(elec.getInnerResistence(valueOf(emf.getText().toString()), valueOf(current.getText().toString()), valueOf(resistance.getText().toString()))).toString());
                }
            }

        });
    }
}
