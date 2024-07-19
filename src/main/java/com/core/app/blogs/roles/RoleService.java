package com.core.app.blogs.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<RoleModel> getRoles(Set<RoleType> roleTypes) {
        List<RoleModel> roles = roleRepository.findAll();
        List<RoleModel> requiredRoles = roles.stream().filter(r -> roleTypes.contains(r.getRole())).toList();
        return new HashSet<>(requiredRoles);
    }
}
