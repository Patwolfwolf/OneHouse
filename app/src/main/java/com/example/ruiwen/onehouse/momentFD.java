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

public class momentFD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moment_fd);
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
        desc.setText(mac.moment());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button3);
        final EditText Moment = (EditText) findViewById(R.id.Moment);;
        final EditText Distance = (EditText) findViewById(R.id.Distance);
        final EditText Force = (EditText) findViewById(R.id.Force);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Moment.length() == 0 && Distance.length() != 0 && Force.length() != 0){
                    Moment.setText(valueOf(mac.getMoments(valueOf(Force.getText().toString()), valueOf(Distance.getText().toString()))).toString());
                }
                if(Moment.length() != 0 && Distance.length() == 0 && Force.length() != 0){
                    Distance.setText(valueOf(mac.getDistance(valueOf(Moment.getText().toString()), valueOf(Force.getText().toString()))).toString());
                }
                if(Moment.length() != 0 && Distance.length() != 0 && Force.length() == 0){
                    Force.setText(valueOf(mac.getForce(valueOf(Moment.getText().toString()), valueOf(Distance.getText().toString()))).toString());
                }
            }
        });
    }

}
