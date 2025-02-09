package com.optimalVirtualEmployee.usermanagement.controller;

import com.optimalVirtualEmployee.usermanagement.model.User;
import com.optimalVirtualEmployee.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

/**
 * Controller class to manage User-related APIs.
 * Provides endpoints for creating, retrieving, updating, and deleting users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Retrieve all users.
     *
     * @return List of all users.
     */
    @Operation(summary = "Get all users")
    @GetMapping("/")
    public List<User> getAllUsers() {
        logger.info("API Call: Get all users");
        return userService.getAllUsers();
    }

    /**
     * Retrieve a user by username.
     *
     * @param username Unique username of the user.
     * @return User details if found, 404 Not Found otherwise.
     */
    @Operation(summary = "Get user by username")
    @GetMapping("/{username}/")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        logger.info("API Call: Get user by username - {}", username);
        return userService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new user.
     *
     * @param user User object containing user details.
     * @return Created user details.
     */
    @Operation(summary = "Create a new user")
    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        logger.info("API Call: Create user - {}", user);
        return userService.createUser(user);
    }

    /**
     * Update an existing user.
     *
     * @param username Username of the user to update.
     * @param user User object containing updated details.
     * @return Updated user details.
     */
    @Operation(summary = "Update existing user")
    @PutMapping("/{username}/")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        logger.info("API Call: Update user - {}", username);
        return userService.updateUser(username, user);
    }

    /**
     * Delete a user by username.
     *
     * @param username Username of the user to delete.
     * @return No content response if deletion is successful.
     */
    @Operation(summary = "Delete a user")
    @DeleteMapping("/{username}/")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        logger.info("API Call: Delete user - {}", username);
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}