package com.example.td2nosql.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.management.relation.Role;
import java.util.List;


@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String username;

    private String email;

    private boolean published;

    private Role role;

    @DBRef
    private List<Article> articles;

    public User(){}

    public User(String id, String username, String email, boolean published, Role role, List<Article> articles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.published = published;
        this.role = role;
        this.articles = articles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}