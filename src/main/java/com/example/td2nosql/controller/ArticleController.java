package com.example.td2nosql.controller;
import com.example.td2nosql.model.Article;
import com.example.td2nosql.model.User;
import com.example.td2nosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.example.td2nosql.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ArticleController extends Exception{

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/articles")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Article> getArticleById(@PathVariable("id") String id) {
        return articleRepository.findById(id);
    }

    @PostMapping("/add_article")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Article createArticle(Authentication authentication, @RequestBody Article articleArg) {
        User user = userRepository.findByUsername(authentication.getName());
        return articleRepository.save(new Article(articleArg.getAuthor(), articleArg.getTitle(), articleArg.getDescription(), articleArg.getDateCitation(),  user));
    }

    @PutMapping("/articles/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Optional<Article> updateTutorial(@PathVariable("id") String id, @RequestBody Article articleArg) {
        Optional<Article> article = getArticleById(id);

        if (article.isPresent()) {
            Article _article = article.get();
            _article.setAuthor(articleArg.getAuthor());
            _article.setTitle(articleArg.getTitle());
            _article.setDescription(articleArg.getDescription());
            _article.setVisible(articleArg.isVisible());
            articleRepository.save(_article);
        }
        return article;
    }

    @DeleteMapping("/articles/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTutorial(@PathVariable("id") String id) {
            articleRepository.deleteById(id);

    }

    @DeleteMapping("/articles")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAllTutorials() {
            articleRepository.deleteAll();
    }
}