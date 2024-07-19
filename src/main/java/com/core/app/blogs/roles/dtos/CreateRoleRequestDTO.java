package com.core.app.blogs.roles.dtos;

import com.core.app.blogs.roles.RoleType;
import lombok.Data;

@Data
public class CreateRoleRequestDTO {
    private RoleType role;
}
