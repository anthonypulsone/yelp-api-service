package com.anthonypulsone.yelpfusionapiproxycache.model;


import java.io.Serializable;
import java.util.ArrayList;

public class BusinessSearchResults implements Serializable {
    private ArrayList<Business> businesses;

    public BusinessSearchResults(ArrayList<Business> businesses) {
        this.businesses = businesses;
    }

    public BusinessSearchResults() {
    }

    public ArrayList<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(ArrayList<Business> businesses) {
        this.businesses = businesses;
    }
}
