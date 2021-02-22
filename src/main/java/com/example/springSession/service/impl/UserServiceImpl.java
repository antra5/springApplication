package com.example.springSession.service.impl;

import com.example.springSession.dto.MyRequestDTO;
import com.example.springSession.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl()
    {
        System.out.println("Inside User Service Constructor");
    }
    @PostConstruct
    void init()
    {
        System.out.println("Inside User Service post construct");
    }
    @Override
    public boolean updateEmployee(MyRequestDTO request, String id) {
        System.out.println("Inside User Service"+request+ " id"+id);
        return false;
    }
}
