package com.example.td2nosql.controller;

import com.example.td2nosql.model.AuthRequest;
import com.example.td2nosql.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authenticate")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public Serializable generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            System.out.println(ex);
            return "invalid username/password";
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwtUtil.generateToken(authRequest.getUsername()));

        return map;
    }
}
