package com.careydevelopment.oauth2test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.careydevelopment.oauth2test.model.User;

@SpringBootApplication
@EnableResourceServer
public class AuthorizationServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
        
    }

}