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

public class volumnCy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumn_cy);
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
        desc.setText(geo.VolumeCy());
    }

    public void clickButton(){
        Button calBut = (Button) findViewById(R.id.button2);
        final EditText volumn = (EditText) findViewById(R.id.volumn);
        final EditText height = (EditText) findViewById(R.id.height);
        final EditText radius = (EditText) findViewById(R.id.radius);
        final Geometry geo = new Geometry();
        calBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(volumn.length() == 0&&height.length() != 0 && radius.length() != 0){
                    volumn.setText(valueOf(geo.getVolumeCy(valueOf(radius.getText().toString()), valueOf(height.getText().toString()))).toString());
                }
                if(height.length() == 0 && volumn.length() != 0 && radius.length() != 0){
                    height.setText(valueOf(geo.getHeightCyV(valueOf(volumn.getText().toString()), valueOf(radius.getText().toString()))).toString());
                }
                if(radius.length() == 0 && volumn.length() != 0 && height.length() != 0){
                    radius.setText(valueOf(geo.getRadiusCyV(valueOf(volumn.getText().toString()), valueOf(height.getText().toString()))).toString());
                }
            }
        });
    }
}
