package com.reservatiesysteem.lotte.reservatiesysteem.service;

import com.reservatiesysteem.lotte.reservatiesysteem.model.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lotte on 8/02/2017.
 */

public interface API_Service {
    @GET("api/cities")
    Call<List<City>> getCities();

}
