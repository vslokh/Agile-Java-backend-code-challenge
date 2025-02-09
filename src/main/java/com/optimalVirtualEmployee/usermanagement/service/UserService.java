package com.optimalVirtualEmployee.usermanagement.service;

import com.optimalVirtualEmployee.usermanagement.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * UserService handles all business logic related to user management.
 * This includes operations such as creating, retrieving, updating, and deleting users.
 * It uses an in-memory data store (HashMap) to manage users.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final Map<String, User> userStore = new HashMap<>();

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return new ArrayList<>(userStore.values());
    }

    public Optional<User> getUserByUsername(String username) {
        logger.info("Fetching user with username: {}", username);
        return Optional.ofNullable(userStore.get(username));
    }

    public User createUser(User user)  {
        logger.info("Creating new user: {}", user);
        if (userStore.containsKey(user.getUsername())) {
            logger.warn("Attempt to create duplicate user: {}", user.getUsername());
            throw new RuntimeException("User already exists");
        }
        userStore.put(user.getUsername(), user);
        return user;
    }

    public User updateUser(String username, User userDetails) {
        logger.info("Updating user with username: {}", username);
        if (userStore.containsKey(username)) {
            User user = userStore.get(username);
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setGender(userDetails.getGender());
            user.setPicture(userDetails.getPicture());
            logger.info("Updated user details: {}", user);
            return user;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteUser(String username) {
        logger.info("Deleting user with username: {}", username);
        if (userStore.containsKey(username)) {
            userStore.remove(username);
            logger.info("User deleted successfully: {}", username);
        } else {
            logger.error("User not found for deletion: {}", username);
            throw new RuntimeException("User not found");
        }
    }
}