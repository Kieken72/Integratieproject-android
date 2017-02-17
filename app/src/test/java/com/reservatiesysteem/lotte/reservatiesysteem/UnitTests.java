package com.reservatiesysteem.lotte.reservatiesysteem;


import android.widget.ArrayAdapter;


import com.reservatiesysteem.lotte.reservatiesysteem.model.City;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Jasper on 10/02/2017.
 */

public class UnitTests {
    @Test
    public void test_getGemeentes() throws InterruptedException {
        API_Service service = API.createService(API_Service.class);
        Call<List<City>> call = service.getCities();

        call.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                List<City> cities = response.body();
                assertNotNull("cities should not be empty",cities);
                assertTrue("cities should be bigger than 1",cities.size()<0);
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {

            }
        });
        Thread.sleep(5000);
    }
}
