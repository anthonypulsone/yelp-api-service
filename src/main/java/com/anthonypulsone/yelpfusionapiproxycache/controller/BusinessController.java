package com.anthonypulsone.yelpfusionapiproxycache.controller;

import com.anthonypulsone.yelpfusionapiproxycache.model.Business;
import com.anthonypulsone.yelpfusionapiproxycache.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path ="/business")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    public BusinessController (BusinessService businessService){
        this.businessService = businessService;
    }

    @GetMapping("/{businessId}")
    public ResponseEntity<Business> getBusiness(@PathVariable("businessId") String businessId) {
        Business business = businessService.getBusiness(businessId);
        return new ResponseEntity<Business>(business, HttpStatus.OK);
    }

}
