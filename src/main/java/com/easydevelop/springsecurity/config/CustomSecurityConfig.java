package com.easydevelop.springsecurity.config;

import com.easydevelop.springsecurity.services.CustomAuthenticationProvier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {
    private static String[] WHITE_LIST={
            "/authenticate"


    };
    @Autowired
    CustomAuthenticationProvier customAuthenticationProvier;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(WHITE_LIST).permitAll();
                //.antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/home").hasAnyRole("ADMIN","USER")
                //.antMatchers("/users").hasRole("USER")
                //.and()
                //.formLogin().loginPage("/userLogin").permitAll();

    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder
                .authenticationProvider(customAuthenticationProvier);
    }
}
