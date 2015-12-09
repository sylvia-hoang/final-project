package com.hfad.patienthealthlogapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;


public class DisplayPatientListActivity extends Activity {

    public static final String EXTRA_NAME = "p_name";
    public static final String EXTRA_CONDITION = "p_condition";
    public static final String EXTRA_RANK = "p_severity";
    PatientLog log = new PatientLog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patient_list);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_patient_list, menu);
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle bundle)
    {

    }

    private void addNewPatient()
    {
        Intent intent = getIntent();
        // Get information from intent
        String name = intent.getStringExtra(EXTRA_NAME);
        String condition = intent.getStringExtra(EXTRA_CONDITION);
        int rank = intent.getIntExtra(EXTRA_RANK, -1);
        // Create a Patient object and add to the log
        Patient p = new Patient(name, condition, rank);
        log.addPatient(p);
    }
}
