package com.reservatiesysteem.lotte.reservatiesysteem.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.reservatiesysteem.lotte.reservatiesysteem.R;

/**
 * Created by Jasper on 23/02/2017.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        SharedPreferences preferences = getSharedPreferences(LoginActivity.TOKEN, Context.MODE_PRIVATE);
        String token =  preferences.getString(LoginActivity.TOKEN,"");
        if(token.equals("")){
            menu.findItem(R.id.login).setVisible(true);
        }else{
            menu.findItem(R.id.logout).setVisible(true);
            menu.findItem(R.id.myProfile).setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            case R.id.about:
                //// TODO: about page
                return true;
        }
        return true;
    }

}