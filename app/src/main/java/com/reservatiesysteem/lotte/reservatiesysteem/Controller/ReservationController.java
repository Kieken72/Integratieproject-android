package com.reservatiesysteem.lotte.reservatiesysteem.controller;

import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.model.City;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by Jasper on 10/02/2017.
 */

public class ReservationController {
    public ArrayList<City> getCities() {
        ArrayList<City>cities = new ArrayList<>();
        API_Service service = API.createService(API_Service.class);
        Call<List<City>> call = service.getCities();
        try {
            cities = (ArrayList<City>) call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
    public ArrayList<Branch> getBranchesByPostcode(int postcode){
        return null;
    }
}
