package com.hfad.patienthealthlogapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainFormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_form, menu);
        return true;
    }

    /** Action performed on submit button
     *
     * @param view
     */
    public void onClickSubmit(View view)
    {
        EditText nameField = (EditText) findViewById(R.id.name);
        EditText dateField = (EditText) findViewById(R.id.date);
        EditText condition = (EditText) findViewById(R.id.condition);
        String name = nameField.getText().toString();
        String cond = nameField.getText().toString();
//        String date = dateField.getText().toString();
        // Get date object
        // Get condition's severity ranking
        int rank = PatientLog.CONDITION_RANK.get(cond);
        Intent intent = new Intent(this, DisplayPatientListActivity.class);
        // Put extra information into intent
        intent.putExtra(DisplayPatientListActivity.EXTRA_NAME, name);
        intent.putExtra(DisplayPatientListActivity.EXTRA_CONDITION, cond);
        intent.putExtra(DisplayPatientListActivity.EXTRA_RANK, rank);
        startActivity(intent);
    }
}
