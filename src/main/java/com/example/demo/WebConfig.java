package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/myCustomLogin").setViewName("login");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/accessDenied").setViewName("accessDenied");
    }
}
