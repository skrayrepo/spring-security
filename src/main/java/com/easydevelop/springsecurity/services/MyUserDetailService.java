package com.easydevelop.springsecurity.services;

import com.easydevelop.springsecurity.entity.User;
import com.easydevelop.springsecurity.model.MyUserDetails;
import com.easydevelop.springsecurity.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserDetailRepository userDetailRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userDetailRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found"+email));
        return user.map(MyUserDetails::new).get();
    }
}
