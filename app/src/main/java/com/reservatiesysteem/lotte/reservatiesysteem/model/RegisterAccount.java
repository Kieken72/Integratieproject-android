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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
