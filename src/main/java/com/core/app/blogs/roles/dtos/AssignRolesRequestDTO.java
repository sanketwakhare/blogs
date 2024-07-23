package com.core.app.blogs.roles.dtos;

import com.core.app.blogs.roles.RoleType;
import lombok.Data;

import java.util.UUID;

@Data
public class AssignRolesRequestDTO {
    private UUID userId;
    private RoleType[] roles;
}
