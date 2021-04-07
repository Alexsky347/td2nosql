package com.example.td2nosql;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class Td2nosqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Td2nosqlApplication.class, args);
    }


}
