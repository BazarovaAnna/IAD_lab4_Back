package com.example.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class LabApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(LabApplication.class, args);
        while(true);
    }

}

