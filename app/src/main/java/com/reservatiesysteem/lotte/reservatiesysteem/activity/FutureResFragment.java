package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lotte on 27/02/2017.
 */

public class FutureResFragment extends Fragment {
    @BindView(R.id.titleRes)
    TextView txtTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkres, container, false);
        ButterKnife.bind(this, view);

        txtTitle.setText("Toekomstige reservaties");

        return view;
    }
}
