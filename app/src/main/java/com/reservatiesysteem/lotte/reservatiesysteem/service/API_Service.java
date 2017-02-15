package com.reservatiesysteem.lotte.reservatiesysteem.service;

import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.model.City;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lotte on 8/02/2017.
 */

public interface API_Service {
    @GET("api/cities")
    Call<List<City>> getCities();

    @GET("api/branches/by-postal/{id}")
    Call<List<Branch>> getBranchById(@Path("id") int chosenPostalCode);
}
