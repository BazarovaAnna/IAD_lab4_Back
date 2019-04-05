package com.example.lab.web;

import com.example.lab.database.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class WebConfig {
    @Autowired
    ResultsRepository resultsRepository;


    @Bean
    HttpSessionListener listener(){
        return new HttpSessionListener() {
            public void sessionDestroyed(HttpSessionEvent se) {
                System.out.println(resultsRepository.deleteAllBySessionid(se.getSession().getId()));
            }
        };
    }

    @Bean
    HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }
}
