package com.zeta.assignment.service.impl;

import com.zeta.assignment.model.User;
import com.zeta.assignment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zeta.assignment.repo.UserRepository;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll(){
        List<User> userList =  userRepository.findAll();
        log.info("There are in total {} users : {}", userList.size(), userList.toString());
        return  userList;
    }

    @Override
    public User add(User newUser){
        User user = userRepository.save(newUser);
        log.info("New user added : {}", user);
        return  user;
    }


}
