package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.fragments.FutureResFragment;
import com.reservatiesysteem.lotte.reservatiesysteem.fragments.PastResFragment;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Reservation;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lotte on 27/02/2017.
 */

public class ReservationsActivity extends BaseActivity {
    @BindView(R.id.vpRes) ViewPager vpRes;

    CheckReservationAdapter homePagerAdapter;
    ArrayList<Reservation> reservations = new ArrayList<>();


    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
        ButterKnife.bind(this);

        reservations = (ArrayList<Reservation>) getIntent().getExtras().getSerializable("Reservations");


        homePagerAdapter = new CheckReservationAdapter(getSupportFragmentManager());
        vpRes.setAdapter(homePagerAdapter);

    }

    private class CheckReservationAdapter extends FragmentStatePagerAdapter {
        private ArrayList<Fragment> fragments = new ArrayList<>();
        private int maxVisibleItems;

        public CheckReservationAdapter(FragmentManager fm) {
            super(fm);
            maxVisibleItems = 2;

        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new PastResFragment();
                case 1:
                    return new FutureResFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return maxVisibleItems;
        }

    }
}
