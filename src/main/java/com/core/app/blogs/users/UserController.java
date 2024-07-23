package com.core.app.blogs.users;

import com.core.app.blogs.users.dtos.CreateUserRequestDTO;
import com.core.app.blogs.users.dtos.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ModelMapper modelMapper;
    public final UserService userService;

    public UserController(@Autowired ModelMapper modelMapper, @Autowired UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserRequestDTO requestDTO) {
        UserModel savedUser = userService.createUser(requestDTO.getEmail(), requestDTO.getPassword());

        // populate response
        UserResponseDTO userResponseDTO = modelMapper.map(savedUser, UserResponseDTO.class);
        UserUtils.mapRoles(savedUser, userResponseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    // TODO: get user by Id
    // TODO : delete user [ADMIN] - toggle isDeleted flag
}
