package com.example.phil.todolist;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    LinearLayout linearLayout;
    static final int NEW_TASK_REQUEST = 1;
    static int cont = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         linearLayout = (LinearLayout)findViewById(R.id.tasks);


        final Intent newTaskIntent;
        newTaskIntent = new Intent(MainActivity.this, NewTaskActivity.class);
        //newTaskIntent.putExtra("key", "HI"); //Optional parameters


        final Button newTaskButton = (Button) findViewById(R.id.newTaskButton);
        newTaskButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.startActivityForResult(newTaskIntent, NEW_TASK_REQUEST);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == NEW_TASK_REQUEST) {
            // Make sure the request was successful
            //if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)


                Map sub_tasks = new HashMap();

                String title = data.getStringExtra("TITLE");
                String deadline = data.getStringExtra("DEADLINE");

                String sub_title = data.getStringExtra("S1");
                String priority = data.getStringExtra("P1");
                sub_tasks.put(sub_title,priority);

                sub_title = data.getStringExtra("S2");
                priority = data.getStringExtra("P2");
                sub_tasks.put(sub_title,priority);

                sub_title = data.getStringExtra("S3");
                priority = data.getStringExtra("P3");
                sub_tasks.put(sub_title,priority);

                Task t = new Task(title,deadline,sub_tasks);
                TextView taskView = new TextView(this);
                taskView.setText("Task"+String.valueOf(cont));
                linearLayout.addView(taskView);
                cont +=1;


            Log.d("TASK","this is a task: " + t.title +"\n\tdeadline: " + t.deadline);

            //Log.d("TEST","This is subtitle:  "+ title);
           // }
        }
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
