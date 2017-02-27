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

import java.util.ArrayList;

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

        checkPastRes();

        return view;
    }

    private void checkPastRes() {
        //reservaties van user bekijken
        final ReservationAdapter reservationAdapter = new ReservationAdapter(getContext(), R.layout.view_reservation_entry, reservations);
        lvReservations.setAdapter(reservationAdapter);
    }
}
