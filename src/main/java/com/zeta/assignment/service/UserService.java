package com.zeta.assignment.service;

import com.zeta.assignment.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    User add(User newUser);
}
