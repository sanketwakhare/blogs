package com.core.app.blogs.roles;

import com.core.app.blogs.common.dtos.Message;
import com.core.app.blogs.roles.dtos.AssignRolesRequestDTO;
import com.core.app.blogs.roles.dtos.CreateRoleRequestDTO;
import com.core.app.blogs.roles.dtos.RoleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(@Autowired RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody CreateRoleRequestDTO requestDTO) {
        // save role to db
        RoleModel savedRole = roleService.createRole(requestDTO.getRole());
        // populate response
        RoleResponseDTO responseDTO = new RoleResponseDTO();
        responseDTO.setRole(savedRole.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping("/assign")
    public ResponseEntity<Message> assignRoles(@RequestBody AssignRolesRequestDTO requestDTO) {
        String userId = requestDTO.getUserId();
        RoleType[] roles = requestDTO.getRoles();

        roleService.assignRoles(userId, roles);
        Message message = new Message("Roles assigned successfully");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

}
