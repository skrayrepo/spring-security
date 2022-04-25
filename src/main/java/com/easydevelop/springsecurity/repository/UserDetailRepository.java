package com.easydevelop.springsecurity.repository;

import com.easydevelop.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
