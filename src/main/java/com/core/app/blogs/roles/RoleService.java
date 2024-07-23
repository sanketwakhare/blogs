package com.core.app.blogs.roles;

import com.core.app.blogs.users.IUserRepository;
import com.core.app.blogs.users.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class RoleService {

    private final IRoleRepository roleRepository;
    private final IUserRepository userRepository;

    public RoleService(@Autowired IRoleRepository roleRepository, @Autowired IUserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
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

    public void assignRoles(String userId, RoleType[] roles) {
        Optional<UserModel> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            // invalid user
            throw new RuntimeException("Invalid User");
        }
        UserModel userModel = user.get();
        Set<RoleModel> existingRoles = userModel.getRoles();
        for (RoleType roleName : roles) {
            Optional<RoleModel> role = roleRepository.findByRoleName(roleName);
            if (role.isPresent()) {
                RoleModel roleModel = role.get();
                existingRoles.add(roleModel);
            }
        }
        userRepository.save(userModel);
    }
}
