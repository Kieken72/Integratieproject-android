package com.reservatiesysteem.lotte.reservatiesysteem.service;

import com.reservatiesysteem.lotte.reservatiesysteem.model.Token;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.model.City;
import com.reservatiesysteem.lotte.reservatiesysteem.model.RegisterAccount;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by lotte on 8/02/2017.
 */

public interface API_Service {
    @GET("api/cities")
    Call<List<City>> getCities();

    @GET("api/branches/by-postal/{chosenPostalCode}")
    Call<List<Branch>> getBranchById(@Path("chosenPostalCode") int chosenPostalCode);

    @GET("api/branches/{branchId}")
    Call<Branch> getBranchDetails(@Path("branchId") int branchId);

    //ACCOUNT
    @POST("api/accounts/create")
    Call<RegisterAccount> createUser(@Body RegisterAccount account);

    @FormUrlEncoded
    @POST("oauth/token")
    Call<Token> getToken(@Field("Username") String username, @Field("Password")String password, @Field("grant_type")String grantType );
}
