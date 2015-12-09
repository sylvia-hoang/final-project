package com.hfad.patienthealthlogapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by nganhoang on 12/7/15.
 */
public class PatientLog
{
    private static String[] array = {
            "Common cold", "1",
            "Heart attack", "4",
            "Dental issues", "2",
            "Nut allergy", "3"
    };
    public static final HashMap<String,Integer> CONDITION_RANK =  getConditionRank(array);

    private ArrayList<Patient> log; // patient data
    private int numPpl; // number of patients

    /** Constructor **/
    public PatientLog()
    {
        log = new ArrayList<Patient>();
        numPpl = 0;
    }

    /** Construct a hash map of condition-intensity key-value pairs
     * Serve as a dictionary for ranking condition types
     * @param a
     * @return
     */
    private static HashMap<String,Integer> getConditionRank(String[] a)
    {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < a.length-1; i += 2)
        {
            // Put a condition-intensity pair into the map
            map.put(a[i], Integer.parseInt(a[i+1]));
        }

        return map;
    }

    /** Add a patient into the patient log structure
     * Also sort the list of patients
     * @param p
     */
    public void addPatient(Patient p)
    {
        log.add(p);
        numPpl++;
        sortPatientLog();
    }

    /** Merge sort the patient log with their natural ordering
     *
     */
    public void sortPatientLog()
    {
        log = ArrayListSorter.mergeSort(log, 0, numPpl-1);
    }

    /**
     * @return the log
     */
    public ArrayList<Patient> getLog()
    {
        return log;
    }

    /**
     * Get the iterator for the current log
     * @return
     */
    public Iterator<Patient> getIterator()
    {
        return log.iterator();
    }
}
