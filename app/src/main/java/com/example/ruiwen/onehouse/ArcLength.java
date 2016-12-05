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

import static java.lang.Double.*;
public class ArcLength extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_length);
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
        Geometry geo = new Geometry();
        desc.setText(geo.ArchLength());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText arclength = (EditText) findViewById(R.id.arclength);
        final EditText theta = (EditText) findViewById(R.id.theta);
        final EditText radius = (EditText) findViewById(R.id.radius);
        final Geometry geo = new Geometry();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arclength.length() == 0&& theta.length() != 0 && radius.length() != 0){
                    arclength.setText(valueOf(geo.getArchLength(valueOf(radius.getText().toString()), valueOf(theta.getText().toString()))).toString());
                }
                if(theta.length() == 0&& arclength.length() != 0 && radius.length() != 0){
                    theta.setText(valueOf(geo.getThetaAL(valueOf(radius.getText().toString()), valueOf(arclength.getText().toString()))).toString());
                }
                if(radius.length() == 0&& theta.length() != 0 && arclength.length() != 0){
                    radius.setText(valueOf(geo.getRadiusAL(valueOf(theta.getText().toString()), valueOf(arclength.getText().toString()))).toString());
                }
            }
        });
    }
}
