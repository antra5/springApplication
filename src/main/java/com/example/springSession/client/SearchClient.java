package com.example.springSession.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Objects;

@FeignClient(name = "search-client", url = "10.177.68.40:8983")
public interface SearchClient {
    /**
     *
     * http://10.177.68.40:8983/solr/productCollection/select?q=oneplus
     *
     */
    @RequestMapping(method = RequestMethod.GET, path = "/solr/productCollection/select")
    //@RequestParam() int rows=10
    public Map<String, Object> getProduct(@RequestParam("q") String query);
}
