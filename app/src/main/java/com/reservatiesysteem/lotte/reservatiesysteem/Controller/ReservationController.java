package com.reservatiesysteem.lotte.reservatiesysteem.controller;

import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.model.City;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API;
import com.reservatiesysteem.lotte.reservatiesysteem.service.API_Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by Jasper on 10/02/2017.
 */

public class ReservationController {
    public ArrayList<City> getCities() {
        API_Service service = API.createService(API_Service.class);
        Call<List<City>> call = service.getCities();
        
        return new ArrayList<>();
    }
    public ArrayList<Branch> getBranchesByPostcode(int postcode){
        return null;
    }
}
