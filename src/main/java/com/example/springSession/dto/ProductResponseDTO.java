package com.example.springSession.dto;

import java.util.List;

public class ProductResponseDTO {
    List<Products> productsList;

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
