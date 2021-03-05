//package com.example.td2nosql.controller;
//import com.example.td2nosql.model.User;
//import com.example.td2nosql.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String username) {
//
//    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
//
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//
//    }
//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
//
//    }
//
//
//}