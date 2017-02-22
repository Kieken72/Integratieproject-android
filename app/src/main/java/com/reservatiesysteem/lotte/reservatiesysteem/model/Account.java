package com.reservatiesysteem.lotte.reservatiesysteem.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lotte on 22/02/2017.
 */

public class Account {
    @SerializedName("Id")
    private String id;
    @SerializedName("UserName")
    private String username;
    @SerializedName("FullName")
    private String fullname;
    @SerializedName("Email")
    private String email;

    public Account( String username, String fullname, String email) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
