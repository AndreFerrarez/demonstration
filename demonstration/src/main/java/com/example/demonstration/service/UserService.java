package com.example.demonstration.service;

import com.example.demonstration.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userCreate);

}
