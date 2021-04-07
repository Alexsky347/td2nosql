package com.example.td2nosql.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.management.relation.Role;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Document(collection = "user")
public class User {


    @Id
    private String id;

    @Indexed(unique=true)
    @NotBlank
    @Size(max = 120)
    private String username;

    private String email;

    @NotBlank
    @Size(max = 120)
    public String password;


    @DBRef
    private Set<Role> roles = new HashSet<>();


    @DBRef
    private List<Article> articles;

    public User(){}


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}