package com.bank.bank_management.controller;

import com.bank.bank_management.dto.LoginDTO;
import com.bank.bank_management.dto.UserDTO;
import com.bank.bank_management.model.entity.User;
import com.bank.bank_management.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @PostMapping("/register")
    public UserDTO register(@RequestBody User user) {
        return userService.register(user);
    }
}
