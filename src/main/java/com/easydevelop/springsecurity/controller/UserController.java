package com.easydevelop.springsecurity.controller;

import com.easydevelop.springsecurity.entity.User;
import com.easydevelop.springsecurity.model.AddUserRequest;
import com.easydevelop.springsecurity.model.UserRequest;
import com.easydevelop.springsecurity.services.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    AddUserService addUserService;

    @PostMapping("/registerUser")
    public String registerUser(@RequestBody AddUserRequest addUserRequest, HttpServletRequest request){
        User user = addUserService.registerUser(addUserRequest);
        /*UUID token = UUID.randomUUID();
        addUserService.saveVerificationToken(user,token.toString());
        System.out.println("Registration link ="+request.getContextPath()+":8080/verificationUser?"+"token="+token);*/
        return "success";
    }


}
