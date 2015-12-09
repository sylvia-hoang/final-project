package com.hfad.patienthealthlogapp;

/**
 * Created by nganhoang on 12/7/15.
 */

/**
 * Patient object represents a patient. Instantiation of a Patient object occurs on hospitalization.
 */
public class Patient implements Comparable<Patient>
{
    private String name;
    private String condition;
//    private Date date;
    private int intensity;

    /** Constructor takes in a name, date, condition and its severity **/
    public Patient(String name, String condition, int intensity)
    {
        this.name = name;
//        this.date = date;
        this.condition = condition;
        this.intensity = intensity;
    }

    @Override
    public int compareTo(Patient p) {
        if (intensity > p.intensity)
            return 1;
        else if (intensity < p.intensity)
            return -1;
        else
            return 0;
    }

    public String getName()
    {
        return name;
    }

    public String getCondition()
    {
        return condition;
    }

    public int getIntensity()
    {
        return intensity;
    }

//    @Override
//    // Can ignore
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel out, int flags) {
//        out.writeInt(mData);
//    }
}
