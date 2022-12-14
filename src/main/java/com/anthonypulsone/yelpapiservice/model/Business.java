package com.anthonypulsone.yelpapiservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Business implements Serializable {
    private String id;
    private String alias;
    private String name;
    @JsonProperty("image_url")
    private String imageUrl;
    private String url;
    private String phone;
    @JsonProperty("display_phone")
    private String displayPhone;
    @JsonProperty("review_count")
    private int reviewCount;
    private ArrayList<Category> categories;
    private double rating;
    private Location location;
    private Coordinates coordinates;
    private String price;

    public Business(String id, String alias, String name, String imageUrl, String url, String phone, String displayPhone, int reviewCount, ArrayList<Category> categories, double rating, Location location, Coordinates coordinates, String price) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.imageUrl = imageUrl;
        this.url = url;
        this.phone = phone;
        this.displayPhone = displayPhone;
        this.reviewCount = reviewCount;
        this.categories = categories;
        this.rating = rating;
        this.location = location;
        this.coordinates = coordinates;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
