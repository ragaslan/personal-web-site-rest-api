package com.ragaslan.rest.controller;

import com.ragaslan.rest.dto.ResponseDTO;
import com.ragaslan.rest.dto.UserDTO;
import com.ragaslan.rest.entity.User;
import com.ragaslan.rest.service.AuthService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<String>> login(@Valid @RequestBody UserDTO userDTO){
        ModelMapper mapper = new ModelMapper();
        User userFromReq = mapper.map(userDTO, User.class);
        String authToken = authService.login(userFromReq);
        return new ResponseEntity<>(new ResponseDTO<>(true,authToken),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(){
        return new ResponseEntity<>("register func",HttpStatus.OK);
    }

}
