package com.easydevelop.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    public String email;
    public String firstName;
    public String lastName;
    public String password;
    public String confirmPassword;
}
