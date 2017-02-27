package com.reservatiesysteem.lotte.reservatiesysteem.model;

import android.widget.ArrayAdapter;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by lotte on 26/02/2017.
 */

public class ProfileAccount implements Serializable {
    @SerializedName("Email")
    private String email;
    @SerializedName("Surname")
    private String surname;
    @SerializedName("Firstname")
    private String firstname;

    @SerializedName("Reservations")
    private ArrayList<Reservation> reservations;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
}
