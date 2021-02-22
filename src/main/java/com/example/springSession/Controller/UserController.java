package com.example.springSession.Controller;

import com.example.springSession.dto.MyRequestDTO;
import com.example.springSession.service.UserService;
import com.example.springSession.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
        System.out.println("Inside User Controller Constructor");
    }
    @PostConstruct
    void init()
    {
        System.out.println("Inside User Controller post construct");
    }
    @PostMapping(path = "/update/employee/{id}")
    public boolean updateEmployee(@PathVariable String id, @RequestBody MyRequestDTO request)
    {
        return userService.updateEmployee(request,id);
    }


}
