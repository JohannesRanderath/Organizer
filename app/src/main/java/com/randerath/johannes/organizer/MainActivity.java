package com.randerath.johannes.organizer;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> indices;
    private List<List<String>> contents;
    private String selDate;
    private int selIndex;

    //UI elements as constants
    final Button add_event_btn = (Button) findViewById(R.id.add_event_btn);
    final CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
    final ListView events = (ListView) findViewById(R.id.events);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_event_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selIndex > -1) {

                }
            }
        });

        //Initialize calendar view to today
        calendarView.setDate(System.currentTimeMillis(), true, true);

        //Listening to a possible newly selected date
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                refreshEvents(year, month, dayOfMonth);
            }
        });

    }

    private void refreshEvents(int year, int month, int dayOfMonth) {
        selDate = dayOfMonth + "." + month + "." + year;
        selIndex = indices.indexOf(selDate);
        if(selIndex > -1) { //if there are events for that day, show them, else show an empty list
            events.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contents.get(selIndex)));
        }else events.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>()));
    }
}
