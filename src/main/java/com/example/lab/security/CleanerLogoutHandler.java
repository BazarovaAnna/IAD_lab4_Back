package com.example.lab.security;

import com.example.lab.database.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Transactional
@Component
public class CleanerLogoutHandler implements LogoutHandler {

    @Autowired
    ResultsRepository resultsRepository;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        System.out.println(resultsRepository.deleteAllBySessionid(httpServletRequest.getSession().getId()));
    }
}
