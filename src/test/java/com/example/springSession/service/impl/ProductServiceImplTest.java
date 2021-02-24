package com.example.springSession.service.impl;

import com.example.springSession.client.SearchClient;
import com.example.springSession.dto.ProductResponseDTO;
import com.example.springSession.dto.SearchRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl searchService;

    @Mock
    private SearchClient searchClient;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getProducts(){
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String,Object> searchTermMockObject= null;
        try {
            searchTermMockObject = objectMapper.readValue(new URL("file:src/test/resources/search.mock"), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> locationMockObject= null;
        try {
            locationMockObject = objectMapper.readValue(new URL("file:src/test/resources/location.mock"), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Mockito.when(searchClient.getProduct("stockLocation:Jakarta")).thenReturn(locationMockObject);
        Mockito.when(searchClient.getProduct("samsung")).thenReturn(searchTermMockObject);

        SearchRequestDTO requestDTO=new SearchRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocationSearchTerm("Jakarta");
        ProductResponseDTO response=searchService.getProduct(requestDTO);
        assertEquals(response.getProductsList().size(),10);
        assertEquals(response.getLocationBasedProductsList().size(),10);

       // Mockito.verify(searchClient)
    }
    @Test
    public void testGetProductsExceptionTest() throws IOException
    {
        ObjectMapper objectMapper=new ObjectMapper();
        Map<String,Object> searchTermMockObject= objectMapper.readValue(new URL("file:src/test/resources/search.mock"), Map.class);
        Mockito.when(searchClient.getProduct("stockLocation:Jakarta")).thenThrow(NullPointerException.class);
        Mockito.when(searchClient.getProduct("samsung")).thenReturn(searchTermMockObject);
        //Map<String,Object> locationMockObject= null;
        SearchRequestDTO requestDTO=new SearchRequestDTO();
        requestDTO.setSearchTerm("samsung");
        requestDTO.setLocationSearchTerm("Jakarta");
        ProductResponseDTO response=searchService.getProduct(requestDTO);

        assertEquals(response.getProductsList().size(),10);
        assertEquals(response.getLocationBasedProductsList(),null);

        Mockito.verify(searchClient).getProduct("stockLocation:Jakarta");
        Mockito.verify(searchClient).getProduct("samsung");


    }

}