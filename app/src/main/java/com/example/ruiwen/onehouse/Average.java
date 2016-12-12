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

public class Average extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);
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
        Button but = (Button) findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                average();
            }
        });
    }
    public void average() {
        EditText text = (EditText) findViewById(R.id.editText);
        if (text.length() != 0) {
            String string = text.getText().toString();
            int sum = 0;
            int count = 0;
             String[] args = string.trim().split(" ");
            for (int i = 0; i < args.length; i++) {
                sum += Double.valueOf(args[i]);
            }
            double average = sum / args.length;
            TextView answer = (TextView) findViewById(R.id.textView3);
            answer.setText(average + "");
        }

    }
}
