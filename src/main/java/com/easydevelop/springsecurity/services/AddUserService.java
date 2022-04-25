package com.easydevelop.springsecurity.services;

import com.easydevelop.springsecurity.entity.User;
import com.easydevelop.springsecurity.model.AddUserRequest;
import com.easydevelop.springsecurity.model.UserRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AddUserService {
    User registerUser(AddUserRequest request);

}
