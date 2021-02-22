package com.example.springSession.dto;

public class SearchRequestDTO {
    private String searchTerm;

    public String getProduct() {
        return searchTerm;
    }

    public void setProduct(String searchTerm) {
        this.searchTerm = searchTerm;
    }

}

