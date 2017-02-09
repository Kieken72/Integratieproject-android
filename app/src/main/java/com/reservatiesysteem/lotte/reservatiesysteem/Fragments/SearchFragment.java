package com.reservatiesysteem.lotte.reservatiesysteem.Fragments;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.activity.StartActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class SearchFragment extends Fragment {
    @BindView(R.id.btnReserveer)Button button;

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
        return view;
    }
}
