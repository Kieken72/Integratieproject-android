package com.reservatiesysteem.lotte.reservatiesysteem.service;

import com.reservatiesysteem.lotte.reservatiesysteem.model.Message;
import com.reservatiesysteem.lotte.reservatiesysteem.model.ProfileAccount;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Token;
import com.reservatiesysteem.lotte.reservatiesysteem.model.Branch;
import com.reservatiesysteem.lotte.reservatiesysteem.model.City;
import com.reservatiesysteem.lotte.reservatiesysteem.model.RegisterAccount;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    @GET("api/reservations/{branchId}")
    Call<Branch> getBranchAvailability(@Path("branchId")int branchid, @Query("DateTime")String datetime, @Query("Amount")int amount);

    //ACCOUNT
    @POST("api/accounts/create")
    Call<RegisterAccount> createUser(@Body RegisterAccount account);

    @FormUrlEncoded
    @POST("oauth/token")
    Call<Token> getToken(@Field("Username") String username, @Field("Password")String password, @Field("grant_type")String grantType );

    @FormUrlEncoded
    @POST("api/reservations")
    Call<Object> createReservation(@Field("BranchId")int branchId, @Field("DateTime")String DateTime, @Field("Amount")int Amount);

    @GET("api/accounts")
    Call<ProfileAccount> getProfile();

    //MESSAGES
    @GET("api/messages/{reservationId}")
    Call<List<Message>> getMessagesByResId(@Path("resId") int resId);

}
