package com.bank.bank_management.service;


import com.bank.bank_management.dto.LoginDTO;
import com.bank.bank_management.dto.UserDTO;
import com.bank.bank_management.model.entity.User;

public interface UserService {
    UserDTO login(LoginDTO loginDTO);
    UserDTO register(User user); // Optional for creating Admin/User
}