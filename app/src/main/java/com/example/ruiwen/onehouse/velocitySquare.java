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

public class velocitySquare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocity_square);
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
        desc.setText(mac.velocity3());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button5);
        final EditText VelocitySuareRoot = (EditText) findViewById(R.id.velocitySquareRoot);;
        final EditText initialVelocitySquareRoot = (EditText) findViewById(R.id.initialVelocitySquareRoot);
        final EditText acceleration = (EditText) findViewById(R.id.acceleration);
        final EditText distance = (EditText) findViewById(R.id.distance);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(VelocitySuareRoot.length() == 0 && initialVelocitySquareRoot.length() != 0 && acceleration.length() != 0 && distance.length() != 0){
                    VelocitySuareRoot.setText(valueOf(mac.getVelocitySquareRoot(valueOf(initialVelocitySquareRoot.getText().toString()), valueOf(acceleration.getText().toString().toString()), valueOf(distance.getText().toString()))).toString());
                }
                if(VelocitySuareRoot.length() != 0 && initialVelocitySquareRoot.length() == 0 && acceleration.length() != 0 && distance.length() != 0){
                    initialVelocitySquareRoot.setText(valueOf(mac.getInitialVelocitySquareRoot(valueOf(VelocitySuareRoot.getText().toString()), valueOf(distance.getText().toString().toString()), valueOf(acceleration.getText().toString()))).toString());
                }
                if(VelocitySuareRoot.length() != 0 && initialVelocitySquareRoot.length() != 0 && acceleration.length() == 0 && distance.length() != 0){
                    acceleration.setText(valueOf(mac.getAcceleration3(valueOf(VelocitySuareRoot.getText().toString()), valueOf(initialVelocitySquareRoot.getText().toString().toString()), valueOf(distance.getText().toString()))).toString());
                }
                if(VelocitySuareRoot.length() != 0 && initialVelocitySquareRoot.length() != 0 && acceleration.length() != 0 && distance.length() == 0){
                    distance.setText(valueOf(mac.getDistance3(valueOf(VelocitySuareRoot.getText().toString()), valueOf(initialVelocitySquareRoot.getText().toString().toString()), valueOf(acceleration.getText().toString()))).toString());
                }
            }
        });
    }

}
