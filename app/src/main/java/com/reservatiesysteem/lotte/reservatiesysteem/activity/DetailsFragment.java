package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lotte on 13/02/2017.
 */

public class DetailsFragment extends Fragment {

    @BindView(R.id.btnFotos) Button btnFotos;
    @BindView(R.id.btnPlace) Button btnPlace;
    @BindView(R.id.viewFoto) ImageView viewFoto;
    @BindView(R.id.viewPlaats) ImageView viewPlaats;
    @BindView(R.id.btnBeschrijving) Button btnBeschrijving;
    @BindView(R.id.viewBeschrijving) TextView viewBeschrijving;
    @BindView(R.id.btnUren) Button btnUren;
    @BindView(R.id.btnInfo) Button btnInfo;
    @BindView(R.id.viewUrenInfo) TextView viewUrenInfo;
    @BindView(R.id.btnReserveren) Button btnReserveren;

    private int receivedBranchId;

    public DetailsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_branchdetails, container, false);
        ButterKnife.bind(this,view);

        Bundle bundle = getArguments();
        if(bundle != null){
            receivedBranchId = bundle.getInt("branchId", 0);
        }

        getBranchDetails();

        //TODO GET picture branch
        viewFoto.setImageResource(R.drawable.wima);

        btnFotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewFoto.getVisibility() == View.GONE){
                    viewFoto.setVisibility(View.VISIBLE);
                } else if(viewFoto.getVisibility() == View.VISIBLE){
                    viewFoto.setVisibility(View.GONE);
                }
                if(viewPlaats.getVisibility() == View.VISIBLE){
                    viewPlaats.setVisibility(View.GONE);
                }


            }
        });

        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPlaats.getVisibility() == View.GONE){
                    viewPlaats.setVisibility(View.VISIBLE);
                } else if(viewPlaats.getVisibility() == View.VISIBLE){
                    viewPlaats.setVisibility(View.GONE);
                }
                if(viewFoto.getVisibility() == View.VISIBLE){
                    viewFoto.setVisibility(View.GONE);
                }

               // viewPlaats.setImageResource(R.drawable.maps);
            }
        });

        btnBeschrijving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnUren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnReserveren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private void getBranchDetails(){
        API_Service service = API.createService(API_Service.class);
        Call<Branch> call = service.getBranchDetails(receivedBranchId);
        call.enqueue(new Callback<Branch>() {
            @Override
            public void onResponse(Call<Branch> call, Response<Branch> response) {
                Branch branch = response.body();
                viewBeschrijving.setText(branch.getId() + " " + branch.getName() + " " + branch.getStreet());
            }

            @Override
            public void onFailure(Call<Branch> call, Throwable t) {
                Log.d("Error receiving details", t.getMessage());
            }
        });
    }
}
