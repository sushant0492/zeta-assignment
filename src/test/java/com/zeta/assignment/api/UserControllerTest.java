package com.zeta.assignment.api;

import com.zeta.assignment.model.User;
import com.zeta.assignment.service.UserService;
import com.zeta.assignment.service.impl.UserServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class UserControllerTest {

    UserController userController;

    UserController userControllerMock;

    @Mock
    UserService userService;

    @Autowired
    UserService service;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        userControllerMock = new UserController(userService);
        userController = new UserController(service);
    }


    @Test
    public void testGetUserList(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(1,"Sushant","Sharma", "IT"));
        userList.add(new User(2,"Test",null, "Finance"));
        doReturn(userList).when(userService).findAll();
        List<User> userList1 = userControllerMock.getUserList();
        Assertions.assertTrue(userList.equals(userList1));
    }

    @Test
    public void addUserTest(){
        User user = new User();
        user.setFirstName("Test");
        user.setJobDescription("IT");
        User userSaved = userController.addUser(user);
        Assertions.assertEquals(  1, userSaved.getId() );
        Assertions.assertEquals("Test", user.getFirstName());
        Assertions.assertEquals("IT", user.getJobDescription());
    }

    @Test
    public void addTestWithoutFirstName(){
        User user = new User();
        user.setJobDescription("IT");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userController.addUser(user));
    }

    @Test
    public void addTestWithoutJobDesc(){
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userController.addUser(user));
    }

    @Test
    public void addTestWithOneCharName(){
        User user = new User();
        user.setFirstName("T");
        user.setJobDescription("User");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userController.addUser(user));
    }

    @Test
    public void addTestWithOneCharLastName(){
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("l");
        user.setJobDescription("User");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userController.addUser(user));
    }

    @Test
    public void addTestWithOneCharJobDesc(){
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Name");
        user.setJobDescription("i");
        Assertions.assertThrows(ConstraintViolationException.class, ()->userController.addUser(user));
    }
}
