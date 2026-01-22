package com.example.companiescrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    // Eliminados los resource handlers para permitir que Spring Boot y springdoc
    // gestionen /swagger-ui/** y /webjars/** automáticamente.
}
