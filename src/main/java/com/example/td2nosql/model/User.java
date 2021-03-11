package com.example.td2nosql.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.management.relation.Role;
import java.util.List;


@Document(collection = "user")
public class User {


    @Id
    private String id;

    private String username;

    private String email;

    public String password;

    private Role role;

    @DBRef
    private List<Article> articles;

    public User(){}

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
//        user.setRole(new Role(Integer.valueOf(1), user));
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

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Article> getArticles() {
        return articles;
    }

}