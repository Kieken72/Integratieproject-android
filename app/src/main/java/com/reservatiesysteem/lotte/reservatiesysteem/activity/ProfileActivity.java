package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.adapter.ReservationAdapter;
import com.reservatiesysteem.lotte.reservatiesysteem.model.ProfileAccount;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lotte on 26/02/2017.
 */

public class ProfileActivity extends BaseActivity {

    @BindView(R.id.txtProfFirstName) TextView txtFirstname;
    @BindView(R.id.txtProfSurname) TextView txtSurname;
    @BindView(R.id.txtProfMail) TextView txtEmail;
    @BindView(R.id.editFirstname) EditText firstname;
    @BindView(R.id.editSurname) EditText surname;
    @BindView(R.id.editEmail) EditText email;
    @BindView(R.id.listReservations) ListView lvReservations;
    //@BindView(R.id.btnCheckRes) Button btnCheckRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        ButterKnife.bind(this);

        getAccount();

    }

    private void getAccount(){
        Activity activity = ProfileActivity.this;
        SharedPreferences sharedPreferences = activity.getSharedPreferences(LoginActivity.TOKEN, Context.MODE_PRIVATE);
        String token = sharedPreferences.getString(LoginActivity.TOKEN,"");

        final API_Service service = API.createService(API_Service.class, token);
        Call<ProfileAccount> call = service.getProfile();
        call.enqueue(new Callback<ProfileAccount>() {
            @Override
            public void onResponse(Call<ProfileAccount> call, Response<ProfileAccount> response) {
                ProfileAccount profileAccount = response.body();

                firstname.setText(profileAccount.getFirstname());
                surname.setText(profileAccount.getSurname());
                email.setText(profileAccount.getEmail());

                //reservaties van user bekijken
                final ReservationAdapter reservationAdapter = new ReservationAdapter(ProfileActivity.this, R.layout.view_reservation_entry, response.body().getReservations());
                lvReservations.setAdapter(reservationAdapter);
            }

            @Override
            public void onFailure(Call<ProfileAccount> call, Throwable t) {

            }
        });

    }
}
