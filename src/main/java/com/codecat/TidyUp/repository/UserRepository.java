package com.codecat.TidyUp.repository;
;
import com.codecat.TidyUp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
    }

