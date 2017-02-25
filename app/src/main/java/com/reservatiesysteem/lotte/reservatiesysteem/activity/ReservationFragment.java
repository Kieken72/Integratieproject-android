package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lotte on 24/02/2017.
 */

public class ReservationFragment extends Fragment {

    @BindView(R.id.branchNameRes) TextView txtBranchNameRes;
    @BindView(R.id.dateRes) TextView txtDateRes;
    @BindView(R.id.timeRes) TextView txtTimeRes;
    @BindView(R.id.numberRes) TextView txtNumberRes;

    @BindView(R.id.btnConfirmRes)
    Button btnConfirmRes;

    //transfer data from searchfragment
    private String chosenDate = "";
    private String chosenTime = "";
    private String chosenNumberOfPersons = "";
    private String branchName = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //transfer data from searchfragment
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if(bundle != null){
            chosenDate = bundle.getString(SearchFragment.CHOSEN_DATE);
            chosenTime = bundle.getString(SearchFragment.CHOSEN_TIME);
            chosenNumberOfPersons = bundle.getString(SearchFragment.CHOSEN_NUMBEROFPERSONS);
            branchName = bundle.getString("branchName");
        }

        txtBranchNameRes.setText(branchName);
        txtDateRes.setText(chosenDate);
        txtTimeRes.setText(chosenTime);
        txtNumberRes.setText(chosenNumberOfPersons +" personen");

        btnConfirmRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //API_Service service = API.createService(API_Service.class);
            }
        });



        return view;
    }
}
