package com.example.td2nosql.model;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_USER,
  ROLE_MODERATOR,
  ROLE_ADMIN;

  public String getAuthority() {
    return name();
  }

}
