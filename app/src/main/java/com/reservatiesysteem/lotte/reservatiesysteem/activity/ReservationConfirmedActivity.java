package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lotte on 24/02/2017.
 */

public class ReservationConfirmedActivity extends BaseActivity{

    @BindView(R.id.branchNameRes) TextView txtBranchName;
    @BindView(R.id.dateRes) TextView txtDateRes;
    @BindView(R.id.timeRes) TextView txtTimeRes;
    @BindView(R.id.numberRes) TextView txtNumberRes;
    @BindView(R.id.btnCalendar) Button btnCalendar;
    @BindView(R.id.btnBack) Button btnBack;

    private String receivedBranchName;
    private String receivedDate;
    private String recievedTime;
    private String receivedAmount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmreservation);
        ButterKnife.bind(this);

        //transfer data from reservationFragment
        Intent intent = getIntent();
        receivedBranchName = intent.getStringExtra("branchName");
        receivedDate = intent.getStringExtra(SearchFragment.CHOSEN_DATE);
        recievedTime = intent.getStringExtra(SearchFragment.CHOSEN_TIME);
        receivedAmount = intent.getStringExtra(SearchFragment.CHOSEN_NUMBEROFPERSONS);

        txtBranchName.setText(receivedBranchName);
        txtDateRes.setText(receivedDate);
        txtTimeRes.setText(recievedTime);
        txtNumberRes.setText(receivedAmount + " personen");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: terug naar beginscherm
                StartActivity activity = new StartActivity();
                SearchFragment searchFragment = new SearchFragment();
                activity.changeFragment(searchFragment,0);
            }
        });
    }
}
