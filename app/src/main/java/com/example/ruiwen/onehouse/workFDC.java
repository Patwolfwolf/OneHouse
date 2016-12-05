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

public class workFDC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_fdc);
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
        desc.setText(mac.work());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button11);
        final EditText work = (EditText) findViewById(R.id.work);
        final EditText force = (EditText) findViewById(R.id.force);
        final EditText distance = (EditText) findViewById(R.id.distance);
        final EditText theta = (EditText) findViewById(R.id.theta);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(work.length() == 0 && force.length() != 0 && distance.length() != 0 && theta.length() != 0){
                    work.setText(valueOf(mac.getWork(valueOf(force.getText().toString()), valueOf(distance.getText().toString().toString()), valueOf(theta.getText().toString()))).toString());
                }
                if(work.length() != 0 && force.length() == 0 && distance.length() != 0 && theta.length() != 0){
                    force.setText(valueOf(mac.getForce(valueOf(work.getText().toString()), valueOf(distance.getText().toString().toString()), valueOf(theta.getText().toString()))).toString());
                }
                if(work.length() != 0 && force.length() != 0 && distance.length() == 0 && theta.length() != 0){
                    distance.setText(valueOf(mac.getDistance2(valueOf(work.getText().toString()), valueOf(force.getText().toString().toString()), valueOf(theta.getText().toString()))).toString());
                }
                if(work.length() != 0 && force.length() != 0 && distance.length() != 0 && theta.length() == 0){
                    theta.setText(valueOf(mac.getTheta(valueOf(work.getText().toString()), valueOf(force.getText().toString().toString()), valueOf(distance.getText().toString()))).toString());
                }
            }
        });
    }

}
