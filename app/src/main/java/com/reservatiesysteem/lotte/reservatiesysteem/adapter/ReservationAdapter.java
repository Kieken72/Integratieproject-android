package com.reservatiesysteem.lotte.reservatiesysteem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.model.ProfileAccount;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lotte on 26/02/2017.
 */

public class ReservationAdapter extends BaseAdapter{

    private List<Reservation> reservations = new ArrayList<>();
    private Context context;

    public ReservationAdapter(Context context, int resource, List<Reservation> reservations) {
        this.context = context;
        this.reservations = reservations;
    }

    @Override
    public int getCount() {
        return reservations.size();
    }

    @Override
    public Reservation getItem(int position) {
        return reservations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return reservations.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Reservation reservation = getItem(position);

        final View v;

        if(convertView == null){
            final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_reservation_entry, parent, false);
        }
        else {
            v = convertView;
        }

        TextView txtResId = (TextView) v.findViewById(R.id.txtResId);
        TextView txtResDate = (TextView) v.findViewById(R.id.txtResDate);
        TextView txtResTime = (TextView) v.findViewById(R.id.txtResTime);
        TextView txtResAmount = (TextView) v.findViewById(R.id.txtResAmount);

        String[] dateTime = reservation.getDateTime().split("T");
        String resDate = dateTime[0];
        String resTime = dateTime[1].substring(0,5);

        txtResId.setText(String.valueOf(reservation.getId()));
        txtResDate.setText(resDate);
        txtResTime.setText(resTime);
        txtResAmount.setText(String.valueOf(reservation.getAmount()));

        return v;
    }
}
