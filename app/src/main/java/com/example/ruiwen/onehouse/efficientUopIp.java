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

public class efficientUopIp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efficient_uop_ip);
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
        desc.setText(mac.efficient());
    }


    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button16);
        final EditText efficient = (EditText) findViewById(R.id.efficient);;
        final EditText output = (EditText) findViewById(R.id.output);
        final EditText input = (EditText) findViewById(R.id.input);
        final Mechanics mac = new Mechanics();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(efficient.length() == 0 && output.length() != 0 && input.length() != 0){
                    efficient.setText(valueOf(mac.getEfficient(valueOf(output.getText().toString()), valueOf(input.getText().toString()))).toString());
                }
                if(efficient.length() != 0 && output.length() == 0 && input.length() != 0){
                    output.setText(valueOf(mac.getusefulOutputPower(valueOf(efficient.getText().toString()), valueOf(input.getText().toString()))).toString());
                }
                if(efficient.length() != 0 && output.length() != 0 && input.length() == 0){
                    input.setText(valueOf(mac.getInputPower(valueOf(efficient.getText().toString()), valueOf(output.getText().toString()))).toString());
                }
            }
        });
    }


}
