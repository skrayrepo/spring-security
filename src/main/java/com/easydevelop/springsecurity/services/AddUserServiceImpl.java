package com.easydevelop.springsecurity.services;

import com.easydevelop.springsecurity.entity.User;
import com.easydevelop.springsecurity.model.AddUserRequest;
import com.easydevelop.springsecurity.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AddUserServiceImpl implements AddUserService{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDetailRepository userDetailRepository;
    @Override
    public User registerUser(AddUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        String pass = passwordEncoder.encode(request.getPassword());
        System.out.println("Before put in object"+pass);
        user.setPassword(pass);
        System.out.println("After put in object"+user.getPassword());
        user.setRole("USER");
        user= userDetailRepository.save(user);
        return user;
    }

}
