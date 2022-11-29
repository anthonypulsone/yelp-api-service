package com.anthonypulsone.yelpfusionapiproxycache.client;

import com.anthonypulsone.yelpfusionapiproxycache.model.Business;
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
public class BusinessClient {


    @Value("${yelpApi.url}")
    private String apiUrl;

    @Value("${yelpApi.token}")
    private String apiToken;

    private final RestTemplate restTemplate;

    @Autowired
    public BusinessClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<Business> getBusiness(String businessId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiToken);
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(apiUrl + businessId, HttpMethod.GET, request, Business.class);
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiToken);
        return headers;
    }
}
