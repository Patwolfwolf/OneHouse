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

public class sd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd);
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
        Button but = (Button) findViewById(R.id.button4);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variance();
            }
        });

    }

    private void variance() {
        EditText text = (EditText) findViewById(R.id.editText6);
        String string = text.getText().toString();
        double sum = 0;
        int count = 0;
        String[] args=string.trim().split(" ");
        for (int i = 0; i < args.length; i++) {
            sum += Integer.valueOf(args[i]);
        }
        double average = sum/args.length;
        sum = 0;
        for (int i = 0; i < args.length;i++){
            sum = Integer.valueOf(args[i]) - average;
        }
        TextView answer = (TextView) findViewById(R.id.textView13);
        answer.setText("Variance: " + sum + " Standard Deviation: " + Math.sqrt(sum) );

    }

}
