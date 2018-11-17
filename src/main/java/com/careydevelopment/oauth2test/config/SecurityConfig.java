package com.careydevelopment.oauth2test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.careydevelopment.oauth2test.service.UserService;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http.requestMatchers()
            .antMatchers("/login", "/oauth/authorize")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .permitAll();
    } // @formatter:on

    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
//        http.authorizeRequests().antMatchers("/start").permitAll();
//    } // @formatter:on
    
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off
//        auth.inMemoryAuthentication()
//            .withUser("john")
//            .password(passwordEncoder().encode("123"))
//            .roles("USER");
//    } // @formatter:on

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
      builder.userDetailsService(userService);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
