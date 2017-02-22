package com.reservatiesysteem.lotte.reservatiesysteem.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jasper on 22/02/2017.
 */

public class RegisterAccount {
    @SerializedName("Email")
    private String email;
    @SerializedName("Username")
    private String username;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Password")
    private String password;
    @SerializedName("ConfirmPassword")
    private String confirmPassword;

    public RegisterAccount(String email, String username, String firstName, String lastName, String password, String confirmPassword) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
