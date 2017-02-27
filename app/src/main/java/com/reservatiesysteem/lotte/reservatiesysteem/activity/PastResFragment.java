package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.adapter.ReservationAdapter;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Reservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lotte on 27/02/2017.
 */

public class PastResFragment extends Fragment {
    @BindView(R.id.titleRes) TextView txtTitle;
    @BindView(R.id.listReservations) ListView lvReservations;

    ArrayList<Reservation> reservations = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkres, container, false);
        ButterKnife.bind(this, view);

        txtTitle.setText("Afgelopen reservaties");

        ReservationsActivity reservationsActivity = (ReservationsActivity) getActivity();
        reservations = reservationsActivity.getReservations();

        try {
            checkPastRes();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return view;
    }

    private void checkPastRes() throws ParseException {

        ArrayList<Reservation> pastReservations = new ArrayList<>();

        Date now = new Date();

        for (Reservation reservation: reservations){
            String dateTime = reservation.getDateTime();
            String[] dateTimeArray = dateTime.split("T");
            String date = dateTimeArray[0];
            String time = dateTimeArray[1];

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.UK);
            Date dateRes = dateFormat.parse(date + " " + time);

            if(dateRes.before(now)){
                pastReservations.add(reservation);
            }
        }

        //reservaties van user bekijken
        final ReservationAdapter reservationAdapter = new ReservationAdapter(getContext(), R.layout.view_reservation_entry, pastReservations);
        lvReservations.setAdapter(reservationAdapter);

    }
}
