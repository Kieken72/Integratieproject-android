package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ServiceCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.reservatiesysteem.lotte.reservatiesysteem.R;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class ResultListFragment extends Fragment {

    @BindView(R.id.txtChosenCity)
    TextView txtChosenCity;
    @BindView(R.id.txtChosenDate)
    TextView txtChosenDate;
    @BindView(R.id.txtChosenTime)
    TextView txtChosenTime;
    @BindView(R.id.txtChosenPersons)
    TextView txtChosenPersons;

    //transfer data from searchfragment
    private String chosenCity = "";
    private String chosenDate = "";
    private String chosenTime = "";
    private String chosenNumberOfPersons = "";



    public ResultListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //transfer data from searchfragment
        Bundle bundle = getArguments();

        if(bundle != null){
            chosenCity = bundle.getString(SearchFragment.CHOSEN_CITY);
            chosenDate = bundle.getString(SearchFragment.CHOSEN_DATE);
            chosenTime = bundle.getString(SearchFragment.CHOSEN_TIME);
            chosenNumberOfPersons = bundle.getString(SearchFragment.CHOSEN_NUMBEROFPERSONS);
        }

        txtChosenCity.setText(chosenCity);
        txtChosenDate.setText(chosenDate);
        txtChosenTime.setText(chosenTime);
        txtChosenPersons.setText(chosenNumberOfPersons);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listresult, container, false);
    }

    private void getBranches(){

    }
}
