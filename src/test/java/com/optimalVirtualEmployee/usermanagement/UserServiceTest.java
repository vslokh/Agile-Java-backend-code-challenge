package com.optimalVirtualEmployee.usermanagement;

import com.optimalVirtualEmployee.usermanagement.model.User;
import com.optimalVirtualEmployee.usermanagement.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setUsername("johndoe");
        testUser.setName("John Doe");
        testUser.setEmail("john.doe@example.com");
        testUser.setGender("Male");
        testUser.setPicture("http://example.com/picture.jpg");

        userService.createUser(testUser);
    }

    @Test
    public void testCreateUser() {
        User newUser = new User();
        newUser.setUsername("janedoe");
        newUser.setName("Jane Doe");
        newUser.setEmail("jane.doe@example.com");
        newUser.setGender("Female");
        newUser.setPicture("http://example.com/jane.jpg");

        User createdUser = userService.createUser(newUser);
        assertNotNull(createdUser);
        assertEquals("janedoe", createdUser.getUsername());
    }

    @Test
    public void testGetUserByUsername() {
        Optional<User> foundUser = userService.getUserByUsername("johndoe");
        assertTrue(foundUser.isPresent());
        assertEquals("John Doe", foundUser.get().getName());
    }

    @Test
    public void testUpdateUser() {
        User updatedDetails = new User();
        updatedDetails.setName("John Updated");
        updatedDetails.setEmail("john.updated@example.com");
        updatedDetails.setGender("Male");
        updatedDetails.setPicture("http://example.com/john_updated.jpg");

        User updatedUser = userService.updateUser("johndoe", updatedDetails);
        assertNotNull(updatedUser);
        assertEquals("John Updated", updatedUser.getName());
        assertEquals("john.updated@example.com", updatedUser.getEmail());
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser("johndoe");
        Optional<User> deletedUser = userService.getUserByUsername("johndoe");
        assertFalse(deletedUser.isPresent());
    }

    @Test
    public void testGetNonExistingUser() {
        Optional<User> nonExistingUser = userService.getUserByUsername("unknown");
        assertFalse(nonExistingUser.isPresent());
    }

    @Test
    public void testUpdateNonExistingUser() {
        User updatedDetails = new User();
        updatedDetails.setName("Ghost User");
        updatedDetails.setEmail("ghost@example.com");
        updatedDetails.setGender("Unknown");
        updatedDetails.setPicture("http://example.com/ghost.jpg");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.updateUser("ghost", updatedDetails);
        });

        assertEquals("User not found", exception.getMessage());
    }
}
