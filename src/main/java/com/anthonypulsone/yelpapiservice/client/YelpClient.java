package com.anthonypulsone.yelpapiservice.client;

import com.anthonypulsone.yelpapiservice.model.Business;
import com.anthonypulsone.yelpapiservice.model.BusinessSearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YelpClient {


    @Value("${yelpApi.url}")
    private String apiUrl;

    @Value("${yelpApi.token}")
    private String apiToken;

    private final RestTemplate restTemplate;

    @Autowired
    public YelpClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<Business> getBusiness(String businessId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiToken);
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(apiUrl + businessId, HttpMethod.GET, request, Business.class);
    }

    public ResponseEntity<BusinessSearchResults> getSearch(String searchString) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiToken);
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(apiUrl + "search?" + searchString, HttpMethod.GET, request, BusinessSearchResults.class);
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiToken);
        return headers;
    }
}
