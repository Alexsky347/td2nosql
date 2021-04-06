package com.example.td2nosql.repository;
import com.example.td2nosql.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, String> {
    List<Article> findByCreated(Date created);
}
