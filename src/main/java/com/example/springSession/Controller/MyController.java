package com.example.springSession.Controller;

import com.example.springSession.dto.MyRequestDTO;
import com.example.springSession.dto.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController

public class MyController {
    @GetMapping(path = "/hello")
    public String helloWorld()
    {
        return "success!!";
    }
    @PostMapping(path = "/hello-post")
    public String helloPost()
    {
        return "success-post";
    }
    @GetMapping(path = "/hello-query")
    public String helloQuery(@RequestParam String query)
    {
        return "query:"+query;

    }
    @PostMapping(value = "/regist")
    public String registerUser(@RequestBody MyRequestDTO request)
    {
        return request.toString();
    }
    @GetMapping(value = "/employee/{employeeID}")
    public MyResponseDTO getEmployeeDetails(@PathVariable String employeeID)
    {
        MyResponseDTO responseDTO=new MyResponseDTO();
        responseDTO.setId(employeeID);
        return responseDTO;
    }
    //@PutMapping
    //@DeleteMapping
}
