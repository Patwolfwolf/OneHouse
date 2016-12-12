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

import static com.example.ruiwen.onehouse.R.mipmap.average;

public class Probability extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probability);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button but = (Button) findViewById(R.id.button21);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bio();
            }
        });
        Button but2 = (Button) findViewById(R.id.button20);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                geo();
            }
        });

    }
        public void bio(){
            EditText n = (EditText) findViewById(R.id.n1);
            EditText p = (EditText) findViewById(R.id.p1);
            if (n.length() != 0 && p.length() != 0) {
                double n2 = Double.valueOf(n.getText().toString());
                double p2 = Double.valueOf(p.getText().toString());
                TextView answer = (TextView) findViewById(R.id.textView81);
                answer.setText("E(x) = " + n2 * p2 + "\nVariance = " + n2*p2*(1-p2));
            }
        }

    public void geo(){
        EditText n = (EditText) findViewById(R.id.n2);
        EditText p = (EditText) findViewById(R.id.p2);
        if (n.length() != 0 && p.length() != 0) {
            double n2 = Double.valueOf(n.getText().toString());
            double p2 = Double.valueOf(p.getText().toString());
            TextView answer = (TextView) findViewById(R.id.textView85);
            answer.setText("E(x) = " + p2 / n2 + "\nVariance = " + p2 / Math.pow(n2, 2));
        }
    }

}
