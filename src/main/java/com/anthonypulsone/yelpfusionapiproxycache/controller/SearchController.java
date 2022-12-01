package com.anthonypulsone.yelpfusionapiproxycache.controller;

import com.anthonypulsone.yelpfusionapiproxycache.model.BusinessSearchResults;
import com.anthonypulsone.yelpfusionapiproxycache.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/{searchString}")
    public ResponseEntity<BusinessSearchResults> getBusiness(@PathVariable("searchString") String searchString) {
        BusinessSearchResults searchResults = searchService.getSearch(searchString);

        return new ResponseEntity<BusinessSearchResults>(searchResults, HttpStatus.OK);
    }
}
