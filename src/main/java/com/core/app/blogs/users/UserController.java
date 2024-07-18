package com.core.app.blogs.users;

import com.core.app.blogs.users.dtos.CreateUserRequestDTO;
import com.core.app.blogs.users.dtos.CreateUserResponseDTO;
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

    public UserController(@Autowired ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO requestDTO) {
        UserModel requestUser = modelMapper.map(requestDTO, UserModel.class);
        CreateUserResponseDTO userResponseDTO = modelMapper.map(requestUser, CreateUserResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }
}
