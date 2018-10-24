package com.tsi.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/panel").setViewName("panel");

        registry.addViewController("/panel/add").setViewName("panel/add");
        registry.addViewController("/panel/edit").setViewName("panel/edit");
        registry.addViewController("/panel/remove").setViewName("panel/remove");
    }
}
