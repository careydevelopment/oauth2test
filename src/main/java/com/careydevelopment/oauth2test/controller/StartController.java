package com.careydevelopment.oauth2test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careydevelopment.oauth2test.model.User;
import com.careydevelopment.oauth2test.repository.UserRepository;

@RestController
public class StartController {

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping("/start")
	public Object start(Model model) {
		System.err.println("in start");
        User user = new User();
        user.setUsername("john");
        user.setPassword(encoder.encode("123"));

        repository.save(user);
        
        return new Object();
	}
}
