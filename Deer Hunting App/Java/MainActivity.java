package com.example.mc9509dw.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//4/25/2017
public class MainActivity extends AppCompatActivity{

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list= (ListView) findViewById(R.id.myList);
        String [] events= new String[]{"Add","New","Review"};

        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, events);
        list.setAdapter(listAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();
                switch(item){

                    case "Add":
                        add();
                        break;

                    case "New":
                        news();
                        break;

                    case "Review":
                        review();
                        break;

                }
            }
        });
    }

    public void add(){
        // canvas fragment here
        Intent intent = new Intent(this, canvas_activity.class);
        startActivity(intent);

    }

    public void review(){
        Intent intent = new Intent(this, review_activity.class);
        startActivity(intent);
    }

    public void news (){
        Toast.makeText(getBaseContext(), "Database contents deleted!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
