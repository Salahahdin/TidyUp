package com.codecat.TidyUp.repository;
;
import com.codecat.TidyUp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;



public class UserRepository {
    public interface UserRepo extends JpaRepository<User, Long> {
    }
}
