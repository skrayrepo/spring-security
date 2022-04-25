package com.easydevelop.springsecurity.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    @Column(length = 60)
    private String password;
    private boolean enabled = false;
}
