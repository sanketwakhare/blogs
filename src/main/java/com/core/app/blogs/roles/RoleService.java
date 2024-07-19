package com.core.app.blogs.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final IRoleRepository roleRepository;

    public RoleService(@Autowired IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleModel createRole(RoleType roleName) {
        RoleModel role = new RoleModel();
        role.setRole(roleName);
        return roleRepository.save(role);
    }
}
