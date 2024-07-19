package com.core.app.blogs.users;

import com.core.app.blogs.roles.RoleModel;
import com.core.app.blogs.roles.RoleService;
import com.core.app.blogs.roles.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final RoleService roleService;
    private final IUserRepository userRepository;

    public UserService(@Autowired RoleService roleService, @Autowired IUserRepository userRepository) {
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    public UserModel createUser(String email, String password) {
        UserModel userModel = new UserModel();
        userModel.setEmail(email);
        userModel.setPassword(password);

        // populate roles
        Set<RoleModel> roles = roleService.getRoles(Set.of(RoleType.USER, RoleType.AUTHOR));
        userModel.setRoles(roles);

        // save user
        return userRepository.save(userModel);
    }
}
