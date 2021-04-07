package com.example.td2nosql.controller;
import com.example.td2nosql.model.User;
import com.example.td2nosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController extends Exception{

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUser(Authentication authentication) {
        System.out.println(userRepository.findByUsername(authentication.getName()));
        return userRepository.findByUsername(authentication.getName());
    }

    @GetMapping("/users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @GetMapping("/users/username/{username}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }


    @PutMapping("/users/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Optional<User> updateUser(@PathVariable("id") String id, @RequestBody User articleArg) {
        Optional<User> article = getUserById(id);

        if (article.isPresent()) {
            User _article = article.get();
            _article.setUsername(articleArg.getUsername());
            _article.setEmail(articleArg.getEmail());
            userRepository.save(_article);
        }
        return article;
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id) {
        userRepository.deleteById(id);

    }

    @DeleteMapping("/users")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

//    @GetMapping("/articles/published")
//    public ResponseEntity<List<Tutorial>> findByAuthor() {
//
//    }

}