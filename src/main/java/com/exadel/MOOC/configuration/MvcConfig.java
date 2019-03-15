package com.exadel.MOOC.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/course-page").setViewName("course-page");
        registry.addViewController("/lesson-page").setViewName("lesson-page");
        registry.addViewController("/courses").setViewName("courses");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/users").setViewName("users");
        registry.addViewController("/course-preview-page").setViewName("course-preview-page");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/pages/");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }
}
