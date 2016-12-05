package com.example.ruiwen.onehouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainList();
        clickmainList();
//        calText();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Button tbutton = (Button) findViewById(R.id.tbutton);
        Button cbutton = (Button) findViewById(R.id.button3);
        cbutton.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           EditText calT1 = (EditText) findViewById(R.id.editText2);
                                            calT1.setText("\n");
                                       }
        });
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText calT1 = (EditText) findViewById(R.id.editText2);
                try {
                    InputStream stream = new ByteArrayInputStream(calT1.getText().toString().getBytes("UTF-8"));
                    Calculator parser = new Calculator(stream );

                    TextView calTV = (TextView) findViewById(R.id.text01);
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(parser.Start());
                        calTV.setText(sb);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }


//    private void calText(){
//        EditText calT1 = (EditText) findViewById(R.id.calText1);
//        try {
//            InputStream stream = new ByteArrayInputStream(calT1.getText().toString().getBytes("UTF-8"));
//            Calculator parser = new Calculator(stream );
//
//            TextView calTV = (TextView) findViewById(R.id.text01);
//            try {
//                StringBuilder sb = new StringBuilder();
//                sb.append(parser.Start());
//                calTV.setText(sb);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

    public void testButton(View a){
        if (a.getId() == R.id.tbutton){
            EditText calT1 = (EditText) findViewById(R.id.tbutton);
            try {
                InputStream stream = new ByteArrayInputStream(calT1.getText().toString().getBytes("UTF-8"));
                Calculator parser = new Calculator(stream );
                TextView calTV = (TextView) findViewById(R.id.text01);
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(parser.Start());
                    calTV.setText(sb);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void mainList(){
        String[] mainList = {"Mathematics Formula","Physics Formula"};
        ArrayAdapter<String> list = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,mainList);
        ListView list1 = (ListView) findViewById(R.id.list01);
        list1.setAdapter(list);
    }

    public void clickmainList(){
        ListView list1 = (ListView) findViewById(R.id.list01);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message = "Formula sheet of " + textView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                if (position == 0){
                    Intent i = new Intent(MainActivity.this, secondLevel.class);
                    startActivity(i);
                }
                if (position == 1){
                    Intent i = new Intent(MainActivity.this, seconLevelPhysics.class);
                    startActivity(i);
                }
            }
        });
    }
}
