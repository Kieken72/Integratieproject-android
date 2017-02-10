package com.reservatiesysteem.lotte.reservatiesysteem.activity.StartActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.activity.StartActivity.StartActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class SearchFragment extends Fragment {
    @BindView(R.id.txtDate) TextView txtDate;
    @BindView(R.id.txtTime) TextView txtTime;
    @BindView(R.id.btnReserveer)Button button;
    @BindView(R.id.btnTime)ImageView btnTime;
    @BindView(R.id.btnDate)ImageView btnDate;

    private final int TIME_PICKER_INTERVAL = 30;
    private int year, month, day, hour, minute;
    private Calendar calendar;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this,view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartActivity activity = (StartActivity) getActivity();
                activity.changeFragment();
            }
        });

        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("date");
                DatePickerDialog dpd = new DatePickerDialog(getContext(),myDateListener,year,month,day);
                dpd.show();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("time");
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),myTimeListener,hour,minute,true);
                timePickerDialog.show();
            }
        });

        showDate(year, month, day);
        showTime(hour, minute);
        return view;
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

    public int getRoundedMinute(int minute){
        if(minute % TIME_PICKER_INTERVAL != 0){
            int minuteFloor = minute - (minute % TIME_PICKER_INTERVAL);
            minute = minuteFloor + (minute == minuteFloor + 1 ? TIME_PICKER_INTERVAL : 0);
            if(minute == 60)
                minute = 0;
        }
        return minute;
    }
}
