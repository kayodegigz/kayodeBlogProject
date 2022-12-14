package com.isw.kayodeproject.repository;

import com.isw.kayodeproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


//    User findByName(String name);

    User findByName(String name);
}
