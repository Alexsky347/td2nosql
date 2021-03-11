package com.example.td2nosql.controller;
import com.example.td2nosql.model.User;
import com.example.td2nosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController extends Exception{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



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

    @PostMapping("/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepository.save(new User(
                user.getUsername(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                user.getRole()
                ));
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