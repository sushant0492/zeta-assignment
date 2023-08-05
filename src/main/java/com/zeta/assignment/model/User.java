package com.zeta.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "The full name is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    private String firstName;
    @Size(min = 2, max = 100, message = "The length of last name must be between 2 and 100 characters.")
    private String lastName;
    @NotEmpty(message = "Job Description details are required.")
    @Size(min = 2, max = 100, message = "The length of job description details must be between 2 and 100 characters.")
    private String jobDescription;
}
