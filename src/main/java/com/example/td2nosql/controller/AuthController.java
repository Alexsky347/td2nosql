package com.example.td2nosql.controller;
import com.example.td2nosql.model.AuthRequest;
import com.example.td2nosql.model.User;
import com.example.td2nosql.repository.UserRepository;
import com.example.td2nosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, String> generateToken(@Valid @RequestBody AuthRequest authRequest) throws Exception {
        return userService.login(authRequest.getUsername(), authRequest.getPassword());
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepository.save(new User(
                user.getUsername(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword())
        ));
    }
}