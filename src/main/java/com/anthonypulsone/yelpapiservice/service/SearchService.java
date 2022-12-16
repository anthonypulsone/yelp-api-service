package com.anthonypulsone.yelpapiservice.service;

import com.anthonypulsone.yelpapiservice.client.YelpClient;
import com.anthonypulsone.yelpapiservice.model.Business;
import com.anthonypulsone.yelpapiservice.model.BusinessSearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchService {

    private final YelpClient yelpClient;

    private final Cache cache;

    @Autowired
    public SearchService(YelpClient yelpClient, CacheManager cacheManager) {
        this.yelpClient = yelpClient;
        this.cache = cacheManager.getCache("business");
    }

    public BusinessSearchResults getSearch(String searchString) {
        BusinessSearchResults businessSearchResults = yelpClient.getSearch(searchString).getBody();

        List<Business> businesses = businessSearchResults.getBusinesses();
        businesses.forEach(this::cacheBusiness);
        return businessSearchResults;
    }

    private void cacheBusiness(Business business) {
        cache.putIfAbsent(business.getId(), business);
    }
}
