package com.example.td2nosql.controller;

import com.example.td2nosql.model.AuthRequest;
import com.example.td2nosql.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("TAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(authRequest.getUsername());
        System.out.println(authRequest.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            System.out.println(ex);
            return "invalid username/password";
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
