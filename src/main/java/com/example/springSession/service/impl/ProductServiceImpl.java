package com.example.springSession.service.impl;

import com.example.springSession.dto.ProductResponseDTO;
import com.example.springSession.dto.Products;
import com.example.springSession.dto.SearchRequestDTO;
import com.example.springSession.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductResponseDTO getProduct(SearchRequestDTO requestDTO) {
        ProductResponseDTO responseDTO=new ProductResponseDTO();
        Products products=new Products();
        products.setDescription("New Phone");
        products.setSalesPrice(28000);
        products.setInStock(true);
        products.setTitle("OnePlus Nord");
        responseDTO.setProductsList(Arrays.asList(products));
        return responseDTO;

    }
}
