package com.reservatiesysteem.lotte.reservatiesysteem.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Jasper on 10/02/2017.
 */
public class Branch {
    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Street")
    private String street;
    @SerializedName("Number")
    private String number;
    @SerializedName("Box")
    private String box;
    @SerializedName("CiyId")
    private int cityId;
    @SerializedName("City")
    private City city;
    //@SerializedName("Picture")
    //private Image picture;
    @SerializedName("PhoneNumber")
    private String phoneNumber;
    @SerializedName("Email")
    private String email;
    @SerializedName("CompanyId")
    private int companyId;

    @SerializedName("OpeningHours")
    private ArrayList<OpeningHour> openingHours;

    /*public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }*/
    /*
    @SerializedName("Rooms")
    private String rooms;

    @SerializedName("AdditionalInfos")
    private String additionalInfo;
    @SerializedName("Reviews")
    private String reviews;
    @SerializedName("Messages")
    private String messages;
    @SerializedName("Reservations")
    private String reservations;*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<OpeningHour> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(ArrayList<OpeningHour> openingHours) {
        this.openingHours = openingHours;
    }
}
