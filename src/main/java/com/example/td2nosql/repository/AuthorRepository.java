package com.example.td2nosql.repository;
import com.example.td2nosql.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AuthorRepository extends MongoRepository<Author, String> {

}