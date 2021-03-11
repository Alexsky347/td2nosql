package com.example.td2nosql.repository;
import com.example.td2nosql.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
