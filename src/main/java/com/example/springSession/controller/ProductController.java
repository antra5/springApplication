package com.example.springSession.controller;

import com.example.springSession.dto.ProductResponseDTO;
import com.example.springSession.dto.SearchRequestDTO;
import com.example.springSession.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path="/search")
    public ProductResponseDTO getProduct(@RequestBody SearchRequestDTO searchRequestDTO)
    {
        return productService.getProduct(searchRequestDTO);

    }

}
