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

import java.util.Arrays;

import static android.R.attr.max;
import static com.example.ruiwen.onehouse.R.mipmap.average;

public class interquartile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interquartile);
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
        Button but = (Button) findViewById(R.id.button17);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                max();
            }
        });

    }


    public void max() {
        EditText text = (EditText) findViewById(R.id.editText7);
        if (text.length() != 0) {
            String string = text.getText().toString();
            String[] args = string.trim().split(" ");
            double[] array = new double[args.length];
            for (int i = 0; i < args.length; i++) {
                array[i] = Double.valueOf(args[i]);
            }
            Arrays.sort(array);
            double first = array[(array.length-1) / 4];
            double third = array[(array.length-1) * 3 / 4];
            TextView answer = (TextView) findViewById(R.id.textView67);
            answer.setText("Maximum: " + array[array.length - 1] + "\nMinimum: " + array[0] + "\nThe first quartile: " + array[(array.length - 1) / 4]
                    + "\nThe third quartile: " + array[(array.length -1) * 3 / 4] + "\nThe interquartile Range: " + (third - first) + "\n The Median: "
                    + array[(array.length-1)/2]  );
            TextView sort = (TextView) findViewById(R.id.textView68);
            sort.setText("" + Arrays.toString(array));
        }
    }

}
