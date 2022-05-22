package com.example.demo;

import com.example.demo.repository.entity.Authentication;
import com.example.demo.repository.entity.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("damansa")
//                .password("1234")
//                .roles("admin");
//
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello").authenticated()
                //.antMatchers("/employee/**").hasAuthority(Authentication.Role.admin.name())
                .antMatchers("/employee/**").hasAuthority(Authorization.Role.staff.name())
                .and()
                .formLogin().loginPage("/myCustomLogin").loginProcessingUrl("/process-login")
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")
//                .httpBasic()
                .and().logout();
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
