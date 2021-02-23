package com.example.springSession.service.impl;

//import com.example.springSession.client.SearchClient;
import com.example.springSession.client.SearchClient;
import com.example.springSession.constants.SolrFieldNames;
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
public class ProductServiceImpl implements ProductService, SolrFieldNames {
    @Autowired
    private SearchClient searchClient;

    @Override
    public ProductResponseDTO getProduct(SearchRequestDTO requestDTO) {
        Map<String, Object> product=searchClient.getProduct(requestDTO.getSearchTerm());
        Map<String, Object> locationProducts=searchClient.getProduct("stockLocation:"+requestDTO.getLocationSearchTerm());
        ProductResponseDTO responseDTO=new ProductResponseDTO();
        List<Map<String, Object>> productResponseList=(List<Map<String, Object>>)((Map)product.get("response")).get("docs");
        List<Map<String, Object>> productLocationResponseList=(List<Map<String, Object>>)((Map)locationProducts.get("response")).get("docs");
        List<Products> productsList=new ArrayList<Products>();
        List<Products> productsList2=new ArrayList<Products>();
        for(int i=0;i<productLocationResponseList.size();i++)
        {
            Products products=new Products();
            String title=(String) productLocationResponseList.get(i).get(NAME);
            products.setTitle(title);
            String desc=(String) productLocationResponseList.get(i).get(DESCRIPTION);
            products.setDescription(desc);
            double price=(double) productLocationResponseList.get(i).get("salePrice");
            products.setSalesPrice(price);
            int val=(int)productLocationResponseList.get(i).get(ISINSTOCK);
            boolean b;
            if(val==1)
                b=true;
            else
                b=false;
            products.setInStock(b);
            productsList2.add(products);
        }

        for(int i=0;i<productResponseList.size();i++)
        {

            Products products=new Products();

            String title=(String) productResponseList.get(i).get(NAME);
            products.setTitle(title);
            String desc=(String) productResponseList.get(i).get(DESCRIPTION);
            products.setDescription(desc);
            double price=(double) productResponseList.get(i).get("salePrice");
            products.setSalesPrice(price);
            int val=(int)productResponseList.get(i).get(ISINSTOCK);
            boolean b;
            if(val==1)
                b=true;
            else
                b=false;
            products.setInStock(b);
            productsList.add(products);
        }


        responseDTO.setProductsList(productsList);
        responseDTO.setLocationBasedProductsList(productsList2);
        return responseDTO;

    }

}
