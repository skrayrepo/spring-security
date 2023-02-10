package com.easydevelop.springsecurity.controller;

import com.easydevelop.springsecurity.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @GetMapping("/userLogin")
    public String login(){
        return "Welcome to Login page";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody UserRequest request){
        Authentication authentication = authenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword()));
        if(authentication.isAuthenticated()){
            return "Welcome to Home page";
        }else{
            return "Welcome to Login page";
        }
    }


    @GetMapping("/home")
    public String home(){
       return "Welcome to Home page";
    }

    @GetMapping("/admin")
    public String adminAccess(){
        return "Welcome to Admin page";
    }

    @GetMapping("/user")
    public String userAccess(){
        return "Welcome to User Page";
    }
}
