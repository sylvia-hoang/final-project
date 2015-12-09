package com.hfad.patienthealthlogapp;

import java.util.ArrayList;

/**
 * Created by nganhoang on 12/7/15.
 */
public class ArrayListSorter
{
    /** Merge sort an array list of comparable Patient objects
     * Runtime O(nlogn)
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static ArrayList<Patient> mergeSort(ArrayList<Patient> a, int start, int end)
    {
        if ((end-start) < 1) // base case
            return a;

        int mid = (start+end)/2;
        a = mergeSort(a, start, mid); // recurse to sort first half of array list
        a = mergeSort(a, mid+1, end); // recurse to sort the latter half
        a = merge(a, start, mid, end); // merge!
        return a;
    }

    public static ArrayList<Patient> merge(ArrayList<Patient> a, int start, int mid, int end)
    {
        int left = start;
        int right = mid+1;

        ArrayList<Patient> sortedA = new ArrayList<Patient>(); // sorted array list

        while (left <= mid && right <= end)
        {
            if (a.get(left).compareTo(a.get(right)) <= 0) // if a[left] <= a[right]
            {
                sortedA.add(a.get(left));
                left++;
            } else // ow
            {
                sortedA.add(a.get(right));
                right++;
            }
        }
        // One of the following loops will execute
        while (left <= mid) {
            sortedA.add(a.get(left));
            left++;
        }
        while (right <= end) {
            sortedA.add(a.get(right));
            right++;
        }
        // Setting the sorted subarray into the original one
        int i = 0, j = start;
        int size = sortedA.size();
        while (i < size) {
            a.set(j, sortedA.get(i));
            i++;
            j++;
        }
        return a;
    }
}
