package com.zeta.assignment.service;

import com.zeta.assignment.model.User;
import com.zeta.assignment.repo.UserRepository;
import com.zeta.assignment.service.impl.UserServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    UserServiceImpl userServiceMock;

    UserServiceImpl userService;

    @Autowired
    UserRepository repository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        userServiceMock = new UserServiceImpl(userRepository);
        userService = new UserServiceImpl(repository);
    }

    @Test
    public void finaAllTest(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"Sushant","Sharma", "IT"));
        userList.add(new User(2,"Test",null, "Finance"));
        Mockito.doReturn(userList).when(userRepository).findAll();
        List<User> userList1 = userServiceMock.findAll();
        Assertions.assertEquals(  2, userList1.size());
       Assertions.assertTrue(userList1.equals(userList));
    }

    @Test
    public void addTest(){
       User user = new User();
       user.setFirstName("Test");
       user.setJobDescription("IT");
       User userSaved = userService.add(user);
       Assertions.assertEquals(  1, userSaved.getId() );
       Assertions.assertEquals("Test", user.getFirstName());
       Assertions.assertEquals("IT", user.getJobDescription());
    }

    @Test
    public void addTestWithoutFirstName(){
        User user = new User();
        user.setJobDescription("IT");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userService.add(user));
    }

    @Test
    public void addTestWithoutJobDesc(){
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userService.add(user));
    }

    @Test
    public void addTestWithOneCharName(){
        User user = new User();
        user.setFirstName("T");
        user.setJobDescription("User");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userService.add(user));
    }

    @Test
    public void addTestWithOneCharLastName(){
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("l");
        user.setJobDescription("User");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userService.add(user));
    }

    @Test
    public void addTestWithOneCharJobDesc(){
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Name");
        user.setJobDescription("i");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userService.add(user));
    }

}
