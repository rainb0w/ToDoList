package com.example.phil.todolist;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Phil on 01/03/2015.
 */
public class Task {
    String title;
    String deadline;

    Map sub_tasks = new HashMap();

    public Task(String t, String d, Map s) {
        title = t;
        deadline = d;
        sub_tasks = s;

    }

}