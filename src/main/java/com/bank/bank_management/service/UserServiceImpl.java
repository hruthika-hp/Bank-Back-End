package com.bank.bank_management.service;

import com.bank.bank_management.dto.LoginDTO;
import com.bank.bank_management.dto.UserDTO;

import com.bank.bank_management.mapper.UserMapper;
import com.bank.bank_management.model.entity.User;
import com.bank.bank_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO login(LoginDTO loginDTO) {
        Optional<User> userOpt = userRepository.findByUsername(loginDTO.getUsername());
        if(userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = userOpt.get();
        if(!user.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO register(User user) {
        return UserMapper.toDTO(userRepository.save(user));
    }
}
