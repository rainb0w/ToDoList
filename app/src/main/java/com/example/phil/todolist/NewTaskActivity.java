    package com.example.phil.todolist;

    import android.app.Activity;
    import android.content.Intent;
    import android.support.v7.app.ActionBarActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.Spinner;
    import android.widget.TextView;

    import java.text.DateFormat;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import java.util.Date;
    import java.util.HashMap;
    import java.util.Map;


    public class NewTaskActivity extends ActionBarActivity {

        private String[] arraySpinner;
        private Spinner s1,s2,s3;
        private TextView txtTitle,txtDeadline,txtSub1,txtSub2,txtSub3;

        static final int PUBLIC_STATIC_STRING_IDENTIFIER = 15;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_task);

            this.arraySpinner = new String[] {
                    "1", "2", "3"
            };
            s1 = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, arraySpinner);
            s1.setAdapter(adapter);
            s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    String imc_met=s1.getSelectedItem().toString();

                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }
            });

            s2 = (Spinner) findViewById(R.id.spinner2);
           adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, arraySpinner);
            s2.setAdapter(adapter);
            s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    String imc_met=s2.getSelectedItem().toString();

                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }
            });

            s3 = (Spinner) findViewById(R.id.spinner3);
           adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, arraySpinner);
            s3.setAdapter(adapter);
            s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                    String imc_met=s3.getSelectedItem().toString();

                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }
            });



            final Button submitButton = (Button) findViewById(R.id.btnSubmit);
            submitButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v){
                    Intent resultIntent = new Intent();

                    //Title
                    txtTitle = (TextView) findViewById(R.id.txtTitle);
                    String title = txtTitle.getText().toString();
                    resultIntent.putExtra("TITLE", title);


                    //Deadline
                    txtDeadline = (TextView) findViewById(R.id.txtDeadline);
                    Calendar c = Calendar.getInstance();
                    int milliseconds = c.get(Calendar.MILLISECOND);
                    //Date deadline = new Date(milliseconds);
                    //DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    String deadline=txtDeadline.getText().toString();
                    resultIntent.putExtra("DEADLINE", deadline);

                    /*try {
                        deadline = formatter.parse(tmp);
                        resultIntent.putExtra("DEADLINE", deadline);
                        Log.d("DEADLINE","dead:  "+deadline);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }*/
                    //Log.d("TEST","Title: " + title + "\t data: " + deadline);
                    //Log.d("TEST","priority: "+ s1.getSelectedItem().toString());


                    //Subtask
                    //Map sub_tasks = new HashMap();
                    txtSub1 = (TextView) findViewById(R.id.txtSub1);
                    String sub_title = txtSub1.getText().toString();
                    resultIntent.putExtra("SUB1", sub_title);


                    String priority = s1.getSelectedItem().toString();
                    resultIntent.putExtra("P1", priority);


                    txtSub2 = (TextView) findViewById(R.id.txtSub2);
                    sub_title = txtSub2.getText().toString();
                    resultIntent.putExtra("SUB2", sub_title);

                    priority = s2.getSelectedItem().toString();
                    resultIntent.putExtra("P2", priority);

                    txtSub3 = (TextView) findViewById(R.id.txtSub3);
                    sub_title = txtSub3.getText().toString();
                    resultIntent.putExtra("SUB3", sub_title);

                    priority = s3.getSelectedItem().toString();
                    resultIntent.putExtra("P3", priority);


                    //Intent resultIntent = new Intent();
                    //resultIntent.putExtra("new_task", t);
                    setResult(1, resultIntent);
                    finish();
                }
            });
        }

    }
