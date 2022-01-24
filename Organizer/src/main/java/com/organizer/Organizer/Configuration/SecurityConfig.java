package com.organizer.Organizer.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic().disable();
        http
            .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/perform-login")
            .defaultSuccessUrl("/tasks.html", true)
            .failureUrl("/login.html?error=true")
            .and()
            .logout()
            .logoutUrl("/perform-logout")
            .deleteCookies("JSESSIONID");
    }
}
