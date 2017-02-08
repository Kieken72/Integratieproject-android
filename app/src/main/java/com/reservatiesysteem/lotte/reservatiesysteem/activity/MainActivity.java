package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.reservatiesysteem.lotte.reservatiesysteem.R;

public class MainActivity extends AppCompatActivity {

    private static final int TIME_PICKER_INTERVAL = 30;

    private TextView txtDate, txtTime;
    private Calendar calendar;

    private int year, month, day, hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);
        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        showDate(year, month, day);
        showTime(hour, minute);

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view){
        showDialog(999);
    }

    @SuppressWarnings("deprecation")
    public void setTime(View view){
        showDialog(998);
    }

    protected Dialog onCreateDialog(int id){
        if(id == 999){
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        if(id == 998){
            return new TimePickerDialog(this, myTimeListener, hour, minute, true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate(year, month, dayOfMonth);
        }
    };

    private TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            showTime(hourOfDay, minute);
        }
    };

    private void showDate(int year, int month, int day) {
        txtDate.setText(new StringBuilder().append(day).append("/").append(month+1).append("/").append(year));
    }

    private void showTime(int hour, int minute) {
        minute = getRoundedMinute(minute);
        if(minute < 10){
            txtTime.setText(new StringBuilder().append(hour).append(":0").append(minute));
        } else {
            txtTime.setText(new StringBuilder().append(hour).append(":").append(minute));
        }
    }

    public static int getRoundedMinute(int minute){
        if(minute % TIME_PICKER_INTERVAL != 0){
            int minuteFloor = minute - (minute % TIME_PICKER_INTERVAL);
            minute = minuteFloor + (minute == minuteFloor + 1 ? TIME_PICKER_INTERVAL : 0);
            if(minute == 60)
                minute = 0;
        }
        return minute;
    }

}