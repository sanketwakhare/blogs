package com.core.app.blogs.users;

import com.core.app.blogs.users.dtos.UserResponseDTO;

import java.util.HashSet;
import java.util.Set;

public class UserUtils {

    public static void mapRoles(UserModel user, UserResponseDTO userResponseDTO) {
        // set roles
        Set<String> roles = new HashSet<>();
        user.getRoles().forEach(role -> roles.add(role.getRole().name()));
        userResponseDTO.setRoles(roles);
    }
}
