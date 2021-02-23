package com.example.springSession.service.impl;

//import com.example.springSession.client.SearchClient;
import com.example.springSession.client.SearchClient;
import com.example.springSession.dto.ProductResponseDTO;
import com.example.springSession.dto.Products;
import com.example.springSession.dto.SearchRequestDTO;
import com.example.springSession.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SearchClient searchClient;

    @Override
    public ProductResponseDTO getProduct(SearchRequestDTO requestDTO) {
        Map<String, Object> product=searchClient.getProduct(requestDTO.getSearchTerm());
        ProductResponseDTO responseDTO=new ProductResponseDTO();
        List<Map<String, Object>> productResponseList=(List<Map<String, Object>>)((Map)product.get("response")).get("docs");

        List<Products> productsList=new ArrayList<Products>();
        for(int i=0;i<productResponseList.size();i++)
        {

            Products products=new Products();

            String title=(String) productResponseList.get(i).get("name");
            products.setTitle(title);
            String desc=(String) productResponseList.get(i).get("description");
            products.setDescription(desc);
            double price=(double) productResponseList.get(i).get("salePrice");
            products.setSalesPrice(price);
            int val=(int)productResponseList.get(i).get("isInStock");
            boolean b;
            if(val==1)
                b=true;
            else
                b=false;
            products.setInStock(b);
            productsList.add(products);
        }


        responseDTO.setProductsList(productsList);
        return responseDTO;

    }
}
