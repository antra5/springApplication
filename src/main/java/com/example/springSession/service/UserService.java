package com.example.springSession.service;

import com.example.springSession.dto.MyRequestDTO;

public interface UserService {
    boolean updateEmployee(MyRequestDTO request, String id);
}
