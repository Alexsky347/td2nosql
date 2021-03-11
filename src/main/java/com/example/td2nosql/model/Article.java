package com.example.td2nosql.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "article")
public class Article {
    @Id
    private String id;

    private String title;

    private String description;

    private boolean visible;

    private Date created;

    @DBRef
    private User user;

    public Article(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.visible = true;
        this.created = new Date();
        this.user = user;
    }
    public Article(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
