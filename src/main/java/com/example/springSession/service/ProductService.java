package com.example.springSession.service;

import com.example.springSession.dto.ProductResponseDTO;
import com.example.springSession.dto.SearchRequestDTO;

public interface ProductService {
    ProductResponseDTO getProduct(SearchRequestDTO searchRequestDTO);
}
