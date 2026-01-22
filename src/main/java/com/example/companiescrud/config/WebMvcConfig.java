package com.example.companiescrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    // Sin resource handlers personalizados para permitir /swagger-ui/** y /webjars/** por defecto.
}
