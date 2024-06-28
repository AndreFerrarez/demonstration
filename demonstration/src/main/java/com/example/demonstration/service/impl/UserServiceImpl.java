package com.example.demonstration.service.impl;

import com.example.demonstration.domain.model.Repository.UserRepository;
import com.example.demonstration.domain.model.User;
import com.example.demonstration.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("Account Number Already Exists");

        }
        return userRepository.save(userToCreate);
    }
}
