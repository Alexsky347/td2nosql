package com.example.td2nosql.repository;
import com.example.td2nosql.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);

    //    @Transactional
    void deleteByUsername(String username);

    User findByUsername(String username);

}
