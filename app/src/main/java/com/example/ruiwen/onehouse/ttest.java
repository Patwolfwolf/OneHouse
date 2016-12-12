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
import android.widget.Toast;

import static android.R.attr.x;
import static android.R.id.message;
import static com.example.ruiwen.onehouse.R.mipmap.average;

public class ttest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttest);
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
        Button but = (Button) findViewById(R.id.button18);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                area();
            }
        });
    }

    public void area (){
        EditText a = (EditText) findViewById(R.id.editText11);
        EditText b = (EditText) findViewById(R.id.editText13);
        EditText mean = (EditText) findViewById(R.id.mean);
        EditText sd = (EditText) findViewById(R.id.sd);
        double result = 0;
        if (a.length() != 0 && b.length() != 0 && mean.length() != 0 && sd.length() != 0){
            double m = Double.valueOf(a.getText().toString());
            double n = Double.valueOf(b.getText().toString());
            double mm = Double.valueOf(mean.getText().toString());
            double ss = Double.valueOf(sd.getText().toString());
            RFunc1d fx = new RFunc1d() {
                @Override
                public double f(double x) {
                    return ((1/(Math.sqrt(2*Math.PI))) * (Math.pow(Math.E, (-(Math.pow(x, 2))/2))));
                }
            };
            double xMin = (m-mm)/ss;
            double xMax = (n-mm)/ss;
            double dx = .001;
            result = trapezoidIntegrate(fx, xMin, xMax, dx);
            TextView answer = (TextView) findViewById(R.id.textView75);
            answer.setText(result + "");
        }
        else if (a.length() == 0 && b.length() != 0 && mean.length() != 0 && sd.length() != 0){
            double n = Double.valueOf(b.getText().toString());
            double mm = Double.valueOf(mean.getText().toString());
            double ss = Double.valueOf(sd.getText().toString());
            RFunc1d fx = new RFunc1d() {
                @Override
                public double f(double x) {
                    return ((1/(Math.sqrt(2*Math.PI))) * (Math.pow(Math.E, (-(Math.pow(x, 2))/2))));
                }
            };
            double xMin = -999;
            double xMax = (n-mm)/ss;
            double dx = .001;
            result = trapezoidIntegrate(fx, xMin, xMax, dx);
            TextView answer = (TextView) findViewById(R.id.textView75);
            answer.setText(result + "");
        }
        else if (a.length() != 0 && b.length() == 0 && mean.length() != 0 && sd.length() != 0){
            double m = Double.valueOf(a.getText().toString());
            double n = Double.valueOf(b.getText().toString());
            double mm = Double.valueOf(mean.getText().toString());
            double ss = Double.valueOf(sd.getText().toString());
            RFunc1d fx = new RFunc1d() {
                @Override
                public double f(double x) {
                    return ((1/(Math.sqrt(2*Math.PI))) * (Math.pow(Math.E, (-(Math.pow(x, 2))/2))));
                }
            };
            double xMin = (m-mm)/ss;
            double xMax = 999;
            double dx = .001;
            result = trapezoidIntegrate(fx, xMin, xMax, dx);
            TextView answer = (TextView) findViewById(R.id.textView75);
            answer.setText(result + "");
        }
        else {
            Toast.makeText(ttest.this, "Please enter in correct format.", Toast.LENGTH_SHORT).show();
        }



    }

    interface RFunc1d { // real function of 1 variable
        double f(double x);
    }

    public static double trapezoidIntegrate(RFunc1d fn, double xMin, double xMax, double dx) {
        double area = 0;
        if (xMin > xMax)
            return 0;
        double x = xMin;
        double fx = fn.f(x);
        boolean go = true;
        while (go){
            double x2 = x + dx;
            if (x2 >= xMax){
                go = false;
                x2 = xMax;
                dx = xMax - x;
            }
            double fx2 = fn.f(x2);
            area += (fx + fx2) / 2 *dx;
            x = x2;
            fx = fx2;
        }
        return area;
    }
}
