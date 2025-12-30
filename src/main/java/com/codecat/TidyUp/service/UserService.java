package com.codecat.TidyUp.service;

import com.codecat.TidyUp.model.User;
import com.codecat.TidyUp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User createUser (User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        String username = user.getUsername();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }
    public void deleteUser(Long user_id){
        userRepository.deleteById(user_id);
    }
    public Optional<User> getUserInfo(Long user_id){
        return userRepository.findById(user_id);
    }
}

