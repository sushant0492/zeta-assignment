package com.zeta.assignment.exception;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ManageExceptionHandlerTest {

    @Mock
    private ConstraintViolationException mockException;

    @InjectMocks
    private ManagedExceptionHandler myExceptionHandler;

    @Test
    public void testHandleConstraintViolationException() {
        MockitoAnnotations.openMocks(this);
        String expectedMessage = "Validation failed: Test Constraint Violation Message";
        ResponseEntity<String> expectedResponse = new ResponseEntity<>(expectedMessage, HttpStatus.BAD_REQUEST);
        Mockito.when(mockException.getMessage()).thenReturn("Test Constraint Violation Message");
        ResponseEntity<String> actualResponse = myExceptionHandler.handleConstraintViolationException(mockException);
        Assertions.assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        Assertions.assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }

}
