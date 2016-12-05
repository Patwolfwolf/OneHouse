package com.example.ruiwen.onehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class thirdLevelElectricity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_level_electricity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainList();
        clickmainList();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void mainList(){
        String[] mainList = {"Current, Charge and Time","Voltage, Work and Charge","Ohm's Law", "Electromotive Force", "Electromotive Force 2", "Resistivity", "Power", "Power 2", "Alternating Current", "Alternating Voltage"};
        ArrayAdapter<String> list = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,mainList);
        ListView list1 = (ListView) findViewById(R.id.list04);
        list1.setAdapter(list);
    }

    public void clickmainList(){
        ListView list1 = (ListView) findViewById(R.id.list04);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message = "Formula for " + textView.getText().toString();
                Toast.makeText(thirdLevelElectricity.this, message, Toast.LENGTH_SHORT).show();
                if (position == 0){
                    Intent i = new Intent(thirdLevelElectricity.this, ChargeCurrentTime.class);
                    startActivity(i);
                }
                if (position == 1){
                    Intent i = new Intent(thirdLevelElectricity.this, VoltageWorkCharge.class);
                    startActivity(i);
                }
                if (position == 2){
                    Intent i = new Intent(thirdLevelElectricity.this, OhmsLaw.class);
                    startActivity(i);
                }
                if (position == 3){
                    Intent i = new Intent(thirdLevelElectricity.this, EMF.class);
                    startActivity(i);
                }
                if (position == 4){
                    Intent i = new Intent(thirdLevelElectricity.this, EMF2.class);
                    startActivity(i);
                }
                if (position == 5){
                    Intent i = new Intent(thirdLevelElectricity.this, Resistivity.class);
                    startActivity(i);
                }
                if (position == 6){
                    Intent i = new Intent(thirdLevelElectricity.this, Power.class);
                    startActivity(i);
                }
                if (position == 7){
                    Intent i = new Intent(thirdLevelElectricity.this, Power2.class);
                    startActivity(i);
                }
                if (position == 8){
                    Intent i = new Intent(thirdLevelElectricity.this, AC.class);
                    startActivity(i);
                }
                if (position == 9){
                    Intent i = new Intent(thirdLevelElectricity.this, AV.class);
                    startActivity(i);
                }
            }
        });
    }
}
