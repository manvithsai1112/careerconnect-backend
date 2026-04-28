package com.career.platform.service;

import com.career.platform.entity.User;
import com.career.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("STUDENT");
        }
        return userRepository.save(user);
    }

    public Optional<User> loginUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }

    public User updateUserSkills(String username, String skills) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setSkills(skills);
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found");
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateProfileData(String username, User updatedUser) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
            if (updatedUser.getSkills() != null) user.setSkills(updatedUser.getSkills());
            // Role and Username are typically not changeable by the user directly
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found");
    }
}
