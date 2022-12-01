package com.anthonypulsone.yelpfusionapiproxycache.service;

import com.anthonypulsone.yelpfusionapiproxycache.client.YelpClient;
import com.anthonypulsone.yelpfusionapiproxycache.model.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private final YelpClient yelpClient;

    @Autowired
    public BusinessService(YelpClient yelpClient) {
        this.yelpClient = yelpClient;
    }

    @Cacheable("business")
    public Business getBusiness(String businessId) {

        ResponseEntity<Business> businessResponse = yelpClient.getBusiness(businessId);
        return businessResponse.getBody();
    }

}
