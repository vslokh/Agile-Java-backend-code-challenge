package com.optimalVirtualEmployee.usermanagement.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String name;
    private String email;
    private String gender;
    private String picture;
}