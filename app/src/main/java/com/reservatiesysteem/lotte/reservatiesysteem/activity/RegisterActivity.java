package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.reservatiesysteem.lotte.reservatiesysteem.R;
import com.reservatiesysteem.lotte.reservatiesysteem.model.RegisterAccount;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.txtUsername)
    EditText txtUsername;
    @BindView(R.id.txtFirstName)
    EditText txtFirstName;
    @BindView(R.id.txtLastName)
    EditText txtLastName;
    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.txtPassword)
    EditText txtPassword;
    @BindView(R.id.txtConfirmPassword)
    EditText txtConfirmPassword;

    API_Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String firstName = txtFirstName.getText().toString();
                String lastName = txtLastName.getText().toString();
                String eMail = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                String confirmPassword = txtConfirmPassword.getText().toString();

                RegisterAccount account = new RegisterAccount(eMail,username,firstName,lastName,password,confirmPassword);

                createNewUser(account);
            }
        });
    }
    public void createNewUser(RegisterAccount account){
        service = API.createService(API_Service.class);
        Call<RegisterAccount> call = service.createUser(account);
        call.enqueue(new Callback<RegisterAccount>() {
            @Override
            public void onResponse(Call<RegisterAccount> call, Response<RegisterAccount> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registratie gelukt", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Registratie failed: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterAccount> call, Throwable t) {
                Log.d("Failure btnRegister", t.getMessage());
            }
        });
    }
}
