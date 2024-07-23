package com.core.app.blogs.users.dtos;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDTO {
    private String id;
    private String email;
    private String name;
    private String bio;
    private Set<String> roles;
    private String createdAt;
    private String updatedAt;
}
