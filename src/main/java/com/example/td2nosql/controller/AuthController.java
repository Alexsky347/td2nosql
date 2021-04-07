package com.example.td2nosql.controller;
import com.example.td2nosql.model.AuthRequest;
import com.example.td2nosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, String> generateToken(@Valid @RequestBody AuthRequest authRequest) throws Exception {
        return userService.login(authRequest.getUsername(), authRequest.getPassword());
    }
}