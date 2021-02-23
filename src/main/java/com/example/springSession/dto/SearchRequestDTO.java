package com.example.springSession.dto;

public class SearchRequestDTO {
    private String searchTerm;
    private String locationSearchTerm;

    public String getLocationSearchTerm() {
        return locationSearchTerm;
    }

    public void setLocationSearchTerm(String locationSearchTerm) {
        this.locationSearchTerm = locationSearchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
        return searchTerm;
    }



}

