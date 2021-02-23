package com.example.springSession.dto;

import java.util.List;

public class ProductResponseDTO {
    List<Products> productsList;
    List<Products> locationBasedProductsList;

    public List<Products> getLocationBasedProductsList() {
        return locationBasedProductsList;
    }

    public void setLocationBasedProductsList(List<Products> locationBasedProductsList) {
        this.locationBasedProductsList = locationBasedProductsList;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
