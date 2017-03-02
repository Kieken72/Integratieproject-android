package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jasper on 02/03/2017.
 */

public class ReservationDetailActivity extends BaseActivity {
    @BindView(R.id.lblBranchName)
    TextView lblBranchName;
    @BindView(R.id.lblBranchAdress)
    TextView lblBranchAdress;
    @BindView(R.id.lblDate)
    TextView lblDate;
    @BindView(R.id.lblStartTime)
    TextView lblStartTime;
    @BindView(R.id.lblEndTime)
    TextView lblEndTime;
    @BindView(R.id.lblPersonCount)
    TextView lblPersonCount;

    Reservation reservation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        reservation = (Reservation) bundle.getSerializable("reservation");
        String branchName = bundle.getString("branchName");
        String branchAddress = bundle.getString("branchAddress");

        String date = reservation.getDateTime().split("T")[0];
        String startTime = reservation.getDateTime().split("T")[1].substring(0, 5);
        String endTime = reservation.getEndDateTime().split("T")[1].substring(0, 5);

        String personCount = bundle.getString("personCount");

        lblBranchName.setText(branchName);
        lblBranchAdress.setText(branchAddress);
        lblDate.setText(date);
        lblStartTime.setText(startTime);
        lblEndTime.setText(endTime);
        lblPersonCount.setText(personCount);


    }
}
